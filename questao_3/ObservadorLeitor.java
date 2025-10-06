package questao_3;

// Observer Interface - Define o contrato para todos os observadores (leitores)
public interface ObservadorLeitor {
    void atualizar(Noticia noticia);
    String obterNome();
    String obterEmail();
}