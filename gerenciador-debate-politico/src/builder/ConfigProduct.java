package builder;

public class ConfigProduct {
    private int pergunta;
    private int resposta;
    private int replica;
    private int treplica;
    private int dr;

    // Construtor
    public ConfigProduct() {}

    // Métodos auxiliares
    public void setPergunta(int tempo) { this.pergunta = tempo; }
    public void setResposta(int tempo) { this.resposta = tempo; }
    public void setReplica(int tempo) { this.replica = tempo; }
    public void setTreplica(int tempo) { this.treplica = tempo; }
    public void setDr(int dr) {
        this.dr = dr;
    }

    public int getPergunta() { return pergunta; }
    public int getResposta() { return resposta; }
    public int getReplica() { return replica; }
    public int getTreplica() { return treplica; }
    public int getDr() {
        return dr;
    }
}
