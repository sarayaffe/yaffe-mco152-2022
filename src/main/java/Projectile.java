public record Projectile(double angleInDegrees, double velocity) {

    private static final double GRAVITY = 9.8;

    public double getX(double time) {
        return velocity * time * Math.cos(Math.toRadians(angleInDegrees));
    }

    public double getY(double time) {
        return velocity * time * Math.sin(Math.toRadians(angleInDegrees)) - .5 * GRAVITY * Math.pow(time, 2);

    }

}
