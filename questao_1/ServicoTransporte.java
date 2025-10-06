package questao_1;

// Context
public class ServicoTransporte {
    private EstrategiaTarifa estrategia;

    // Permite definir a estratégia em tempo de execução
    public void setEstrategia(EstrategiaTarifa estrategia) {
        this.estrategia = estrategia;
    }

    // Método genérico que funciona com qualquer estratégia
    public double calcularCustoEntrega(DadosEntrega dados) {
        if (estrategia == null) {
            throw new IllegalStateException("Estratégia de transporte não definida");
        }
        return estrategia.calcularTarifa(dados);
    }

    public String obterDescricaoModalidade() {
        if (estrategia == null) {
            return "Nenhuma modalidade selecionada";
        }
        return estrategia.obterDescricao();
    }
}
