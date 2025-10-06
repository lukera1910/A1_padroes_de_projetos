package questao_1;

// Concrete 2
public class TransporteAereo implements EstrategiaTarifa {
    private static final double TARIFA_BASE = 200.0;
    private static final double TARIFA_POR_KG = 8.0;
    private static final double TAXA_SEGURO = 0.02; // 2% do valor por peso

    @Override
    public double calcularTarifa(DadosEntrega dados) {
        // Regra: Tarifa baseada principalmente no peso da carga
        double tarifa = TARIFA_BASE + (dados.getPeso() * TARIFA_POR_KG);

        // Taxa de seguro proporcional ao peso
        tarifa += tarifa * TAXA_SEGURO;

        // Adicional por volume (densidade da carga)
        double pesoVoluntario = dados.getVolume() * 200; // 200 kg por m³
        if (pesoVoluntario > dados.getPeso()) {
            tarifa += (pesoVoluntario - dados.getPeso()) * 2.0;
        }

        // Desconto para longas distâncias (economia de escala)
        if (dados.getDistancia() > 2000) {
            tarifa *= 0.9; // 10% de desconto
        }

        return tarifa;
    }

    @Override
    public String obterDescricao() {
        return "Transporte Aéreo - Cálculo baseado em peso e volume";
    }
}
