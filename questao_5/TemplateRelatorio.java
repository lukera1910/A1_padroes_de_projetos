package questao_5;

import java.util.ArrayList;
import java.util.List;

// Concrete Prototype 3 - Template de Relatório
public class TemplateRelatorio implements DocumentoPrototype {
    private String nomeCliente;
    private EstiloVisual estilo;
    private List<SecaoDocumento> secoes;
    private String tipoRelatorio;
    private boolean incluirGraficos;
    
    public TemplateRelatorio(String tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
        this.nomeCliente = "[Empresa]";
        this.incluirGraficos = true;
        
        // Estilo formal para relatórios
        this.estilo = new EstiloVisual(
            "#3498DB", // Azul confiança
            "#BDC3C7", // Cinza neutro
            "Times New Roman",
            "logo_relatorio.png",
            "Formal"
        );
        
        this.secoes = new ArrayList<>();
        inicializarSecoesPadrao();
    }
    
    private void inicializarSecoesPadrao() {
        SecaoDocumento sumario = new SecaoDocumento("Sumário Executivo");
        sumario.adicionarConteudo("Este relatório apresenta [objetivo]");
        sumario.adicionarConteudo("Período analisado: [datas]");
        secoes.add(sumario);
        
        SecaoDocumento introducao = new SecaoDocumento("Introdução");
        introducao.adicionarConteudo("Contexto: [descrever contexto]");
        introducao.adicionarConteudo("Metodologia: [descrever metodologia]");
        secoes.add(introducao);
        
        SecaoDocumento analise = new SecaoDocumento("Análise de Dados");
        analise.adicionarConteudo("• Métrica 1: [valor]");
        analise.adicionarConteudo("• Métrica 2: [valor]");
        analise.adicionarConteudo("• Tendências observadas: [análise]");
        secoes.add(analise);
        
        SecaoDocumento conclusao = new SecaoDocumento("Conclusões e Recomendações");
        conclusao.adicionarConteudo("• Conclusão principal: [texto]");
        conclusao.adicionarConteudo("• Recomendações: [texto]");
        secoes.add(conclusao);
    }
    
    @Override
    public DocumentoPrototype clonar() {
        try {
            TemplateRelatorio clonado = (TemplateRelatorio) super.clone();
            
            // Deep copy
            clonado.estilo = this.estilo.clone();
            clonado.secoes = new ArrayList<>();
            for (SecaoDocumento secao : this.secoes) {
                clonado.secoes.add(secao.clone());
            }
            
            System.out.println("✓ Template de relatório clonado com sucesso");
            return clonado;
            
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar TemplateRelatorio", e);
        }
    }
    
    @Override
    public void personalizar(String cliente, String corPrimaria, String fonte, String logoUrl) {
        this.nomeCliente = cliente;
        this.estilo.setCorPrimaria(corPrimaria);
        this.estilo.setFonte(fonte);
        this.estilo.setLogoUrl(logoUrl);
        System.out.printf("✓ Relatório personalizado para: %s\n", cliente);
    }
    
    @Override
    public String visualizar() {
        StringBuilder sb = new StringBuilder();
        sb.append("RELATÓRIO GERENCIAL");
        sb.append(String.format("Cliente: %s\n", nomeCliente));
        sb.append(String.format("Tipo: %s | Fonte: %s | Cor: %s\n", 
            tipoRelatorio, estilo.getFonte(), estilo.getCorPrimaria()));
        sb.append(String.format("Logo: %s | Gráficos: %s\n", 
            estilo.getLogoUrl(), incluirGraficos ? "Sim" : "Não"));
        sb.append("-".repeat(70)).append("\n\n");
        
        for (SecaoDocumento secao : secoes) {
            sb.append(String.format("═══ %s ═══\n", secao.getTitulo()));
            for (String conteudo : secao.getConteudos()) {
                sb.append(conteudo).append("\n");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    @Override
    public String obterTipo() {
        return "Relatório - " + tipoRelatorio;
    }
}
