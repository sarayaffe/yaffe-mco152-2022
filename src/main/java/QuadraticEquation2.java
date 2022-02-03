import java.util.Arrays;

public class QuadraticEquation2 {
    private final double b;
    private final double a;
    private final double c;
    boolean imaginary;

    public QuadraticEquation2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.imaginary = false;
    }

    public double[] getX() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            imaginary = true;
            return null;

        } else {
            return new double[]{(-b + Math.sqrt(discriminant)) / (2 * a),
                                (-b - Math.sqrt(discriminant)) / (2 * a)};
        }

    }

    private String[] getXComplex(double discriminant) {
        return new String[]{((-b / (2 * a)) + " + " + Math.sqrt(-discriminant) + "i"),
                            ((-b / (2 * a)) + " - " + Math.sqrt(-discriminant) + "i")};
    }

    @Override
    public String toString() {
        double[] result = getX();

        if (imaginary)
            return Arrays.toString(getXComplex(b * b - 4 * a * c));
        else
            return Arrays.toString(result);
    }

}
