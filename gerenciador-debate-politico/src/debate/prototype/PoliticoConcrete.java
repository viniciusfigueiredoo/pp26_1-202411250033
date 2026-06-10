package debate.prototype;

import debate.Mediador;
import debate.MediadorDebate;
import debate.MicrofoneCronometro;
import observer.CandidatoSubject;
import observer.EleitorObserver;

public class PoliticoConcrete extends CandidatoSubject implements PoliticoPrototype {
    protected Mediador mediador;
    private boolean sorteado;
    private MicrofoneCronometro microfone;

    // Construtor original
    public PoliticoConcrete(String nome) {
        super(nome);
    }

    // Construtor de cópia
    public PoliticoConcrete(PoliticoConcrete source) {
        super(source.getNome());
        this.mediador = source.mediador;
        this.microfone = new MicrofoneCronometro((MediadorDebate) source.mediador, this);
        for (EleitorObserver eleitor : source.getEleitores()) {
            this.registrarObserver(eleitor);
        }
    }

    // Métodos auxiliares
    public void falar(int tempo, boolean isDr) {
        if(isDr){
            notificarObservers("Candidato " + getNome() + " está exercendo seu Direito de Resposta");
        } else {
            notificarObservers("Candidato " + getNome() + " está falando");
        }
        microfone.ativar();
        microfone.esperarTempo(tempo);
        microfone.desativar();
    }

    public void pressionarBotaoDR() {
        microfone.pressionarBotaoDR();
    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
        this.microfone = new MicrofoneCronometro((MediadorDebate) mediador, this);
    }

    public void setSorteado(boolean op) { this.sorteado = op; }

    public boolean getSorteado() { return this.sorteado; }

    @Override
    public PoliticoPrototype clone() {
        return new PoliticoConcrete(this);
    }
}