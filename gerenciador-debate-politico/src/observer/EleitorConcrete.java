package observer;

import debate.PoliticoConcrete;

public class EleitorConcrete implements EleitorObserver {
    private final PoliticoConcrete candidatoPreferencia;

    // Construtor
    public EleitorConcrete(PoliticoConcrete candidatoPreferencia) {
        this.candidatoPreferencia = candidatoPreferencia;
    }

    // Métodos auxiliares
    @Override
    public void notificar(String msg) {
        System.out.println("Eleitor do candidato " + candidatoPreferencia.getNome() + ": " + msg);
    }
}