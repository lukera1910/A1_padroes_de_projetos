package questao_5;

public class Main {
    public static void main(String[] args) {
        System.out.println("║      SISTEMA DE TEMPLATES DE DOCUMENTOS - PADRÃO PROTOTYPE       ║");
        
        // Inicializa o registro de protótipos
        RegistroTemplates registro = new RegistroTemplates();
        registro.listarTemplates();
        
        System.out.println("\n" + "═".repeat(70));
        System.out.println("EXEMPLO 1: Gerando currículos personalizados para 3 clientes");
        System.out.println("═".repeat(70) + "\n");
        
        // Clona o template e personaliza para cada cliente
        DocumentoPrototype curriculo1 = registro.obterTemplate("curriculo-moderno");
        curriculo1.personalizar("João Silva", "#E74C3C", "Roboto", "joao_logo.png");
        
        DocumentoPrototype curriculo2 = registro.obterTemplate("curriculo-moderno");
        curriculo2.personalizar("Maria Santos", "#9B59B6", "Open Sans", "maria_logo.png");
        
        DocumentoPrototype curriculo3 = registro.obterTemplate("curriculo-classico");
        curriculo3.personalizar("Carlos Souza", "#16A085", "Georgia", "carlos_logo.png");
        
        System.out.println("\n→ Visualizando currículo de João:");
        System.out.println(curriculo1.visualizar());
        
        System.out.println("\n" + "═".repeat(70));
        System.out.println("EXEMPLO 2: Gerando propostas comerciais personalizadas");
        System.out.println("═".repeat(70) + "\n");
        
        DocumentoPrototype proposta1 = registro.obterTemplate("proposta-premium");
        proposta1.personalizar("Tech Solutions LTDA", "#27AE60", "Montserrat", "tech_logo.png");
        if (proposta1 instanceof TemplateProposta) {
            ((TemplateProposta) proposta1).definirValor(50000.00);
        }
        
        DocumentoPrototype proposta2 = registro.obterTemplate("proposta-basica");
        proposta2.personalizar("StartUp Inovadora", "#F39C12", "Lato", "startup_logo.png");
        
        System.out.println("→ Visualizando proposta para Tech Solutions:");
        System.out.println(proposta1.visualizar());
        
        System.out.println("\n" + "═".repeat(70));
        System.out.println("EXEMPLO 3: Gerando relatórios com mesmo template, estilos diferentes");
        System.out.println("═".repeat(70) + "\n");
        
        DocumentoPrototype relatorio1 = registro.obterTemplate("relatorio-mensal");
        relatorio1.personalizar("Empresa Alpha", "#2980B9", "Calibri", "alpha_logo.png");
        
        DocumentoPrototype relatorio2 = registro.obterTemplate("relatorio-mensal");
        relatorio2.personalizar("Empresa Beta", "#C0392B", "Arial", "beta_logo.png");
        
        System.out.println("→ Visualizando relatório da Empresa Alpha:");
        System.out.println(relatorio1.visualizar());
        
        // Demonstra eficiência do padrão
        System.out.println("\n" + "═".repeat(70));
        System.out.println("BENEFÍCIOS DO PROTOTYPE PATTERN:");
        System.out.println("═".repeat(70));
        System.out.println("✓ Clonagem rápida: não recria estrutura complexa do zero");
        System.out.println("✓ Personalização independente: cada cópia é modificada isoladamente");
        System.out.println("✓ Registro central: templates disponíveis para toda a aplicação");
        System.out.println("✓ Reduz acoplamento: cliente não conhece classes concretas");
        System.out.println("✓ Performance: clonagem > reconstrução completa");
        System.out.println("✓ Flexibilidade: novos templates facilmente adicionados ao registro");
        System.out.println("═".repeat(70));
        
        // Estatísticas
        System.out.println("\nESTATÍSTICAS DA SESSÃO:");
        System.out.println("   • 3 currículos gerados (2 modernos, 1 clássico)");
        System.out.println("   • 2 propostas geradas (1 premium, 1 básica)");
        System.out.println("   • 2 relatórios gerados (ambos mensais)");
        System.out.println("   • Total: 7 documentos personalizados a partir de 6 templates");
        System.out.println("   • 0 criações do zero = 100% eficiência através de clonagem!");
    }
}
