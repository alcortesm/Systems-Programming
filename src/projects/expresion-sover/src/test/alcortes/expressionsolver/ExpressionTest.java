package alcortes.expressionsolver;

import org.junit.Test;
import org.junit.Assert;
import java.text.ParseException;
import java.math.BigDecimal;

public class ExpressionTest {

    @Test
    public void shouldCreateConstantsFine() {
        new Expression(BigDecimal.ZERO);
    }

    @Test
    public void shouldCreateAddFine() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_ADD, e1, e2);
    }

    @Test
    public void shouldCreateSubtractFine() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_SUBTRACT, e1, e2);
    }

    @Test
    public void shouldCreateMultiplyFine() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_MULTIPLY, e1, e2);
    }

    @Test
    public void shouldCreateDivideFine() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_ADD, e1, e2);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullConstant() {
        new Expression(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnWrongOperator1() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ONE);
        new Expression(';', e1, e2);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnWrongOperator2() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ONE);
        new Expression('a', e1, e2);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand1() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_ADD, e1, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand2() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_SUBTRACT, e1, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand3() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_MULTIPLY, e1, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand4() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_DIVIDE, e1, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand5() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_ADD, null, e1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand6() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_SUBTRACT, null, e1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand7() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_MULTIPLY, null, e1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand8() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_DIVIDE, null, e1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand9() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_ADD, null, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand10() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_SUBTRACT, null, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand11() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_MULTIPLY, null, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnNullOperand12() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_DIVIDE, null, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnDuplicatedOperand1() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_ADD, e1, e1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnDuplicatedOperand2() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_SUBTRACT, e1, e1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnDuplicatedOperand3() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_MULTIPLY, e1, e1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowOnDuplicatedOperand4() {
        Expression e1 = new Expression(BigDecimal.ONE);
        new Expression(Expression.OP_DIVIDE, e1, e1);
    }

    @Test
    public void constantsShouldNotBeEmpty() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Assert.assertFalse(e1.isEmpty());
    }

    @Test
    public void operationsShouldNotBeEmpty1() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_ADD, e1, e2);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void operationsShouldNotBeEmpty2() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_SUBTRACT, e1, e2);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void operationsShouldNotBeEmpty3() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_MULTIPLY, e1, e2);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void operationsShouldNotBeEmpty4() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_DIVIDE, e1, e2);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void insertionShouldDestroy1() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_ADD, e1, e2);
        Assert.assertTrue(e1.isEmpty());
        Assert.assertTrue(e2.isEmpty());
    }

    @Test
    public void insertionShouldDestroy2() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result1 = new Expression(Expression.OP_ADD, e1, e2);
        Expression e3 = new Expression(BigDecimal.ZERO);
        Expression e4 = new Expression(BigDecimal.ZERO);
        Expression result2 = new Expression(Expression.OP_ADD, e3, e4);
        Expression result3 =
            new Expression(Expression.OP_ADD, result1, result2);
        Assert.assertTrue(e1.isEmpty());
        Assert.assertTrue(e2.isEmpty());
        Assert.assertTrue(e3.isEmpty());
        Assert.assertTrue(e4.isEmpty());
        Assert.assertTrue(result1.isEmpty());
        Assert.assertTrue(result2.isEmpty());
    }

    @Test
    public void shouldAddOK1() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_ADD, e1, e2);
        BigDecimal expected = BigDecimal.ZERO;
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldAddOK2() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_ADD, e1, e2);
        BigDecimal expected = BigDecimal.ONE;
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldAddOK3() {
        Expression e1 = new Expression(new BigDecimal(Math.PI));
        Expression e2 = new Expression(new BigDecimal(Math.PI).negate());
        Expression result = new Expression(Expression.OP_ADD, e1, e2);
        BigDecimal expected = BigDecimal.ZERO;
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldAddOK4() {
        Expression e1 = new Expression(new BigDecimal(7));
        Expression e2 = new Expression(new BigDecimal(35));
        Expression result = new Expression(Expression.OP_ADD, e1, e2);
        BigDecimal expected = new BigDecimal(42);
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldAddOK5() {
        Expression e1 = new Expression(new BigDecimal(7));
        Expression e2 = new Expression(new BigDecimal(-35));
        Expression result = new Expression(Expression.OP_ADD, e1, e2);
        BigDecimal expected = new BigDecimal(-28);
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void addShouldBeCommutative() {
        Expression e1a = new Expression(new BigDecimal(7));
        Expression e2a = new Expression(new BigDecimal(35));
        Expression e1b = new Expression(new BigDecimal(7));
        Expression e2b = new Expression(new BigDecimal(35));
        Expression result1 = new Expression(Expression.OP_ADD, e1a, e2a);
        Expression result2 = new Expression(Expression.OP_ADD, e2b, e1b);
        Assert.assertTrue(
                result1.evaluate().compareTo(result2.evaluate()) == 0);
    }

    @Test
    public void shouldSubtractOK1() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_SUBTRACT, e1, e2);
        BigDecimal expected = BigDecimal.ZERO;
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldSubtractOK2() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_SUBTRACT, e1, e2);
        BigDecimal expected = BigDecimal.ONE;
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldSubtractOK3() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(new BigDecimal(Math.PI).negate());
        Expression result = new Expression(Expression.OP_SUBTRACT, e1, e2);
        BigDecimal expected = new BigDecimal(Math.PI);
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldSubtractOK4() {
        Expression e1 = new Expression(new BigDecimal(-7));
        Expression e2 = new Expression(new BigDecimal(-35));
        Expression result = new Expression(Expression.OP_SUBTRACT, e1, e2);
        BigDecimal expected = new BigDecimal(28);
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldSubtractOK5() {
        Expression e1 = new Expression(new BigDecimal(7));
        Expression e2 = new Expression(new BigDecimal(-35));
        Expression result = new Expression(Expression.OP_SUBTRACT, e1, e2);
        BigDecimal expected = new BigDecimal(42);
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void complicatedAddAndSubtract() {
        // 1 + 2 - (5 + 3) - 4
        Expression e1 = new Expression(new BigDecimal(1));
        Expression e2 = new Expression(new BigDecimal(2));
        Expression e3 = new Expression(new BigDecimal(3));
        Expression e4 = new Expression(new BigDecimal(4));
        Expression e5 = new Expression(new BigDecimal(5));
        Expression r1 = new Expression(Expression.OP_ADD, e1, e2);
        Expression r2 = new Expression(Expression.OP_ADD, e5, e3);
        Expression r3 = new Expression(Expression.OP_SUBTRACT, r1, r2);
        Expression r4 = new Expression(Expression.OP_SUBTRACT, r3, e4);
        BigDecimal expected = new BigDecimal(-9);
        Assert.assertTrue(r4.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldMultiplyOK1() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_MULTIPLY, e1, e2);
        BigDecimal expected = BigDecimal.ZERO;
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldMultiplyOK2() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_MULTIPLY, e1, e2);
        BigDecimal expected = BigDecimal.ZERO;
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldMultiplyOK3() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(new BigDecimal(Math.PI).negate());
        Expression result = new Expression(Expression.OP_MULTIPLY, e1, e2);
        BigDecimal expected = new BigDecimal(Math.PI).negate();
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldMultiplyOK4() {
        Expression e1 = new Expression(new BigDecimal(-7));
        Expression e2 = new Expression(new BigDecimal(-35));
        Expression result = new Expression(Expression.OP_MULTIPLY, e1, e2);
        BigDecimal expected = new BigDecimal(245);
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldMultiplyOK5() {
        Expression e1 = new Expression(new BigDecimal(7));
        Expression e2 = new Expression(new BigDecimal(-35));
        Expression result = new Expression(Expression.OP_MULTIPLY, e1, e2);
        BigDecimal expected = new BigDecimal(-245);
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void complicatedAddSubtractAndMultiply() {
        // 7 * ((1 * 2) + (3 - 6)) * (4 + 5) = -63
        Expression e1 = new Expression(new BigDecimal(1));
        Expression e2 = new Expression(new BigDecimal(2));
        Expression e3 = new Expression(new BigDecimal(3));
        Expression e4 = new Expression(new BigDecimal(4));
        Expression e5 = new Expression(new BigDecimal(5));
        Expression e6 = new Expression(new BigDecimal(6));
        Expression e7 = new Expression(new BigDecimal(7));

        Expression r1 = new Expression(Expression.OP_MULTIPLY, e1, e2);
        Expression r2 = new Expression(Expression.OP_SUBTRACT, e3, e6);
        Expression r3 = new Expression(Expression.OP_ADD, e4, e5);
        Expression r4 = new Expression(Expression.OP_ADD, r1, r2);
        Expression r5 = new Expression(Expression.OP_MULTIPLY, r3, r4);
        Expression r6 = new Expression(Expression.OP_MULTIPLY, e7, r5);
        BigDecimal expected = new BigDecimal(-63);
        Assert.assertTrue(r6.evaluate().compareTo(expected) == 0);
    }

    @Test(expected=ArithmeticException.class)
    public void shouldDivideOK1() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_DIVIDE, e1, e2);
        result.evaluate();
    }

    @Test(expected=ArithmeticException.class)
    public void shouldDivideOK2() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(BigDecimal.ZERO);
        Expression result = new Expression(Expression.OP_DIVIDE, e1, e2);
        result.evaluate();
    }

    @Test
    public void shouldDivideOK3() {
        Expression e1 = new Expression(BigDecimal.ONE);
        Expression e2 = new Expression(new BigDecimal(Math.PI).negate());
        Expression result = new Expression(Expression.OP_DIVIDE, e2, e1);
        BigDecimal expected = new BigDecimal(Math.PI).negate();
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldDivideOK4() {
        Expression e1 = new Expression(new BigDecimal(-5));
        Expression e2 = new Expression(new BigDecimal(-2));
        Expression result = new Expression(Expression.OP_DIVIDE, e1, e2);
        BigDecimal expected = new BigDecimal("2.5");
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldDivideOK5() {
        Expression e1 = new Expression(new BigDecimal(7));
        Expression e2 = new Expression(new BigDecimal(-35));
        Expression result = new Expression(Expression.OP_DIVIDE, e1, e2);
        BigDecimal expected = new BigDecimal(7).divide(new BigDecimal(-35));
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void shouldDivideOK6() {
        Expression e1 = new Expression(BigDecimal.ZERO);
        Expression e2 = new Expression(new BigDecimal(100));
        Expression result = new Expression(Expression.OP_DIVIDE, e1, e2);
        BigDecimal expected = BigDecimal.ZERO;
        Assert.assertTrue(result.evaluate().compareTo(expected) == 0);
    }

    @Test
    public void complicatedAddSubtractMultiplyAndDivide() {
        //  (1 + 5) - (3 * 4)
        //  ----------------- = -1.875
        //           8
        //      ----------
        //            7
        //       6 - ---
        //            2
        Expression e1 = new Expression(new BigDecimal(1));
        Expression e2 = new Expression(new BigDecimal(2));
        Expression e3 = new Expression(new BigDecimal(3));
        Expression e4 = new Expression(new BigDecimal(4));
        Expression e5 = new Expression(new BigDecimal(5));
        Expression e6 = new Expression(new BigDecimal(6));
        Expression e7 = new Expression(new BigDecimal(7));
        Expression e8 = new Expression(new BigDecimal(8));

        Expression r1 = new Expression(Expression.OP_ADD, e1, e5);
        Expression r2 = new Expression(Expression.OP_MULTIPLY, e3, e4);
        Expression r3 = new Expression(Expression.OP_SUBTRACT, r1, r2);
        Expression r4 = new Expression(Expression.OP_DIVIDE, e7, e2);
        Expression r5 = new Expression(Expression.OP_SUBTRACT, e6, r4);
        Expression r6 = new Expression(Expression.OP_DIVIDE, e8, r5);
        Expression r7 = new Expression(Expression.OP_DIVIDE, r3, r6);
        BigDecimal expected = new BigDecimal("-1.875");
        Assert.assertTrue(r7.evaluate().compareTo(expected) == 0);
    }

}
