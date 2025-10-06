package questao_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Classe para resultado do processamento
public class ResultadoPagamento {
    private boolean sucesso;
    private String mensagem;
    private String transacaoId;
    private LocalDateTime dataHora;

    public ResultadoPagamento(boolean sucesso, String mensagem, String transacaoId) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.transacaoId = transacaoId;
        this.dataHora = LocalDateTime.now();
    }

    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public String getTransacaoId() { return transacaoId; }
    public LocalDateTime getDataHora() { return dataHora; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format(
            "Status: %s | Transação: %s | Data: %s\nMensagem: %s",
            sucesso ? "APROVADO" : "RECUSADO",
            transacaoId,
            dataHora.format(formatter),
            mensagem
        );
    }
}
