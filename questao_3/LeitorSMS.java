package questao_3;

// Concrete Observer 2 - Leitor que recebe via SMS (Comportamento diferente)
public class LeitorSMS implements ObservadorLeitor {
    private String nome;
    private String telefone;
    private boolean apenasUrgentes;
    private int notificacoesRecebidas;
    
    public LeitorSMS(String nome, String telefone, boolean apenasUrgentes) {
        this.nome = nome;
        this.telefone = telefone;
        this.apenasUrgentes = apenasUrgentes;
        this.notificacoesRecebidas = 0;
    }
    
    @Override
    public void atualizar(Noticia noticia) {
        // Observer pode ter lógica condicional própria
        if (apenasUrgentes && !noticia.getUrgencia().equals("URGENTE")) {
            return; // Ignora notícias não urgentes
        }
        
        String icone = noticia.getUrgencia().equals("URGENTE") ? "🚨" : "📱";
        String mensagem = String.format(
            "%s SMS para %s (%s)\n" +
            "   %s - %s",
            icone, nome, telefone, noticia.getTopico(), noticia.getTitulo()
        );
        
        System.out.println(mensagem);
        notificacoesRecebidas++;
    }
    
    @Override
    public String obterNome() {
        return nome;
    }
    
    @Override
    public String obterEmail() {
        return telefone; // Retorna telefone no lugar de email
    }
    
    public int getNotificacoesRecebidas() {
        return notificacoesRecebidas;
    }
}
