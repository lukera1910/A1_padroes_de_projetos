package questao_4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Classe para representar um pedido
public class Pedido {
    private String id;
    private LocalDate data;
    private String cliente;
    private double valorTotal;
    private String status;
    private String categoria;
    
    public Pedido(String id, LocalDate data, String cliente, double valorTotal, 
                  String status, String categoria) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = status;
        this.categoria = categoria;
    }
    
    public String getId() { return id; }
    public LocalDate getData() { return data; }
    public String getCliente() { return cliente; }
    public double getValorTotal() { return valorTotal; }
    public String getStatus() { return status; }
    public String getCategoria() { return categoria; }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Pedido #%s | %s | %s | R$ %.2f | %s",
            id, data.format(formatter), cliente, valorTotal, status);
    }
}
