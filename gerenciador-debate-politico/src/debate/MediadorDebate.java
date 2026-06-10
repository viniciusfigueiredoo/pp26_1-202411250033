package debate;

import builder.ConfigProduct;
import debate.prototype.InquiridoConcrete;
import debate.prototype.InquiridorConcrete;
import debate.prototype.PoliticoConcrete;
import debate.state.DRAndamentoState;
import debate.state.DebateState;
import debate.state.DebateNormalState;
import operacional.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MediadorDebate implements Mediador {
    private InquiridorConcrete inquiridor;
    private InquiridoConcrete inquirido;
    private DebateState estadoAtual;
    private ConfigProduct config;
    private final Queue<PoliticoConcrete> filaDR;

    // Construtor
    public MediadorDebate() {
        filaDR = new LinkedList<>();
        estadoAtual = new DebateNormalState(this);
    }

    // Métodos auxiliares
    @Override
    public void debate(ConfigProduct config) {
        this.config = config;

        Logger.getInstance().registrarLog("Pergunta");
        System.out.println("Inquiridor falando...");
        inquiridor.falar(config.getPergunta(), false);

        Logger.getInstance().registrarLog("Resposta");
        System.out.println("Inquirido respondendo...");
        inquirido.falar(config.getResposta(), false);

        Logger.getInstance().registrarLog("Replica");
        System.out.println("Inquiridor replicando...");
        inquiridor.falar(config.getReplica(), false);

        Logger.getInstance().registrarLog("Treplica");
        System.out.println("Inquirido treplicando...");
        inquirido.falar(config.getTreplica(), false);
    }

    public void requisitarDR(PoliticoConcrete politico) {
        Logger.getInstance().registrarLog("DR solicitado por: " + politico.getNome());
        estadoAtual.requisitarDR(politico);
    }

    public void concederDR() {
        if (filaDR.isEmpty()) return;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Há solicitações de Direito de Resposta. Quer conceder? (S/N)");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            setEstado(new DRAndamentoState(this));
            while (!filaDR.isEmpty()) {
                PoliticoConcrete politico = filaDR.poll();
                Logger.getInstance().registrarLog("DR concedido para: " + politico.getNome());
                System.out.println(politico.getNome() + " exercendo Direito de Resposta...");
                politico.falar(config.getDr(), true);
            }
            setEstado(new DebateNormalState(this));
        } else {
            Logger.getInstance().registrarLog("DR negado");
            filaDR.clear();
            setEstado(new DebateNormalState(this));
        }
    }

    public void setEstado(DebateState estado) {
        this.estadoAtual = estado;
    }

    public void adicionarFilaDR(PoliticoConcrete politico) {
        filaDR.add(politico);
    }

    public Queue<PoliticoConcrete> getFilaDR() {
        return filaDR;
    }

    public ConfigProduct getConfig() {
        return config;
    }

    @Override
    public void setInquirido(InquiridoConcrete politico) {
        this.inquirido = politico;
    }

    @Override
    public void setInquiridor(InquiridorConcrete politico) {
        this.inquiridor = politico;
    }
}