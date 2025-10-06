package questao_2;

// Factory - Responsável pela criação dos processadores
public class ProcessadorPagamentoFactory {
    // Enum para tipos de pagamento (facilita configuração)
    public enum TipoPagamento {
        CARTAO_CREDITO,
        BOLETO,
        PIX
    }

    /*
     * Método Factory - Cria instâncias de processadores sem expor
     * a lógica de criação ao cliente
     */
    public static ProcessadorPagamento criarProcessador(TipoPagamento tipo) {
        switch (tipo) {
            case CARTAO_CREDITO:
                return new ProcessadorCartaoCredito();
            case BOLETO:
                return new ProcessadorBoleto();
            case PIX:
                return new ProcessadorPix();
            default:
                throw new IllegalArgumentException("Tipo de pagamento não suportado: " + tipo);
        }
    }

    /*
     * Método alternativo que aceita String - útil para configurações externas
     */
    public static ProcessadorPagamento criarProcessador(String tipoStr) {
        try {
            TipoPagamento tipo = TipoPagamento.valueOf(tipoStr.toUpperCase());
            return criarProcessador(tipo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de pagamento inválido: " + tipoStr);
        }
    }
}