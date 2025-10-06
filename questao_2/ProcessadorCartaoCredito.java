package questao_2;

import java.util.Random;

// Concrete 1
public class ProcessadorCartaoCredito implements ProcessadorPagamento {
    private static final double TAXA_PROCESSAMENTO = 0.029; // 2.9%

    @Override
    public boolean validar(DadosPagamento dados) {
        if (dados.getNumeroCartao() == null || dados.getNumeroCartao().length() != 16) {
            return false;
        }
        if (dados.getCvv() == null || dados.getCvv().length() != 3) {
            return false;
        }
        if (dados.getValor() <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public ResultadoPagamento processar(DadosPagamento dados) {
        if (!validar(dados)) {
            return new ResultadoPagamento(
                false, 
                "Dados do cartão inválidos",
                null);
        }

        // Simulação de processamento com operadora
        System.out.println("-> Conectando com operadora do cartão...");
        System.out.println("-> Validando cartão: ****" + 
                            dados.getNumeroCartao().substring(12));
        System.out.println("-> Verificando limites e fraudes...");

        // Simula aprovação (90% de chance)
        boolean aprovado = new Random().nextInt(10) < 9;

        if (aprovado) {
            double taxa = dados.getValor() * TAXA_PROCESSAMENTO;
            String transacaoId = "CC" + System.currentTimeMillis();

            return new ResultadoPagamento(
                true,
                String.format("Pagamento aprovado. Taxa: R$ %.2f", taxa),
                transacaoId
            );
        } else {
            return new ResultadoPagamento(
                false, 
                "Pagamento recusado pela operadora", 
                null
            );
        }
    }

    @Override
    public String obterTipo() {
        return "Cartão de Crédito";
    }
}
