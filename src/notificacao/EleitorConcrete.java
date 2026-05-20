package notificacao;

import debate.PoliticoColaborador;

public class EleitorConcrete implements EleitorObserver {
    private final PoliticoColaborador candidatoPreferencia;

    // Construtor
    public EleitorConcrete(PoliticoColaborador candidatoPreferencia) {
        this.candidatoPreferencia = candidatoPreferencia;
    }

    // Métodos auxiliares
    @Override
    public void notificar(String msg) {
        System.out.println("Eleitor do candidato " + candidatoPreferencia.getNome() + ": " + msg);
    }
}