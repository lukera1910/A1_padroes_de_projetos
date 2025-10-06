package questao_3;

import java.util.HashSet;
import java.util.Set;

// Concrete Observer 3 - Leitor via notificação push (app mobile)
public class LeitorPush implements ObservadorLeitor {
    private String nome;
    private String deviceId;
    private Set<String> topicosPreferidos;
    
    public LeitorPush(String nome, String deviceId) {
        this.nome = nome;
        this.deviceId = deviceId;
        this.topicosPreferidos = new HashSet<>();
    }
    
    @Override
    public void atualizar(Noticia noticia) {
        String icone = determinarIcone(noticia.getTopico());
        String mensagem = String.format(
            "📲 PUSH para %s (Device: %s)\n" +
            "   %s %s\n" +
            "   %s",
            nome, deviceId, icone, noticia.getTitulo(),
            noticia.getConteudo().substring(0, Math.min(50, noticia.getConteudo().length())) + "..."
        );
        
        System.out.println(mensagem);
        topicosPreferidos.add(noticia.getTopico());
    }
    
    private String determinarIcone(String topico) {
        switch (topico.toLowerCase()) {
            case "política": return "🏛️";
            case "esportes": return "⚽";
            case "tecnologia": return "💻";
            case "economia": return "💰";
            default: return "📰";
        }
    }
    
    @Override
    public String obterNome() {
        return nome;
    }
    
    @Override
    public String obterEmail() {
        return deviceId;
    }
}
