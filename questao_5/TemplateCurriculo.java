package questao_5;

import java.util.ArrayList;
import java.util.List;

// Concrete Prototype 1 = Template do Currículo
public class TemplateCurriculo implements DocumentoPrototype {
    private String nomeCliente;
    private EstiloVisual estilo;
    private List<SecaoDocumento> secoes;
    private String layout;
    private String templateId;
    
    public TemplateCurriculo(String templateId, String layout) {
        this.templateId = templateId;
        this.layout = layout;
        this.nomeCliente = "[Nome do Cliente]";
        
        // Estilo padrão do template
        this.estilo = new EstiloVisual(
            "#2C3E50", // Azul escuro
            "#ECF0F1", // Cinza claro
            "Arial",
            "logo_padrao.png",
            "Profissional"
        );
        
        // Estrutura padrão do currículo
        this.secoes = new ArrayList<>();
        inicializarSecoesPadrao();
    }
    
    private void inicializarSecoesPadrao() {
        SecaoDocumento dados = new SecaoDocumento("Dados Pessoais");
        dados.adicionarConteudo("Nome: [A preencher]");
        dados.adicionarConteudo("Email: [A preencher]");
        dados.adicionarConteudo("Telefone: [A preencher]");
        secoes.add(dados);
        
        SecaoDocumento formacao = new SecaoDocumento("Formação Acadêmica");
        formacao.adicionarConteudo("• Graduação em [Curso]");
        formacao.adicionarConteudo("• Instituição: [Nome]");
        secoes.add(formacao);
        
        SecaoDocumento experiencia = new SecaoDocumento("Experiência Profissional");
        experiencia.adicionarConteudo("• [Cargo] - [Empresa] ([Período])");
        experiencia.adicionarConteudo("  Principais atividades: [Descrição]");
        secoes.add(experiencia);
        
        SecaoDocumento habilidades = new SecaoDocumento("Habilidades");
        habilidades.adicionarConteudo("• [Habilidade técnica]");
        habilidades.adicionarConteudo("• [Habilidade interpessoal]");
        secoes.add(habilidades);
    }
    
    @Override
    public DocumentoPrototype clonar() {
        /*
         * CORE DO PROTOTYPE PATTERN:
         * Cria uma cópia profunda do objeto, incluindo todos os objetos internos
         * Muito mais eficiente que recriar toda a estrutura
         */
        try {
            TemplateCurriculo clonado = (TemplateCurriculo) super.clone();
            
            // Deep copy dos objetos complexos
            clonado.estilo = this.estilo.clone();
            clonado.secoes = new ArrayList<>();
            for (SecaoDocumento secao : this.secoes) {
                clonado.secoes.add(secao.clone());
            }
            
            System.out.println("✓ Template de currículo clonado com sucesso");
            return clonado;
            
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar TemplateCurriculo", e);
        }
    }
    
    @Override
    public void personalizar(String cliente, String corPrimaria, String fonte, String logoUrl) {
        this.nomeCliente = cliente;
        this.estilo.setCorPrimaria(corPrimaria);
        this.estilo.setFonte(fonte);
        this.estilo.setLogoUrl(logoUrl);
        System.out.printf("✓ Currículo personalizado para: %s\n", cliente);
    }
    
    @Override
    public String visualizar() {
        StringBuilder sb = new StringBuilder();
        sb.append("CURRÍCULO PROFISSIONAL\n");
        sb.append(String.format("Cliente: %s\n", nomeCliente));
        sb.append(String.format("Layout: %s | Fonte: %s | Cor: %s\n", 
            layout, estilo.getFonte(), estilo.getCorPrimaria()));
        sb.append(String.format("Logo: %s\n", estilo.getLogoUrl()));
        sb.append("-".repeat(70)).append("\n\n");
        
        for (SecaoDocumento secao : secoes) {
            sb.append(String.format("【 %s 】\n", secao.getTitulo().toUpperCase()));
            for (String conteudo : secao.getConteudos()) {
                sb.append("  ").append(conteudo).append("\n");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    @Override
    public String obterTipo() {
        return "Currículo - " + layout;
    }
}
