package debate;

import notificacao.CandidatoSubject;

public class PoliticoColaborador extends CandidatoSubject {
    protected Mediador mediador;
    private boolean sorteado;
    private MicrofoneCronometro microfone;

    // Construtor
    public PoliticoColaborador(String nome){
        super(nome);
        microfone = new MicrofoneCronometro();
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
}
