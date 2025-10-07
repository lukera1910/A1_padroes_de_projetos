package questao_5;

import java.util.HashMap;
import java.util.Map;

// Prototype Registry - Gerenciador central de protótipos
public class RegistroTemplates {
    private Map<String, DocumentoPrototype> templates;
    
    public RegistroTemplates() {
        this.templates = new HashMap<>();
        carregarTemplatesPadrao();
    }
    
    private void carregarTemplatesPadrao() {
        // Registra templates padrão disponíveis
        registrar("curriculo-classico", new TemplateCurriculo("TMPL-CV-001", "Clássico"));
        registrar("curriculo-moderno", new TemplateCurriculo("TMPL-CV-002", "Moderno"));
        registrar("proposta-basica", new TemplateProposta("Básico"));
        registrar("proposta-premium", new TemplateProposta("Premium"));
        registrar("relatorio-mensal", new TemplateRelatorio("Mensal"));
        registrar("relatorio-anual", new TemplateRelatorio("Anual"));
        
        System.out.println("✓ " + templates.size() + " templates carregados no registro\n");
    }
    
    public void registrar(String chave, DocumentoPrototype prototipo) {
        templates.put(chave, prototipo);
    }
    
    /*
     * Método principal: clona um protótipo registrado
     * Cliente não precisa conhecer a classe concreta do template
     */
    public DocumentoPrototype obterTemplate(String chave) {
        DocumentoPrototype prototipo = templates.get(chave);
        if (prototipo == null) {
            throw new IllegalArgumentException("Template não encontrado: " + chave);
        }
        return prototipo.clonar();
    }
    
    public void listarTemplates() {
        System.out.println("TEMPLATES DISPONÍVEIS:");
        System.out.println("-".repeat(70));
        templates.forEach((chave, template) -> {
            System.out.printf("  [%s] - %s\n", chave, template.obterTipo());
        });
        System.out.println("-".repeat(70));
    }
}
