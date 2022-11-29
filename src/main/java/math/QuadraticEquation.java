package math;

import java.util.Arrays;

public class QuadraticEquation {

    private final double b;
    private final double a;
    private final double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getX() {
        double discriminant = Math.sqrt(b * b - 4 * a * c);

        return new double[]{(-b + discriminant) / (2 * a),
                (-b - discriminant) / (2 * a)};
    }


    @Override
    public String toString() {
        return Arrays.toString(getX());
    }
}
