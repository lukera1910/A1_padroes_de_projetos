package questao_2;

// Classe de dados para informações de pagamento
public class DadosPagamento {
    private String id;
    private double valor;
    private String clienteId;
    private String descricao;

    // Campos específicos para diferentes meios
    private String numeroCartao;
    private String cvv;
    private String validadeCartao;
    private String chavePix;

    public DadosPagamento(String id, double valor, String clienteId, String descricao) {
        this.id = id;
        this.valor = valor;
        this.clienteId = clienteId;
        this.descricao = descricao;
    }

    public String getId() { return id; }
    public double getValor() { return valor; }
    public String getClienteId() { return clienteId; }
    public String getDescricao() { return descricao; }
    public String getNumeroCartao() { return numeroCartao; }
    public String getCvv() { return cvv; }
    public String getValidadeCartao() { return validadeCartao; }
    public String getChavePix() { return chavePix; }

    public void setDadosCartao(String numeroCartao, String cvv, String validadeCartao) {
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
        this.validadeCartao = validadeCartao;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
