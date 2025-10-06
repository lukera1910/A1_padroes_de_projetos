package questao_4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Componente Concreto - Relatório básico (componente base)
public class RelatorioBasico implements Relatorio {
    private List<Pedido> pedidos;
    private String titulo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    
    public RelatorioBasico(List<Pedido> pedidos, LocalDate dataInicio, LocalDate dataFim) {
        this.pedidos = pedidos;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.titulo = "Relatório de Vendas";
    }
    
    @Override
    public String gerar() {
        /*
         * Relatório básico contém apenas a lista de pedidos
         * Funcionalidades adicionais são adicionadas via decoradores
         */
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        sb.append(String.format("║  %-63s  ║\n", titulo.toUpperCase()));
        sb.append(String.format("Período: %s a %s\n", 
            dataInicio.format(formatter), dataFim.format(formatter)));
        sb.append(String.format("Total de pedidos: %d\n\n", pedidos.size()));
        
        sb.append("LISTA DE PEDIDOS:\n");
        sb.append("-".repeat(70)).append("\n");
        
        for (Pedido pedido : pedidos) {
            sb.append(pedido.toString()).append("\n");
        }
        
        return sb.toString();
    }
    
    @Override
    public List<Pedido> obterPedidos() {
        return new ArrayList<>(pedidos);
    }
    
    @Override
    public String obterTitulo() {
        return titulo;
    }
}