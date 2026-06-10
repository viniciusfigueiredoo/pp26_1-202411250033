package debate;

import builder.ConfigProduct;
import debate.prototype.InquiridoConcrete;
import debate.prototype.InquiridorConcrete;

public interface Mediador {
    void concederDR();
    void debate(ConfigProduct config);
    void setInquirido(InquiridoConcrete politico);
    void setInquiridor(InquiridorConcrete politico);
}
