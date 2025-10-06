package questao_2;

import java.util.Random;

// Concrete 2
public class ProcessadorBoleto implements ProcessadorPagamento {
    private static final double TAXA_FIXA = 3.50;

    @Override
    public boolean validar(DadosPagamento dados) {
        return dados.getValor() > 0 && dados.getClienteId() != null;
    }

    @Override
    public ResultadoPagamento processar(DadosPagamento dados) {
        if (!validar(dados)) {
            return new ResultadoPagamento(
                false, 
                "Dados insuficientes para gerar boleto", 
                null
            );
        }

        // Simulação de geração de boleto
        System.out.println("-> Gerando boleto bancário...");
        System.out.println("-> Calculando data de vencimento...");
        System.out.println("-> Registrando no banco...");

        String codigoBarras = gerarCodigoBarras();
        String transacaoId = "BOL" + System.currentTimeMillis();

        return new ResultadoPagamento(
            true, 
            String.format("Boleto gerado. Código de barras: %s\nTaxa: R$ %.2f\nVencimento: 3 dias", 
                    codigoBarras, TAXA_FIXA), 
                    transacaoId
            );
    }

    private String gerarCodigoBarras() {
        Random rand = new Random();
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 47; i++) {
            codigo.append(rand.nextInt(10));
            if ((i + 1) % 5 == 0 && i < 46) codigo.append(".");
        }
        return codigo.toString();
    }

    @Override
    public String obterTipo() {
        return "Boleto Bancário";
    }
}
