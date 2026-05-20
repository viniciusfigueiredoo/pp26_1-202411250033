package operacional;

import debate.Mediador;
import debate.MediadorDebate;
import debate.PoliticoColaborador;
import sorteio.GerenciadorPoliticos;
import notificacao.EleitorConcrete;

import java.util.List;

public class Facade {
    private static Facade instance;
    private final Mediador mediadorDebate;
    private final Configuracao config;
    private final GerenciadorPoliticos gerenciaPoliticos;
    private final Logger logger;

    // Construtor
    private Facade() {
        mediadorDebate = new MediadorDebate();
        config = new Configuracao();
        gerenciaPoliticos = new GerenciadorPoliticos();
        logger = Logger.getInstance();
    }

    // Métodos auxiliares
    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }
    public void configuracao(int[] tempos) {
        config.setPerguntaTempo(tempos[0]);
        config.setRespostaTempo(tempos[1]);
        config.setReplicaTempo(tempos[2]);
        config.setTreplicaTempo(tempos[3]);
        logger.registrarLog("Configura tempo");
    }
    public String getLogs(){
        return logger.getLogs();
    }
    public PoliticoColaborador sortearInquiridor() {
        PoliticoColaborador politico = gerenciaPoliticos.sortear(null);
        mediadorDebate.setInquiridor(politico);
        logger.registrarLog("Inquiridor sorteado");
        return politico;
    }
    public PoliticoColaborador sortearInquirido(PoliticoColaborador inquiridor) {
        PoliticoColaborador inquirido = gerenciaPoliticos.sortearInquirido(inquiridor);
        mediadorDebate.setInquirido(inquirido);
        logger.registrarLog("Inquirido sorteado");
        return inquirido;
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
    public void cadastrarEleitor(PoliticoColaborador candidato) {
        EleitorConcrete eleitor = new EleitorConcrete(candidato);
        candidato.registrarObserver(eleitor);
        logger.registrarLog("Eleitor cadastrado");
    }
    public PoliticoColaborador obterPolitico(String nome) {
        return gerenciaPoliticos.obterPolitico(nome);
    }
    public boolean todosForamInquiridores() {
        return gerenciaPoliticos.todosForamInquiridores();
    }
    public List<PoliticoColaborador> getCandidatos() {
        return gerenciaPoliticos.getPoliticos();
    }
}