package debate;

import observer.CandidatoSubject;
import observer.EleitorObserver;

public class PoliticoConcrete extends CandidatoSubject implements PoliticoPrototype {
    protected Mediador mediador;
    private boolean sorteado;
    private final MicrofoneCronometro microfone;

    // Construtor original
    public PoliticoConcrete(String nome) {
        super(nome);
        this.microfone = new MicrofoneCronometro();
    }

    // Construtor de cópia
    public PoliticoConcrete(PoliticoConcrete source) {
        super(source.getNome());
        this.mediador = source.mediador;
        this.microfone = new MicrofoneCronometro();
        for (EleitorObserver eleitor : source.getEleitores()) {
            this.registrarObserver(eleitor);
        }
    }

    // Métodos auxiliares
    public void falar(int tempo) {
        notificarObservers();
        microfone.ativar();
        microfone.esperarTempo(tempo);
        microfone.desativar();
    }
    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }
    public void setSorteado(boolean op) {
        this.sorteado = op;
    }
    public boolean getSorteado(){
        return this.sorteado;
    }

    @Override
    public PoliticoPrototype clone() {
        return new PoliticoConcrete(this);
    }
}
