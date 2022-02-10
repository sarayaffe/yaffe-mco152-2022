import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    public void getX(){
        //given
        QuadraticEquation qe = new QuadraticEquation(2, 1, -3);

        //when
        double[] x = qe.getX();

        //then
        assertArrayEquals(new double[]{1, -1.5}, x);
    }

    @Test
    public void getXNaN(){
        //given
        QuadraticEquation qe = new QuadraticEquation(-2, 1, -3);
        QuadraticEquation qe2 = new QuadraticEquation(0, 1, -3);

        //when
        double[] x = qe.getX();
        Boolean isNaN = Double.isNaN(x[0]);
        double[] x2 = qe2.getX();
        Boolean isNaN2 = Double.isNaN(x2[0]);

        //then
        assertEquals(isNaN, true);
        assertEquals(isNaN2, true);

    }

    @Test
    public void getXIs0(){
        //given
        QuadraticEquation qe = new QuadraticEquation(1, -2, 0);
        QuadraticEquation qe2 = new QuadraticEquation(2, 0, 0);

        //when
        double[] x = qe.getX();
        double[] x2 = qe2.getX();

        //then
        assertArrayEquals(new double[]{2, 0.0}, x);
        assertArrayEquals(new double[]{0.0, -0.0}, x2);

    }

}