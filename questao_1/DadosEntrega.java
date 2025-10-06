package questao_1;

// Classe de dados para armazenar informações da entrega
public class DadosEntrega {
    private double distancia;
    private double peso;
    private double volume;
    private boolean urgente;

    public DadosEntrega(double distancia, double peso, double volume, boolean urgente) {
        this.distancia = distancia;
        this.peso = peso;
        this.volume = volume;
        this.urgente = urgente;
    }

    public double getDistancia() { return distancia; }
    public double getPeso() { return peso; }
    public double getVolume() { return volume; }
    public boolean isUrgente() { return urgente; }
}
