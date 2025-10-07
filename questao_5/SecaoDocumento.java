package questao_5;

import java.util.ArrayList;
import java.util.List;

// Classe auxiliar para seções do documento
public class SecaoDocumento implements Cloneable {
    private String titulo;
    private List<String> conteudos;
    
    public SecaoDocumento(String titulo) {
        this.titulo = titulo;
        this.conteudos = new ArrayList<>();
    }
    
    public void adicionarConteudo(String conteudo) {
        conteudos.add(conteudo);
    }
    
    @Override
    protected SecaoDocumento clone() {
        try {
            SecaoDocumento clonado = (SecaoDocumento)super.clone();
            // Deep copy da lista de conteúdos
            clonado.conteudos = new ArrayList<>(this.conteudos);
            return clonado;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar SecaoDocumento", e);
        }
    }
    
    public String getTitulo() { return titulo; }
    public List<String> getConteudos() { return conteudos; }
}
