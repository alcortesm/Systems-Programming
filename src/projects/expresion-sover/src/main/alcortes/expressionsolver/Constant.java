package alcortes.expressionsolver;

import java.math.BigDecimal;

class Constant implements Expression {

    private BigDecimal value;

    public Constant(BigDecimal n) {
        if (n == null) {
            throw new IllegalArgumentException();
        }
        this.value = n;
    }

    public Number evaluate() {
        return value;
    }

}
