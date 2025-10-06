package questao_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Concrete Observer 1 - Leitor comum por email
public class LeitorEmail implements ObservadorLeitor {
    private String nome;
    private String email;
    private List<String> historicoNotificacoes;
    private Map<String, Integer> contagemPorTopico;
    
    public LeitorEmail(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.historicoNotificacoes = new ArrayList<>();
        this.contagemPorTopico = new HashMap<>();
    }
    
    @Override
    public void atualizar(Noticia noticia) {
        /*
         * Quando notificado, o observer processa a notícia
         * de acordo com sua própria lógica
         */
        String mensagem = String.format(
            "EMAIL enviado para %s (%s)\n" +
            "   Assunto: [%s] %s\n" +
            "   Publicado por: %s às %s",
            nome, email, noticia.getTopico(), noticia.getTitulo(),
            noticia.getAutor(), noticia.formatarDataPublicacao()
        );
        
        System.out.println(mensagem);
        
        // Armazena histórico
        historicoNotificacoes.add(noticia.getTitulo());
        contagemPorTopico.merge(noticia.getTopico(), 1, Integer::sum);
    }
    
    @Override
    public String obterNome() {
        return nome;
    }
    
    @Override
    public String obterEmail() {
        return email;
    }
    
    public void exibirEstatisticas() {
        System.out.printf("\nEstatísticas de %s:\n", nome);
        System.out.printf("   Total de notificações: %d\n", historicoNotificacoes.size());
        System.out.println("   Por tópico:");
        contagemPorTopico.forEach((topico, qtd) -> 
            System.out.printf("      • %s: %d notícia(s)\n", topico, qtd)
        );
    }
}
