package questao_4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// Concrete Decorator 1 - Adiciona estatisticas de faturamento
public class DecoradorEstatisticas extends RelatorioDecorator {
    public DecoradorEstatisticas(Relatorio relatorio) {
        super(relatorio);
    }
    
    @Override
    public String gerar() {
        /*
         * Adiciona estatísticas ao relatório existente
         * sem modificar o componente original
         */
        StringBuilder sb = new StringBuilder();
        
        // Mantém o conteúdo original
        sb.append(relatorioDecorado.gerar());
        
        // Adiciona nova funcionalidade
        sb.append("\n").append("=".repeat(70)).append("\n");
        sb.append("ESTATÍSTICAS DE FATURAMENTO\n");
        sb.append("=".repeat(70)).append("\n");
        
        List<Pedido> pedidos = obterPedidos();
        
        // Calcula estatísticas
        double faturamentoTotal = pedidos.stream()
            .mapToDouble(Pedido::getValorTotal)
            .sum();
        
        double ticketMedio = pedidos.isEmpty() ? 0 : faturamentoTotal / pedidos.size();
        
        Optional<Pedido> maiorPedido = pedidos.stream()
            .max(Comparator.comparing(Pedido::getValorTotal));
        
        Optional<Pedido> menorPedido = pedidos.stream()
            .min(Comparator.comparing(Pedido::getValorTotal));
        
        long pedidosFinalizados = pedidos.stream()
            .filter(p -> p.getStatus().equals("Finalizado"))
            .count();
        
        long pedidosPendentes = pedidos.stream()
            .filter(p -> p.getStatus().equals("Pendente"))
            .count();
        
        // Formata estatísticas
        sb.append(String.format("Faturamento Total: R$ %.2f\n", faturamentoTotal));
        sb.append(String.format("Ticket Médio: R$ %.2f\n", ticketMedio));
        sb.append(String.format("Pedidos Finalizados: %d (%.1f%%)\n", 
            pedidosFinalizados, (pedidosFinalizados * 100.0) / pedidos.size()));
        sb.append(String.format("Pedidos Pendentes: %d (%.1f%%)\n", 
            pedidosPendentes, (pedidosPendentes * 100.0) / pedidos.size()));
        
        if (maiorPedido.isPresent()) {
            sb.append(String.format("\nMaior Pedido: #%s - R$ %.2f (%s)\n",
                maiorPedido.get().getId(),
                maiorPedido.get().getValorTotal(),
                maiorPedido.get().getCliente()));
        }
        
        if (menorPedido.isPresent()) {
            sb.append(String.format("Menor Pedido: #%s - R$ %.2f (%s)\n",
                menorPedido.get().getId(),
                menorPedido.get().getValorTotal(),
                menorPedido.get().getCliente()));
        }
        
        return sb.toString();
    }
}
