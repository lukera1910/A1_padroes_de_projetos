package questao_3;

import java.util.ArrayList;
import java.util.List;

public class TopicoNoticia implements TopicoObservavel {
    private String nome;
    private String descricao;
    // Lista de observers (leitores inscritos) - gerenciada automaticamente
    private List<ObservadorLeitor> leitoresInscritos;
    private int totalNoticasPublicadas;
    
    public TopicoNoticia(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.leitoresInscritos = new ArrayList<>();
        this.totalNoticasPublicadas = 0;
    }
    
    @Override
    public void inscrever(ObservadorLeitor leitor) {
        if (!leitoresInscritos.contains(leitor)) {
            leitoresInscritos.add(leitor);
            System.out.printf("✓ %s inscrito em '%s'\n", leitor.obterNome(), nome);
        } else {
            System.out.printf("⚠ %s já está inscrito em '%s'\n", leitor.obterNome(), nome);
        }
    }
    
    @Override
    public void desinscrever(ObservadorLeitor leitor) {
        if (leitoresInscritos.remove(leitor)) {
            System.out.printf("✓ %s desinscrito de '%s'\n", leitor.obterNome(), nome);
        } else {
            System.out.printf("⚠ %s não estava inscrito em '%s'\n", leitor.obterNome(), nome);
        }
    }
    
    @Override
    public void notificarLeitores(Noticia noticia) {
        /*
         * Este é o coração do padrão Observer:
         * Automaticamente notifica TODOS os leitores inscritos
         * sem necessidade de controle manual
         */
        System.out.printf("\n📢 Notificando %d leitor(es) sobre nova notícia em '%s'...\n", 
                         leitoresInscritos.size(), nome);
        
        for (ObservadorLeitor leitor : leitoresInscritos) {
            leitor.atualizar(noticia);
        }
    }
    
    // Método para publicar notícia - dispara notificação automática
    public void publicarNoticia(Noticia noticia) {
        totalNoticasPublicadas++;
        System.out.println("\n" + "=".repeat(70));
        System.out.printf("📰 NOVA NOTÍCIA PUBLICADA EM '%s'\n", nome.toUpperCase());
        System.out.println("=".repeat(70));
        System.out.printf("Título: %s\n", noticia.getTitulo());
        System.out.printf("Urgência: %s\n", noticia.getUrgencia());
        
        // Notifica todos os inscritos automaticamente
        notificarLeitores(noticia);
    }
    
    @Override
    public String obterNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public int getTotalInscritos() {
        return leitoresInscritos.size();
    }
    
    public int getTotalNoticasPublicadas() {
        return totalNoticasPublicadas;
    }
}
