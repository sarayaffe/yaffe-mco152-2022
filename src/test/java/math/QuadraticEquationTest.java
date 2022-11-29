package math;

import math.QuadraticEquation;
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

        //then
        boolean isNaN = Double.isNaN(x[0]);
        assertTrue(isNaN);
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