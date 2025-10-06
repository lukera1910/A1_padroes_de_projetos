package questao_4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Concrete Decorator 4 - Adiciona análise de tendências
public class DecoradorTendencias extends RelatorioDecorator {
    public DecoradorTendencias(Relatorio relatorio) {
        super(relatorio);
    }
    
    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder();
        
        // Mantém conteúdo anterior
        sb.append(relatorioDecorado.gerar());
        
        // Adiciona análise de tendências
        sb.append("\n").append("=".repeat(70)).append("\n");
        sb.append("ANÁLISE DE TENDÊNCIAS\n");
        sb.append("=".repeat(70)).append("\n");
        
        List<Pedido> pedidos = obterPedidos();
        
        // Análise de crescimento
        List<Pedido> pedidosOrdenados = pedidos.stream()
            .sorted(Comparator.comparing(Pedido::getData))
            .collect(Collectors.toList());
        
        if (pedidosOrdenados.size() >= 2) {
            int metade = pedidosOrdenados.size() / 2;
            double vendasPrimeiraMetade = pedidosOrdenados.subList(0, metade).stream()
                .mapToDouble(Pedido::getValorTotal).sum();
            double vendasSegundaMetade = pedidosOrdenados.subList(metade, pedidosOrdenados.size()).stream()
                .mapToDouble(Pedido::getValorTotal).sum();
            
            double crescimento = ((vendasSegundaMetade - vendasPrimeiraMetade) / vendasPrimeiraMetade) * 100;
            
            sb.append(String.format("Tendência de Crescimento: %.1f%%", crescimento));
            if (crescimento > 0) {
                sb.append(" ↗(Positiva)\n");
            } else {
                sb.append(" ↘(Negativa)\n");
            }
        }
        
        // Categoria em alta
        Map<String, Long> pedidosPorCategoria = pedidos.stream()
            .collect(Collectors.groupingBy(Pedido::getCategoria, Collectors.counting()));
        
        Optional<Map.Entry<String, Long>> categoriaTop = pedidosPorCategoria.entrySet().stream()
            .max(Map.Entry.comparingByValue());
        
        if (categoriaTop.isPresent()) {
            sb.append(String.format("Categoria em Alta: %s (%d pedidos)\n",
                categoriaTop.get().getKey(), categoriaTop.get().getValue()));
        }
        
        // Cliente mais frequente
        Map<String, Long> pedidosPorCliente = pedidos.stream()
            .collect(Collectors.groupingBy(Pedido::getCliente, Collectors.counting()));
        
        Optional<Map.Entry<String, Long>> clienteTop = pedidosPorCliente.entrySet().stream()
            .max(Map.Entry.comparingByValue());
        
        if (clienteTop.isPresent()) {
            sb.append(String.format("Cliente Destaque: %s (%d compras)\n",
                clienteTop.get().getKey(), clienteTop.get().getValue()));
        }
        
        return sb.toString();
    }
}