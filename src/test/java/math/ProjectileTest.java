package math;

import math.Projectile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {

    @Test
    public void getX() {

        //given
        var p = new Projectile(52, 17);

        //when
        double x = p.getX(3); //39.3987

        //then
        assertEquals(31.3987, x, .0001);
    }

    @Test
    public void getY() {
        //given
        var p = new Projectile(52, 17);

        //when
        double y = p.getY(3);

        //then
        assertEquals(-3.9114, y, .0001);
    }


}