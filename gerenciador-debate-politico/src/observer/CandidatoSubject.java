package observer;

import java.util.ArrayList;
import java.util.List;

public class CandidatoSubject{
    private final List<EleitorObserver> eleitores;
    protected String nome;

    // Construtor
    public CandidatoSubject(String nome) {
        this.nome = nome;
        eleitores = new ArrayList<>();
    }

    // Métodos auxiliares
    public String getNome() {
        return nome;
    }

    public void registrarObserver(EleitorObserver eleitor) {
        eleitores.add(eleitor);
    }

    public void desregistrarObserver(EleitorObserver eleitor) {
        eleitores.remove(eleitor);
    }

    public void notificarObservers(String mensagem) {
        for (EleitorObserver eleitor : eleitores) {
            eleitor.notificar(mensagem);
        }
    }

    public List<EleitorObserver> getEleitores() {
        return eleitores;
    }
}