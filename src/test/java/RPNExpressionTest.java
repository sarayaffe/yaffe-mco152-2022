import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPNExpressionTest {

    @Test
    public void evaluateSimple() {
        //given
        RPNExpression rpn = new RPNExpression("5 7 +");

        //when
        String result = rpn.evaluate();

        //then
        assertEquals("12.00", result);
    }

    @Test
    public void evaluateComplex() {
        //given
        RPNExpression rpn = new RPNExpression("5 8 + 3 2.5 * +");

        //when
        String result = rpn.evaluate();

        //then
        assertEquals("20.50", result);
    }

    @Test
    public void evaluateSyntaxError1() {
        //given
        RPNExpression rpn = new RPNExpression("5 8 + + 3 2.5 * +");

        //when
        String result = rpn.evaluate();

        //then
        assertEquals("Syntax Error", result);

    }

    @Test
    public void evaluateSyntaxError2() {
        //given
        RPNExpression rpn = new RPNExpression("pi 5 +");

        //when
        String result = rpn.evaluate();

        //then
        assertEquals("Syntax Error", result);
    }

    @Test
    public void evaluateDivideBy0() {
        //given
        RPNExpression rpn = new RPNExpression("5 0 /");

        //when
        String result = rpn.evaluate();

        //then
        assertEquals("cannot divide by zero", result);
    }

    @Test
    public void evaluateExtras() {
        //given
        RPNExpression rpn = new RPNExpression("7 8.23 5 5 / 3 2 - +");

        //when
        String result = rpn.evaluate();

        //then
        assertEquals("2.00\nextra junk ignored", result);
    }
}