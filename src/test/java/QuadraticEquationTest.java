import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    public void getX() {
        //given
        QuadraticEquation qe = new QuadraticEquation(2, 1, -3);

        //when
        double[] x = qe.getX();

        //then
        assertArrayEquals(new double[]{1, -1.5}, x);
    }

    @Test
    public void getXNaN() {
        //given
        QuadraticEquation qe = new QuadraticEquation(-2, 1, -3);

        //when
        double[] x = qe.getX();
        Boolean isNaN = Double.isNaN(x[0]);

        //then
        assertEquals(isNaN, true);
    }

    @Test
    public void getXIs0() {
        //given
        QuadraticEquation qe = new QuadraticEquation(1, -2, 0);

        //when
        double[] x = qe.getX();

        //then
        assertArrayEquals(new double[]{2, 0.0}, x);
    }
}