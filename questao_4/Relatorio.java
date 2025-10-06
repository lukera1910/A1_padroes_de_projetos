package questao_4;

import java.util.List;

// Componente Interface - Define a interface comum para relatórios
public interface Relatorio {
    String gerar();
    List<Pedido> obterPedidos();
    String obterTitulo();   
}
