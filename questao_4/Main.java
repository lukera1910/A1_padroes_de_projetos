package questao_4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE RELATÓRIOS DE VENDAS - PADRÃO DECORATOR");
                
        // Dados de exemplo
        List<Pedido> pedidos = Arrays.asList(
            new Pedido("001", LocalDate.of(2025, 10, 1), "João Silva", 150.00, "Finalizado", "Eletrônicos"),
            new Pedido("002", LocalDate.of(2025, 10, 1), "Maria Santos", 85.50, "Finalizado", "Livros"),
            new Pedido("003", LocalDate.of(2025, 10, 2), "Carlos Souza", 320.00, "Finalizado", "Eletrônicos"),
            new Pedido("004", LocalDate.of(2025, 10, 3), "Ana Costa", 45.00, "Pendente", "Livros"),
            new Pedido("005", LocalDate.of(2025, 10, 3), "João Silva", 200.00, "Finalizado", "Moda"),
            new Pedido("006", LocalDate.of(2025, 10, 4), "Pedro Alves", 120.00, "Finalizado", "Eletrônicos"),
            new Pedido("007", LocalDate.of(2025, 10, 5), "Maria Santos", 90.00, "Finalizado", "Livros"),
            new Pedido("008", LocalDate.of(2025, 10, 6), "João Silva", 180.00, "Pendente", "Moda")
        );
        
        LocalDate dataInicio = LocalDate.of(2025, 10, 1);
        LocalDate dataFim = LocalDate.of(2025, 10, 6);
        
        // EXEMPLO 1: Relatório básico (sem decoradores)
        System.out.println("═══ EXEMPLO 1: RELATÓRIO BÁSICO ═══\n");
        Relatorio relatorioBasico = new RelatorioBasico(pedidos, dataInicio, dataFim);
        System.out.println(relatorioBasico.gerar());
        
        System.out.println("\n\n" + "█".repeat(70) + "\n");
        
        // EXEMPLO 2: Relatório com estatísticas
        System.out.println("═══ EXEMPLO 2: RELATÓRIO + ESTATÍSTICAS ═══\n");
        Relatorio relatorioComEstatisticas = new DecoradorEstatisticas(
            new RelatorioBasico(pedidos, dataInicio, dataFim)
        );
        System.out.println(relatorioComEstatisticas.gerar());
        
        System.out.println("\n\n" + "█".repeat(70) + "\n");
        
        // EXEMPLO 3: Relatório completo (múltiplos decoradores encadeados)
        System.out.println("═══ EXEMPLO 3: RELATÓRIO COMPLETO (TODOS OS RECURSOS) ═══\n");
        
        /*
         * PODER DO DECORATOR: Combinação flexível de funcionalidades!
         * Cada decorador adiciona uma camada de funcionalidade
         * sem modificar o código existente
         */
        Relatorio relatorioCompleto = new DecoradorExportacaoPDF(
            new DecoradorTendencias(
                new DecoradorGraficos(
                    new DecoradorEstatisticas(
                        new RelatorioBasico(pedidos, dataInicio, dataFim)
                    )
                )
            ),
            "/relatorios/vendas_outubro_2025.pdf"
        );
        
        System.out.println(relatorioCompleto.gerar());
        
        System.out.println("\n\n" + "█".repeat(70) + "\n");
        
        // EXEMPLO 4: Combinação personalizada (estatísticas + PDF, sem gráficos)
        System.out.println("═══ EXEMPLO 4: COMBINAÇÃO PERSONALIZADA ═══\n");
        Relatorio relatorioPersonalizado = new DecoradorExportacaoPDF(
            new DecoradorEstatisticas(
                new RelatorioBasico(pedidos, dataInicio, dataFim)
            ),
            "/relatorios/resumo_executivo.pdf"
        );
        
        System.out.println(relatorioPersonalizado.gerar());
        
        // Demonstra a flexibilidade do padrão
        System.out.println("\n" + "═".repeat(70));
        System.out.println("FLEXIBILIDADE DO DECORATOR:");
        System.out.println("   • Relatório básico permanece intacto");
        System.out.println("   • Funcionalidades adicionadas dinamicamente");
        System.out.println("   • Combinações personalizáveis em tempo de execução");
        System.out.println("   • Sem modificação do código original");
        System.out.println("   • Fácil adicionar novos decoradores no futuro");
        System.out.println("═".repeat(70));
    }
}
