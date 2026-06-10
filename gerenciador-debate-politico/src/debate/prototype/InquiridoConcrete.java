package debate.prototype;

public class InquiridoConcrete extends PoliticoConcrete {
    // Construtor
    public InquiridoConcrete(PoliticoConcrete source) {
        super(source);
    }

    // Métodos auxiliares
    @Override
    public PoliticoPrototype clone() {
        return new InquiridoConcrete(this);
    }
}
