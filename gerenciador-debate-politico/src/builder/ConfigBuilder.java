package builder;

public interface ConfigBuilder {
    void reset();
    void buildPergunta(int tempo);
    void buildResposta(int tempo);
    void buildReplica(int tempo);
    void buildTreplica(int tempo);
    void buildDr(int tempo);
    ConfigProduct build();
}
