package questao_2;

public class Main {
    public static void main(String[] args) {
        SistemaPagamentos sistema = new SistemaPagamentos();

        System.out.println("PLATAFORMA DE PAGAMENTOS - DEMONSTRAÇÃO");

        // Cenário 1: Pagamento com Cartão de Crédito
        DadosPagamento pagamento1 = new DadosPagamento(
            "PED001", 250.00, "CLI12345", "Compra de eletrônicos"
        );
        pagamento1.setDadosCartao("1234567890123456", "123", "12/2027");

        ResultadoPagamento resultado1 = sistema.processarPagamento(
            ProcessadorPagamentoFactory.TipoPagamento.CARTAO_CREDITO,
            pagamento1
        );
        System.out.println("\n" + resultado1);

        // Cenário 2: Pagamento com Boleto
        System.out.println("\n" + "=".repeat(55));
        DadosPagamento pagamento2 = new DadosPagamento(
            "PED002", 150.00, "CLI67890", "Mensalidade curso"
        );

        ResultadoPagamento resultado2 = sistema.processarPagamento(
            ProcessadorPagamentoFactory.TipoPagamento.BOLETO,
            pagamento2
        );
        System.out.println("\n" + resultado2);

        // Cenário 3: Pagamento com PIX
        System.out.println("\n" + "=".repeat(55));
        DadosPagamento pagamento3 = new DadosPagamento(
            "PED003", 89.90, "CLI11111", "Delivery restaurante"
        );
        pagamento3.setChavePix("meuemail@exemplo.com");

        ResultadoPagamento resultado3 = sistema.processarPagamento(
            ProcessadorPagamentoFactory.TipoPagamento.PIX,
            pagamento3
        );
        System.out.println("\n" + resultado3);

        // Demonstração de configuração via String (ex: arquivo config)
        System.out.println("\n" + "=".repeat(55));
        System.out.println("\n[Simulando configuração externa]");
        String meioPagamentoConfig = "PIX"; // Poderia vir de properties/yml

        DadosPagamento pagamento4 = new DadosPagamento(
            "PED004", 500.00, "CLI22222", "Pagamento freelancer"
        );
        pagamento4.setChavePix("+5544999887766");

        // Factory aceita String para facilitar integração com configs
        ProcessadorPagamento processadorDinamico = ProcessadorPagamentoFactory.criarProcessador(meioPagamentoConfig);

        System.out.println("Meio de pagamento configurado: " + 
                            processadorDinamico.obterTipo());
        ResultadoPagamento resultado4 = processadorDinamico.processar(pagamento4);
        System.out.println(resultado4);
    }
}
