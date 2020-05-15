package modele;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class NomalCaracterTest extends TestCase {

    Board b5_5 = new Board(5, 5);
    NoramlCaracter p0_0 = new NoramlCaracter(0,0, b5_5);
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testDeplacement() throws Exception {
        p0_0.deplacement(Direction.up);
        assertEquals(p0_0.getX(), 0);
        assertEquals(p0_0.getY(), 1);
    }

    public void testDeplacement2() throws Exception {
        p0_0.deplacement(Direction.up);
        p0_0.deplacement(Direction.down);
        p0_0.deplacement(Direction.right);
        assertEquals(p0_0.getY(),0);
        assertEquals(p0_0.getX(),1);
    }
    public void testDeplacement3 () throws Exception {
        p0_0.deplacement(Direction.left);
        p0_0.deplacement(Direction.down);
        assertEquals(p0_0.getX(),0);
        assertEquals(p0_0.getY(),0);
    }



}
