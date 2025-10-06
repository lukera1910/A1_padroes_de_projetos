package questao_4;

import java.util.List;

// Decorator Base - Classe abstrata para todos os decoradores
public abstract class RelatorioDecorator implements Relatorio {
    protected Relatorio relatorioDecorado;
    
    public RelatorioDecorator(Relatorio relatorio) {
        this.relatorioDecorado = relatorio;
    }
    
    @Override
    public String gerar() {
        // Por padrão, delega para o componente decorado
        return relatorioDecorado.gerar();
    }
    
    @Override
    public List<Pedido> obterPedidos() {
        return relatorioDecorado.obterPedidos();
    }
    
    @Override
    public String obterTitulo() {
        return relatorioDecorado.obterTitulo();
    }
}
