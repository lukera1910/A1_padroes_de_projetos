package questao_3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Classe que representa uma notícia
public class Noticia {
    private String titulo;
    private String conteudo;
    private String autor;
    private String topico;
    private LocalDateTime dataPublicacao;
    private String urgencia; // "NORMAL", "IMPORTANTE", "URGENTE"

    public Noticia(String titulo, String conteudo, String autor, String topico, String urgencia) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
        this.topico = topico;
        this.urgencia = urgencia;
        this.dataPublicacao = LocalDateTime.now();
    }
    
    public String getTitulo() { return titulo; }
    public String getConteudo() { return conteudo; }
    public String getAutor() { return autor; }
    public String getTopico() { return topico; }
    public LocalDateTime getDataPublicacao() { return dataPublicacao; }
    public String getUrgencia() { return urgencia; }
    
    public String formatarDataPublicacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataPublicacao.format(formatter);
    }
}
