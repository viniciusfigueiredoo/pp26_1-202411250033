package debate;

public class MicrofoneCronometro {
    private boolean microfoneAtivo;

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
    public void esperarTempo(int tempo){
        int tempoSeg = tempo * 1000;
        try {
            Thread.sleep(tempoSeg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
