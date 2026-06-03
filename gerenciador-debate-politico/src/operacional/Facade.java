package operacional;

import debate.*;
import sorteio.GerenciadorPoliticos;
import observer.EleitorConcrete;
import builder.TemposConcreteBuilder;
import builder.ConfigProduct;

import java.util.List;

public class Facade {
    private static Facade instance;
    private final Mediador mediadorDebate;
    private final GerenciadorPoliticos gerenciaPoliticos;
    private final Logger logger;
    private final TemposConcreteBuilder builder;
    private ConfigProduct config;

    // Construtor
    private Facade() {
        mediadorDebate = new MediadorDebate();
        gerenciaPoliticos = new GerenciadorPoliticos();
        logger = Logger.getInstance();
        builder = new TemposConcreteBuilder();
    }

    // Métodos auxiliares
    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }
    public void configuracao(int[] tempos) {
        builder.buildPergunta(tempos[0]);
        builder.buildResposta(tempos[1]);
        builder.buildReplica(tempos[2]);
        builder.buildTreplica(tempos[3]);
        config = builder.build();
        logger.registrarLog("Configura tempo");
    }
    public String getLogs(){
        return logger.getLogs();
    }
    public PoliticoConcrete[] sortear() {
        PoliticoConcrete[] sorteados = gerenciaPoliticos.sortear();
        mediadorDebate.setInquiridor((InquiridorConcrete) sorteados[0]);
        mediadorDebate.setInquirido((InquiridoConcrete) sorteados[1]);
        logger.registrarLog("Inquiridor sorteado");
        logger.registrarLog("Inquirido sorteado");
        return sorteados;
    }
    public void iniciarDebate(){
        System.out.println();
        System.out.println("Iniciando debate...");
        System.out.println();
        logger.registrarLog("Debate Iniciado");
        mediadorDebate.debate(config);
    }
    public void cadastrarPolitico(String nome) {
        gerenciaPoliticos.criarPolitico(nome, mediadorDebate);
        logger.registrarLog("Político cadastrado: " + nome);
    }
    public void cadastrarEleitor(PoliticoConcrete candidato) {
        EleitorConcrete eleitor = new EleitorConcrete(candidato);
        candidato.registrarObserver(eleitor);
        logger.registrarLog("Eleitor cadastrado");
    }
    public PoliticoConcrete obterPolitico(String nome) {
        return gerenciaPoliticos.obterPolitico(nome);
    }
    public boolean todosForamInquiridores() {
        return gerenciaPoliticos.todosForamInquiridores();
    }
    public List<PoliticoConcrete> getCandidatos() {
        return gerenciaPoliticos.getPoliticos();
    }
}