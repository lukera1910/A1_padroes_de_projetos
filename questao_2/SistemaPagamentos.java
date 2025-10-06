package questao_2;

// Sistema de Pagamentos - Cliente que usa a Factory
public class SistemaPagamentos {
    /*
     * Método principal que processa pagamentos de forma genérica
     * Note que não conhece as classes concretas dos processadores
     */
    public ResultadoPagamento processarPagamento(
        ProcessadorPagamentoFactory.TipoPagamento tipoPagamento,
        DadosPagamento dados) {

            // Factory cria o processador apropriado dinamicamente
            ProcessadorPagamento processador = ProcessadorPagamentoFactory.criarProcessador(tipoPagamento);

            System.out.println("PROCESSANDO: " + processador.obterTipo());
            System.out.println("Valor: R$ " + String.format("%.2f", dados.getValor()));

            // Processa o pagamento usando polimorfismo
            ResultadoPagamento resultado = processador.processar(dados);

            return resultado;
    }
}
