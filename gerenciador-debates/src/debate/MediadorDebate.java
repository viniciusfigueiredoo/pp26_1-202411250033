package debate;
import operacional.Configuracao;
import operacional.Logger;

public class MediadorDebate implements Mediador{
    private PoliticoColaborador inquirido;
    private PoliticoColaborador inquiridor;

    // Construtor
    public MediadorDebate(){}

    // Métodos auxiliares
    @Override
    public void debate(Configuracao config) {
        Logger.getInstance().registrarLog("Pergunta");
        System.out.println("Inquiridor falando...");
        inquiridor.falar(config.getPerguntaTempo());

        Logger.getInstance().registrarLog("Resposta");
        System.out.println("Inquirido respondendo...");
        inquirido.falar(config.getRespostaTempo());

        Logger.getInstance().registrarLog("Replica");
        System.out.println("Inquiridor replicando...");
        inquiridor.falar(config.getReplicaTempo());

        Logger.getInstance().registrarLog("Treplica");
        System.out.println("Inquirido treplicando...");
        inquirido.falar(config.getTreplicaTempo());
    }
    @Override
    public void setInquirido(PoliticoColaborador politico) {
        this.inquirido = politico;
    }
    @Override
    public void setInquiridor(PoliticoColaborador politico) {
        this.inquiridor = politico;
    }
}
