package questao_1;

public class Main {
    public static void main(String[] args) {
        // Criando o contexto 
        ServicoTransporte servico = new ServicoTransporte();

        // Dados de exemplo
        DadosEntrega entrega1 = new DadosEntrega(500, 150, 2.5, true);
        DadosEntrega entrega2 = new DadosEntrega(3000, 80, 1.2, false);
        DadosEntrega entrega3 = new DadosEntrega(8000, 5000, 25, false);

        System.out.println("=== SISTEMA DE CÁLCULO DE TARIFAS ===\n");

        // Testando transporte terrestre
        System.out.println("--- ENTREGA 1 ---");
        System.out.println("Distância: 500 km | Peso: 150 kg | Volume: 2.5 m³ | Urgente: Sim\n");

        servico.setEstrategia(new TransporteTerrestre());
        System.out.println(servico.obterDescricaoModalidade());
        System.out.printf("Tarifa: R$ %.2f\n\n", servico.calcularCustoEntrega(entrega1));

        // Testando com dados diferentes 
        System.out.println("--- ENTREGA 2 ---");
        System.out.println("Distância: 3000 km | Peso: 80 kg | Volume: 1.2 m³ | Urgente: Não\n");

        servico.setEstrategia(new TransporteTerrestre());
        System.out.printf("%s: R$ %.2f\n", servico.obterDescricaoModalidade(), 
                            servico.calcularCustoEntrega(entrega2));

        servico.setEstrategia(new TransporteAereo());
        System.out.printf("%s: R$ %.2f\n", servico.obterDescricaoModalidade(),
                            servico.calcularCustoEntrega(entrega2));

        servico.setEstrategia(new TransporteMaritimo());
        System.out.printf("%s: R$ %.2f\n\n", servico.obterDescricaoModalidade(),
                            servico.calcularCustoEntrega(entrega3));

        // Demonstrando grande volume maritimo
        System.out.println("--- ENTREGA 3 (GRANDE VOLUME) ---");
        System.out.println("Distância: 8000 km | Peso: 5000 kg | Volume: 25 m³ | Urgente: Não\n");

        servico.setEstrategia(new TransporteMaritimo());
        System.out.printf("%s: R$ %.2f\n", servico.obterDescricaoModalidade(),
                            servico.calcularCustoEntrega(entrega3));
    }
}
