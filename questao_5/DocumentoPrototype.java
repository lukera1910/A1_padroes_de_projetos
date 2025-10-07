package questao_5;

// Prototype Interface - Define o contrato para objetos clonáveis
public interface DocumentoPrototype extends Cloneable {
    DocumentoPrototype clonar();
    void personalizar(String cliente, String corPrimaria, String fonte, String logoUrl);
    String visualizar();
    String obterTipo();
}
