package debate;

import builder.ConfigProduct;

public interface Mediador {
    void debate(ConfigProduct config);
    void setInquirido(InquiridoConcrete politico);
    void setInquiridor(InquiridorConcrete politico);
}
