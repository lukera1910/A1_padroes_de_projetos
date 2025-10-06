package questao_3;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE NOTIFICAÇÕES DE NOTÍCIAS - PADRÃO OBSERVER");

        // Inicializa o sistema
        SistemaNotificacoes sistema = new SistemaNotificacoes();
        
        // Cria tópicos (Subjects)
        TopicoNoticia politica = sistema.criarTopico("Política", "Notícias sobre política nacional e internacional");
        TopicoNoticia esportes = sistema.criarTopico("Esportes", "Cobertura esportiva completa");
        TopicoNoticia tecnologia = sistema.criarTopico("Tecnologia", "Últimas novidades em tech");
        TopicoNoticia economia = sistema.criarTopico("Economia", "Mercado financeiro e economia");
        
        System.out.println("\n" + "-".repeat(70));
        
        // Cria leitores (Observers) com diferentes comportamentos
        LeitorEmail joao = new LeitorEmail("João Silva", "joao@email.com");
        LeitorEmail maria = new LeitorEmail("Maria Santos", "maria@email.com");
        LeitorSMS carlos = new LeitorSMS("Carlos Souza", "+55-44-99999-1111", true); // Apenas urgentes
        LeitorSMS ana = new LeitorSMS("Ana Costa", "+55-44-99999-2222", false); // Todas
        LeitorPush pedro = new LeitorPush("Pedro Alves", "DEVICE-ABC-123");
        
        // Inscrições (attach observers to subjects)
        System.out.println("\n🔔 GERENCIANDO INSCRIÇÕES:");
        politica.inscrever(joao);
        politica.inscrever(maria);
        politica.inscrever(carlos);
        
        esportes.inscrever(joao);
        esportes.inscrever(pedro);
        esportes.inscrever(ana);
        
        tecnologia.inscrever(maria);
        tecnologia.inscrever(pedro);
        tecnologia.inscrever(carlos);
        
        economia.inscrever(joao);
        economia.inscrever(maria);
        economia.inscrever(ana);
        
        // Publicando notícias - notificação automática!
        politica.publicarNoticia(new Noticia(
            "Congresso aprova nova reforma tributária",
            "Após meses de debates, a reforma foi aprovada por maioria...",
            "Redação Política",
            "Política",
            "IMPORTANTE"
        ));
        
        esportes.publicarNoticia(new Noticia(
            "Brasil vence por 3x1 nas eliminatórias",
            "Com gols de Neymar, Vinicius Jr. e Richarlison...",
            "Redação Esportes",
            "Esportes",
            "NORMAL"
        ));
        
        tecnologia.publicarNoticia(new Noticia(
            "URGENTE: Falha de segurança crítica descoberta",
            "Especialistas recomendam atualização imediata de todos os sistemas...",
            "Tech News",
            "Tecnologia",
            "URGENTE"
        ));
        
        economia.publicarNoticia(new Noticia(
            "Bolsa sobe 2% com otimismo do mercado",
            "Investidores reagem positivamente às medidas econômicas...",
            "Financial Times",
            "Economia",
            "NORMAL"
        ));
        
        // Demonstrando desinscrição
        System.out.println("\n" + "-".repeat(70));
        System.out.println("\n📤 GERENCIANDO DESINSCRIÇÕES:");
        politica.desinscrever(maria);
        
        // Publica mais uma notícia - Maria não será notificada
        politica.publicarNoticia(new Noticia(
            "Presidente anuncia novos ministros",
            "Mudanças na equipe ministerial foram confirmadas hoje...",
            "Redação Política",
            "Política",
            "IMPORTANTE"
        ));
        
        // Exibe estatísticas
        joao.exibirEstatisticas();
        maria.exibirEstatisticas();
        
        System.out.printf("\n📊 Carlos (SMS Urgentes): %d notificação(ões) recebida(s)\n", 
                         carlos.getNotificacoesRecebidas());
        
        // Resumo final
        sistema.exibirResumo();
    }
}
