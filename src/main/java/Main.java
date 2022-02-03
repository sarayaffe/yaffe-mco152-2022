import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Projectile p = new Projectile(52, 43);
        System.out.println(p.getX(7));
        System.out.println(p.getY(7));

        QuadraticEquation a = new QuadraticEquation(1, 5, 2);
        System.out.println(a);
    }


}