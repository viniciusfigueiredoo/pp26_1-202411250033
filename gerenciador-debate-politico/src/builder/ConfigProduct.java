package builder;

public class ConfigProduct {
    private int pergunta;
    private int resposta;
    private int replica;
    private int treplica;

    public ConfigProduct() {}

    public void setPergunta(int tempo) { this.pergunta = tempo; }
    public void setResposta(int tempo) { this.resposta = tempo; }
    public void setReplica(int tempo) { this.replica = tempo; }
    public void setTreplica(int tempo) { this.treplica = tempo; }

    public int getPergunta() { return pergunta; }
    public int getResposta() { return resposta; }
    public int getReplica() { return replica; }
    public int getTreplica() { return treplica; }
}
