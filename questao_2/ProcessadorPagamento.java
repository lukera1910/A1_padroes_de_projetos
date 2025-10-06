package questao_2;

// Product Interface - Define o contrato comum para todos os processadores
public interface ProcessadorPagamento {
    ResultadoPagamento processar(DadosPagamento dados);
    String obterTipo();
    boolean validar(DadosPagamento dados);
} 
