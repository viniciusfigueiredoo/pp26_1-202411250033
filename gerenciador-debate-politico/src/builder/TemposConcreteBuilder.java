package builder;

public class TemposConcreteBuilder implements ConfigBuilder {
    private ConfigProduct produto;

    // Construtor
    public TemposConcreteBuilder() {
        this.reset();
    }

    // Métodos auxiliares
    @Override
    public void reset() {
        this.produto = new ConfigProduct();
    }
    @Override
    public void buildPergunta(int tempo) {
        produto.setPergunta(tempo);
    }
    @Override
    public void buildResposta(int tempo) {
        produto.setResposta(tempo);
    }
    @Override
    public void buildReplica(int tempo) {
        produto.setReplica(tempo);
    }
    @Override
    public void buildTreplica(int tempo) {
        produto.setTreplica(tempo);
    }
    @Override
    public ConfigProduct build() {
        ConfigProduct result = this.produto;
        this.reset();
        return result;
    }
}
