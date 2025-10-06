package questao_1;

// Interfacy Strategy - Define o contrato comum para todos os algoritmos de cálculo
public interface EstrategiaTarifa {
    double calcularTarifa(DadosEntrega dados);
    String obterDescricao();
}
