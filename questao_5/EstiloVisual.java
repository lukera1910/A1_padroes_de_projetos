package questao_5;

// Classe auxiliar para estilo visual
public class EstiloVisual implements Cloneable {
    private String corPrimaria;
    private String corSecundaria;
    private String fonte;
    private String logoUrl;
    private String esquemaCores;
    
    public EstiloVisual(String corPrimaria, String corSecundaria, String fonte, 
                       String logoUrl, String esquemaCores) {
        this.corPrimaria = corPrimaria;
        this.corSecundaria = corSecundaria;
        this.fonte = fonte;
        this.logoUrl = logoUrl;
        this.esquemaCores = esquemaCores;
    }
    
    // Método para clonar profundamente o estilo
    @Override
    protected EstiloVisual clone() {
        try {
            return (EstiloVisual) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar EstiloVisual", e);
        }
    }
    
    public String getCorPrimaria() { return corPrimaria; }
    public void setCorPrimaria(String cor) { this.corPrimaria = cor; }
    public String getCorSecundaria() { return corSecundaria; }
    public void setCorSecundaria(String cor) { this.corSecundaria = cor; }
    public String getFonte() { return fonte; }
    public void setFonte(String fonte) { this.fonte = fonte; }
    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String url) { this.logoUrl = url; }
    public String getEsquemaCores() { return esquemaCores; }
}
