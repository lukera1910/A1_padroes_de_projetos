package questao_4;

// Concrete Decorator 3 - Adiciona exportação para PDF
public class DecoradorExportacaoPDF extends RelatorioDecorator {
    private String caminhoArquivo;
    
    public DecoradorExportacaoPDF(Relatorio relatorio, String caminhoArquivo) {
        super(relatorio);
        this.caminhoArquivo = caminhoArquivo;
    }
    
    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder();
        
        // Mantém todo o conteúdo anterior
        String conteudoOriginal = relatorioDecorado.gerar();
        sb.append(conteudoOriginal);
        
        // Adiciona informações de exportação
        sb.append("\n").append("=".repeat(70)).append("\n");
        sb.append("EXPORTAÇÃO PDF\n");
        sb.append("=".repeat(70)).append("\n");
        
        // Simula exportação para PDF
        boolean sucesso = exportarParaPDF(conteudoOriginal);
        
        if (sucesso) {
            sb.append(String.format("✓ Relatório exportado com sucesso!\n"));
            sb.append(String.format("  Arquivo: %s\n", caminhoArquivo));
            sb.append(String.format("  Tamanho: %.2f KB\n", conteudoOriginal.length() / 1024.0));
            sb.append(String.format("  Total de páginas: %d\n", calcularPaginas(conteudoOriginal)));
            sb.append("  Formato: PDF/A-1b (arquivamento)\n");
        } else {
            sb.append("✗ Erro ao exportar relatório\n");
        }
        
        return sb.toString();
    }
    
    private boolean exportarParaPDF(String conteudo) {
        // Simulação de exportação
        System.out.println("\n→ Gerando arquivo PDF...");
        System.out.println("→ Aplicando formatação...");
        System.out.println("→ Incorporando fontes...");
        System.out.println("→ Salvando em: " + caminhoArquivo);
        return true;
    }
    
    private int calcularPaginas(String conteudo) {
        // Estima número de páginas (60 linhas por página)
        int linhas = conteudo.split("\n").length;
        return (int) Math.ceil(linhas / 60.0);
    }
}
