package debate;
import builder.ConfigProduct;
import operacional.Logger;

public class MediadorDebate implements Mediador {
    private InquiridorConcrete inquiridor;
    private InquiridoConcrete inquirido;

    public MediadorDebate(){}

    @Override
    public void debate(ConfigProduct config) {
        Logger.getInstance().registrarLog("Pergunta");
        System.out.println("Inquiridor falando...");
        inquiridor.falar(config.getPergunta());

        Logger.getInstance().registrarLog("Resposta");
        System.out.println("Inquirido respondendo...");
        inquirido.falar(config.getResposta());

        Logger.getInstance().registrarLog("Replica");
        System.out.println("Inquiridor replicando...");
        inquiridor.falar(config.getReplica());

        Logger.getInstance().registrarLog("Treplica");
        System.out.println("Inquirido treplicando...");
        inquirido.falar(config.getTreplica());
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
