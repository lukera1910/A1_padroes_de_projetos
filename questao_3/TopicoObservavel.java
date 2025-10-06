package questao_3;

// Subject Interface - Define o contrato para os subjects (tópicos observáveis)
public interface TopicoObservavel {
    void inscrever(ObservadorLeitor leitor);
    void desinscrever(ObservadorLeitor leitor);
    void notificarLeitores(Noticia noticia);
    String obterNome();
}
