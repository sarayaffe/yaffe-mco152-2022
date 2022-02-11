public class Projectile {

    private static final double GRAVITY = 9.8;

    private final double angleInDegrees;
    private final double velocity;

    public Projectile(double angleInDegrees, double velocity) {
        this.angleInDegrees = angleInDegrees;
        this.velocity = velocity;
    }

    public double getX(double time)
    {
        return velocity * time * Math.cos(Math.toRadians(angleInDegrees));
    }

    public double getY(double time)
    {
        return velocity * time * Math.sin(Math.toRadians(angleInDegrees)) - .5 * GRAVITY * Math.pow(time, 2);

    }

}
