package debate;

import operacional.Configuracao;

public interface Mediador {
    // Métodos auxiliares
    void debate(Configuracao config);
    void setInquirido(PoliticoColaborador politico);
    void setInquiridor(PoliticoColaborador politico);
}
