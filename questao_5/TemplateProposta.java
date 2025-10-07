package questao_5;

import java.util.ArrayList;
import java.util.List;

// Concrete Prototype 2 - Template de Proposta Comercial
public class TemplateProposta implements DocumentoPrototype {
    private String nomeCliente;
    private EstiloVisual estilo;
    private List<SecaoDocumento> secoes;
    private String formato;
    private double valorBase;
    
    public TemplateProposta(String formato) {
        this.formato = formato;
        this.nomeCliente = "[Nome da Empresa]";
        this.valorBase = 0.0;
        
        // Estilo corporativo
        this.estilo = new EstiloVisual(
            "#1ABC9C", // Verde corporativo
            "#34495E", // Cinza escuro
            "Helvetica",
            "logo_empresa.png",
            "Corporativo"
        );
        
        this.secoes = new ArrayList<>();
        inicializarSecoesPadrao();
    }
    
    private void inicializarSecoesPadrao() {
        SecaoDocumento apresentacao = new SecaoDocumento("Apresentação");
        apresentacao.adicionarConteudo("Prezado(a) cliente,");
        apresentacao.adicionarConteudo("Apresentamos nossa proposta comercial conforme solicitado.");
        secoes.add(apresentacao);
        
        SecaoDocumento escopo = new SecaoDocumento("Escopo do Projeto");
        escopo.adicionarConteudo("• Objetivo: [Descrever objetivo]");
        escopo.adicionarConteudo("• Entregáveis: [Listar entregáveis]");
        escopo.adicionarConteudo("• Prazo: [Definir prazo]");
        secoes.add(escopo);
        
        SecaoDocumento investimento = new SecaoDocumento("Investimento");
        investimento.adicionarConteudo("Valor total: R$ [Valor]");
        investimento.adicionarConteudo("Forma de pagamento: [Condições]");
        secoes.add(investimento);
        
        SecaoDocumento diferenciais = new SecaoDocumento("Nossos Diferenciais");
        diferenciais.adicionarConteudo("• Experiência comprovada no mercado");
        diferenciais.adicionarConteudo("• Equipe qualificada");
        diferenciais.adicionarConteudo("• Suporte pós-entrega");
        secoes.add(diferenciais);
    }
    
    @Override
    public DocumentoPrototype clonar() {
        try {
            TemplateProposta clonado = (TemplateProposta) super.clone();
            
            // Deep copy
            clonado.estilo = this.estilo.clone();
            clonado.secoes = new ArrayList<>();
            for (SecaoDocumento secao : this.secoes) {
                clonado.secoes.add(secao.clone());
            }
            
            System.out.println("✓ Template de proposta clonado com sucesso");
            return clonado;
            
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar TemplateProposta", e);
        }
    }
    
    @Override
    public void personalizar(String cliente, String corPrimaria, String fonte, String logoUrl) {
        this.nomeCliente = cliente;
        this.estilo.setCorPrimaria(corPrimaria);
        this.estilo.setFonte(fonte);
        this.estilo.setLogoUrl(logoUrl);
        System.out.printf("✓ Proposta personalizada para: %s\n", cliente);
    }
    
    public void definirValor(double valor) {
        this.valorBase = valor;
    }
    
    @Override
    public String visualizar() {
        StringBuilder sb = new StringBuilder();
        sb.append("PROPOSTA COMERCIAL");
        sb.append(String.format("Cliente: %s\n", nomeCliente));
        sb.append(String.format("Formato: %s | Fonte: %s | Cor: %s\n", 
            formato, estilo.getFonte(), estilo.getCorPrimaria()));
        sb.append(String.format("Logo: %s\n", estilo.getLogoUrl()));
        if (valorBase > 0) {
            sb.append(String.format("Valor Base: R$ %.2f\n", valorBase));
        }
        sb.append("-".repeat(70)).append("\n\n");
        
        for (SecaoDocumento secao : secoes) {
            sb.append(String.format("▸ %s\n", secao.getTitulo()));
            for (String conteudo : secao.getConteudos()) {
                sb.append("  ").append(conteudo).append("\n");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    @Override
    public String obterTipo() {
        return "Proposta Comercial - " + formato;
    }
}
