package questao_2;

import java.util.Random;

// Concrete 3
public class ProcessadorPix implements ProcessadorPagamento {
    private static final double TAXA_PERCENTUAL = 0.0099; // 0.99%

    @Override
    public boolean validar(DadosPagamento dados) {
        if (dados.getChavePix() == null || dados.getChavePix().isEmpty()) {
            return false;
        }
        return dados.getValor() > 0;
    }

    @Override
    public ResultadoPagamento processar(DadosPagamento dados) {
        if (!validar(dados)) {
            return new ResultadoPagamento(
                false, 
               "Chave PIX inválida ou ausente", 
               null
            );
        }

        // Simulação de processamento PIX
        System.out.println("-> Iniciando transação PIX...");
        System.out.println("-> Validando chave: " + dados.getChavePix());
        System.out.println("-> Consultando DICT do Banco Central...");
        System.out.println("-> Transferindo valores...");

        // PIX tem alta taxa de sucesso (95%)
        boolean sucesso = new Random().nextInt(100) < 95;

        if (sucesso) {
            double taxa = dados.getValor() * TAXA_PERCENTUAL;
            String transacaoId = "PIX" + System.currentTimeMillis();

            return new ResultadoPagamento(
                true, 
                String.format("PIX realizado com sucesso! Taxa: R$ %.2f\nComprovante disponível", taxa), 
                transacaoId
            );
        } else {
            return new ResultadoPagamento(
                false, 
                "Erro na transação PIX. Tente novamente", 
                null
            );
        }
    }

    @Override
    public String obterTipo() {
        return "PIX";
    }
}
