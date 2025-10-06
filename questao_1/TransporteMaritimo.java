package questao_1;

// Concrete 3
public class TransporteMaritimo implements EstrategiaTarifa {
    private static final double TARIFA_BASE = 300.0;
    private static final double TARIFA_POR_M3 = 150.0;
    private static final double TAXA_PORTO = 100.0;

    @Override
    public double calcularTarifa(DadosEntrega dados) {
        // Regra: Tarifa baseada principalmente no volume (containers)
        double tarifa = TARIFA_BASE + (dados.getVolume() * TARIFA_POR_M3);

        // Taxa fixa de movimentação portuária
        tarifa += TAXA_PORTO;

        // Adicional por peso excessivo em relação ao volume 
        double densidadeMaxima = dados.getVolume() * 500; // 500 kg por m³
        if (dados.getPeso() > densidadeMaxima) {
            tarifa += (dados.getPeso() - densidadeMaxima) * 0.3;
        }

        // Desconto para grandes volumes (mais de 20 m³)
        if (dados.getVolume() > 20) {
            tarifa *= 0.85; // 15% de desconto
        }

        return tarifa;
    }

    @Override
    public String obterDescricao() {
        return "Transporte Maritimo - Cálculo baseado em volume (m³)";
    }
}
