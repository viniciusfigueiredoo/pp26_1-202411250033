import debate.prototype.PoliticoConcrete;
import operacional.Facade;

import java.util.List;
import java.util.Random;

public interface UserInterface {
    // Construtor
    Facade facade = Facade.getInstance();

    // Métodos auxiliares
    default void operacao() {
        facade.cadastrarPolitico("João");
        facade.cadastrarPolitico("Tiago");
        facade.cadastrarPolitico("Pedro");
        facade.cadastrarEleitor(facade.obterPolitico("João"));
        facade.cadastrarEleitor(facade.obterPolitico("Tiago"));
        facade.cadastrarEleitor(facade.obterPolitico("Pedro"));

        int[] tempos = {1, 2, 3, 4, 1};
        facade.configuracao(tempos);

        System.out.print("Candidatos: ");
        for (PoliticoConcrete p : facade.getCandidatos()) {
            System.out.print(p.getNome() + " ");
        }
        System.out.println();

        while (!facade.todosForamInquiridores()) {
            PoliticoConcrete[] sorteados = facade.sortear();
            // Simula solicitação de DR antes do debate
            List<PoliticoConcrete> candidatos = facade.getCandidatos();
            PoliticoConcrete solicitante = candidatos.get(new Random().nextInt(candidatos.size()));
            solicitante.pressionarBotaoDR();
            facade.iniciarDebate();
        }

        System.out.println("Debate encerrado!");
        System.out.println("\n--- LOGS ---");
        System.out.println(facade.getLogs());
    }
}