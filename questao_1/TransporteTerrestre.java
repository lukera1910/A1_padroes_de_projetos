package questao_1;

// Concrete Strategy 1
public class TransporteTerrestre implements EstrategiaTarifa {
    private static final double TARIFA_BASE = 50.0;
    private static final double TARIFA_POR_KM = 2.5;
    private static final double ADICIONAL_URGENCIA = 0.3; // 30% extra

    @Override
    public double calcularTarifa(DadosEntrega dados) {
        // Regra: Tarifa baseada principalmente na distância
        double tarifa = TARIFA_BASE + (dados.getDistancia() * TARIFA_POR_KM);

        // Adicional para entregas urgentes
        if (dados.isUrgente()) {
            tarifa *= (1 + ADICIONAL_URGENCIA);
        }

        // Pequeno adicional por peso acima de 100 kg
        if (dados.getPeso() > 100) {
            tarifa += (dados.getPeso() - 100) * 0.5;
        }

        return tarifa;
    }

    @Override
    public String obterDescricao() {
        return "Transporte Terrestre - Cálculo baseado em distância";
    }
}
