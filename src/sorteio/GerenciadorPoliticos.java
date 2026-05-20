package sorteio;

import debate.PoliticoColaborador;
import debate.Mediador;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GerenciadorPoliticos {
    private final List<PoliticoColaborador> politicos;
    private int totalSorteados = 0;

    // Construtor
    public GerenciadorPoliticos() {
        politicos = new ArrayList<>();
    }

    // Métodos auxiliares
    public PoliticoColaborador criarPolitico(String nome, Mediador mediador) {
        PoliticoColaborador novoPolitico = new PoliticoColaborador(nome);
        novoPolitico.setMediador(mediador);
        politicos.add(novoPolitico);
        return novoPolitico;
    }
    public PoliticoColaborador obterPolitico(String nome) {
        for (PoliticoColaborador politico : politicos) {
            if (politico.getNome().equals(nome)) {
                return politico;
            }
        }
        return null;
    }
    public boolean todosForamInquiridores() {
        return totalSorteados == politicos.size();
    }
    public PoliticoColaborador sortear(PoliticoColaborador excluir) {
        PoliticoColaborador politico;
        do {
            int index = new Random().nextInt(politicos.size());
            politico = politicos.get(index);
        } while (politico.getSorteado() || politico == excluir);

        totalSorteados++;
        politico.setSorteado(true);
        return politico;
    }
    public List<PoliticoColaborador> getPoliticos() {
        return politicos;
    }
    public PoliticoColaborador sortearInquirido(PoliticoColaborador excluir) {
        PoliticoColaborador politico;
        do {
            int index = new Random().nextInt(politicos.size());
            politico = politicos.get(index);
        } while (politico == excluir);
        return politico;
    }
}