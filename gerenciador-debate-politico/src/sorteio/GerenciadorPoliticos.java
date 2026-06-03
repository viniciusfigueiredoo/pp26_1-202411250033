package sorteio;

import debate.InquiridoConcrete;
import debate.InquiridorConcrete;
import debate.PoliticoConcrete;
import debate.Mediador;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GerenciadorPoliticos {
    private final List<PoliticoConcrete> politicos;
    private int totalSorteados = 0;

    // Construtor
    public GerenciadorPoliticos() {
        politicos = new ArrayList<>();
    }

    // Métodos auxiliares
    public PoliticoConcrete criarPolitico(String nome, Mediador mediador) {
        PoliticoConcrete novoPolitico = new PoliticoConcrete(nome);
        novoPolitico.setMediador(mediador);
        politicos.add(novoPolitico);
        return novoPolitico;
    }
    public PoliticoConcrete obterPolitico(String nome) {
        for (PoliticoConcrete politico : politicos) {
            if (politico.getNome().equals(nome)) {
                return politico;
            }
        }
        return null;
    }
    public boolean todosForamInquiridores() {
        return totalSorteados == politicos.size();
    }
    public PoliticoConcrete[] sortear() {
        PoliticoConcrete politico;

        // Sortear inquiridor
        do {
            int index = new Random().nextInt(politicos.size());
            politico = politicos.get(index);
        } while (politico.getSorteado());

        totalSorteados++;
        politico.setSorteado(true);
        InquiridorConcrete inquiridor = (InquiridorConcrete) new InquiridorConcrete(politico).clone();

        // Sortear inquirido
        PoliticoConcrete politico2;
        do {
            int index = new Random().nextInt(politicos.size());
            politico2 = politicos.get(index);
        } while (politico2 == politico);

        InquiridoConcrete inquirido = (InquiridoConcrete) new InquiridoConcrete(politico2).clone();

        return new PoliticoConcrete[]{inquiridor, inquirido};
    }
    public List<PoliticoConcrete> getPoliticos() {
        return politicos;
    }
}










