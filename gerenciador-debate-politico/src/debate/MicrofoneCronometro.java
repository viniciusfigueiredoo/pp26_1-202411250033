package debate;

import debate.prototype.PoliticoConcrete;

public class MicrofoneCronometro {
    private boolean microfoneAtivo;
    private MediadorDebate mediador;
    private PoliticoConcrete dono;

    // Construtor
    public MicrofoneCronometro(MediadorDebate mediador, PoliticoConcrete dono) {
        this.mediador = mediador;
        this.dono = dono;
    }

    // Métodos auxiliares
    public void setMicrofoneAtivo(boolean microfoneAtivo) {
        this.microfoneAtivo = microfoneAtivo;
    }

    public void ativar(){
        setMicrofoneAtivo(true);
    }

    public void desativar(){
        setMicrofoneAtivo(false);
    }

    public void pressionarBotaoDR(){
        mediador.requisitarDR(dono);
    }

    public void esperarTempo(int tempo){
        int tempoSeg = tempo * 1000;
        try {
            Thread.sleep(tempoSeg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
