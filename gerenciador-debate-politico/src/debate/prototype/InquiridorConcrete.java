package debate;

import observer.EleitorObserver;

public class InquiridorConcrete extends PoliticoConcrete {
    // Construtor
    public InquiridorConcrete(PoliticoConcrete source) {
        super(source);
    }

    // Métodos auxiliares
    @Override
    public PoliticoPrototype clone() {
        return new InquiridorConcrete(this);
    }
}
