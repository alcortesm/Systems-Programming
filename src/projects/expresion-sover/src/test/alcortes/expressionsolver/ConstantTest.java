package alcortes.expressionsolver;

import org.junit.Test;
import org.junit.Assert;
import java.text.ParseException;
import java.math.BigDecimal;

public class ConstantTest {

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNull() {
        new Constant(null);
    }

    @Test
    public void shouldEvaluate0() {
        Constant c = new Constant(BigDecimal.ZERO);
        BigDecimal expected = BigDecimal.ZERO;
        Assert.assertEquals(expected, c.evaluate());
    }

    @Test
    public void shouldEvaluate1() {
        Constant c = new Constant(BigDecimal.ONE);
        BigDecimal expected = BigDecimal.ONE;
        Assert.assertEquals(expected, c.evaluate());
    }

    @Test
    public void shouldEvaluate2() {
        Constant c = new Constant(new BigDecimal(2));
        BigDecimal expected = new BigDecimal(2);
        Assert.assertEquals(expected, c.evaluate());
    }

    @Test
    public void shouldEvaluate3() {
        Constant c = new Constant(new BigDecimal(-2));
        BigDecimal expected = new BigDecimal(-2);
        Assert.assertEquals(expected, c.evaluate());
    }

    @Test
    public void shouldEvaluate4() {
        Constant c = new Constant(new BigDecimal(-1234567891011121314.01234567891011121314));
        BigDecimal expected = new BigDecimal(-1234567891011121314.01234567891011121314);
        Assert.assertEquals(expected, c.evaluate());
    }

    @Test
    public void shouldEvaluate5() {
        Constant c = new Constant(new BigDecimal(Math.PI));
        BigDecimal expected = new BigDecimal(Math.PI);
        Assert.assertEquals(expected, c.evaluate());
    }

}
