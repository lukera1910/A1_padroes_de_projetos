package questao_4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Concrete Decorator 2 - Adiciona gráficos e análises visuais
public class DecoradorGraficos extends RelatorioDecorator {
    public DecoradorGraficos(Relatorio relatorio) {
        super(relatorio);
    }
    
    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder();
        
        // Mantém o conteúdo anterior
        sb.append(relatorioDecorado.gerar());
        
        // Adiciona gráficos
        sb.append("\n").append("=".repeat(70)).append("\n");
        sb.append("GRÁFICOS E ANÁLISES VISUAIS\n");
        sb.append("=".repeat(70)).append("\n");
        
        List<Pedido> pedidos = obterPedidos();
        
        // Gráfico de vendas por categoria
        sb.append("\nVendas por Categoria:\n");
        Map<String, Double> vendasPorCategoria = pedidos.stream()
            .collect(Collectors.groupingBy(
                Pedido::getCategoria,
                Collectors.summingDouble(Pedido::getValorTotal)
            ));
        
        double maxValor = vendasPorCategoria.values().stream()
            .max(Double::compare).orElse(1.0);
        
        vendasPorCategoria.forEach((categoria, valor) -> {
            int barras = (int) ((valor / maxValor) * 40);
            sb.append(String.format("  %-15s │", categoria));
            sb.append("█".repeat(Math.max(1, barras)));
            sb.append(String.format(" R$ %.2f\n", valor));
        });
        
        // Gráfico de status dos pedidos
        sb.append("\n▶ Status dos Pedidos:\n");
        Map<String, Long> statusCount = pedidos.stream()
            .collect(Collectors.groupingBy(Pedido::getStatus, Collectors.counting()));
        
        long maxCount = statusCount.values().stream().max(Long::compare).orElse(1L);
        
        statusCount.forEach((status, count) -> {
            int barras = (int) ((count * 30.0) / maxCount);
            sb.append(String.format("  %-15s │", status));
            sb.append("▓".repeat(Math.max(1, barras)));
            sb.append(String.format(" %d pedido(s)\n", count));
        });
        
        // Timeline simplificada
        sb.append("\nTimeline de Vendas (últimos 7 dias):\n");
        Map<LocalDate, Long> vendasPorDia = pedidos.stream()
            .collect(Collectors.groupingBy(Pedido::getData, Collectors.counting()));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        vendasPorDia.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                int barras = entry.getValue().intValue();
                sb.append(String.format("  %s │", entry.getKey().format(formatter)));
                sb.append("●".repeat(Math.max(1, barras)));
                sb.append(String.format(" (%d)\n", entry.getValue()));
            });
        
        return sb.toString();
    }
}
