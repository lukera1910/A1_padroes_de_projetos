package questao_3;

import java.util.HashMap;
import java.util.Map;

// Gerenciamento de noticías
public class SistemaNotificacoes {
    private Map<String, TopicoNoticia> topicos;
    
    public SistemaNotificacoes() {
        this.topicos = new HashMap<>();
    }
    
    public TopicoNoticia criarTopico(String nome, String descricao) {
        TopicoNoticia topico = new TopicoNoticia(nome, descricao);
        topicos.put(nome.toLowerCase(), topico);
        System.out.printf("✓ Tópico '%s' criado\n", nome);
        return topico;
    }
    
    public TopicoNoticia obterTopico(String nome) {
        return topicos.get(nome.toLowerCase());
    }
    
    public void exibirResumo() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("📊 RESUMO DO SISTEMA");
        System.out.println("=".repeat(70));
        
        topicos.forEach((key, topico) -> {
            System.out.printf("\n📁 %s\n", topico.obterNome());
            System.out.printf("   Inscritos: %d | Notícias publicadas: %d\n",
                topico.getTotalInscritos(), topico.getTotalNoticasPublicadas());
        });
    }
}
