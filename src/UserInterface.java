import debate.PoliticoColaborador;
import operacional.Facade;

public interface UserInterface {
    // "Construtor"
    Facade facade = Facade.getInstance();

    // Métodos auxiliares
    default void operacao() {
        facade.cadastrarPolitico("João");
        facade.cadastrarPolitico("Tiago");
        facade.cadastrarPolitico("Pedro");
        facade.cadastrarEleitor(facade.obterPolitico("João"));
        facade.cadastrarEleitor(facade.obterPolitico("Tiago"));
        facade.cadastrarEleitor(facade.obterPolitico("Pedro"));

        int[] tempos = {1, 2, 3, 4};
        facade.configuracao(tempos);

        System.out.print("Candidatos: ");
        for (PoliticoColaborador p : facade.getCandidatos()) {
            System.out.print(p.getNome() + " ");
        }
        System.out.println();

        while (!facade.todosForamInquiridores()) {
            PoliticoColaborador inquiridor = facade.sortearInquiridor();
            PoliticoColaborador inquirido = facade.sortearInquirido(inquiridor);
            facade.iniciarDebate();
        }

        System.out.println("Debate encerrado!");
        System.out.println("\n--- LOGS ---");
        System.out.println(facade.getLogs());
    }
}