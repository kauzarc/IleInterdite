package modele;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class NomalCaracterTest extends TestCase {

    Board b5_5 = Board.boardForTest(5, 5);
    AbstractPlayer p0_0 = new BasicPlayer(0, 0, b5_5);
    AbstractPlayer p1_1 = new BasicPlayer(1, 1, b5_5);

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testDeplacement() throws Exception {
        p0_0.walk(Direction.up);
        assertEquals(p0_0.getX(), 0);
        assertEquals(p0_0.getY(), 0);
    }

    public void testDeplacement2() throws Exception {
        p0_0.walk(Direction.up);
        p0_0.walk(Direction.down);
        p0_0.walk(Direction.right);
        assertEquals(p0_0.getY(), 1);
        assertEquals(p0_0.getX(), 1);
    }

    public void testDeplacement3() throws Exception {
        p0_0.walk(Direction.left);
        p0_0.walk(Direction.down);
        assertEquals(p0_0.getX(), 0);
        assertEquals(p0_0.getY(), 1);
    }

    public void testDeplacement4() throws Exception {
        assertEquals(1, p1_1.getX());
        assertEquals(1, p1_1.getY());
        p1_1.walk(Direction.up);
        assertEquals(1, p1_1.getX());
        assertEquals(0, p1_1.getY());
        p1_1.walk(Direction.left);
        assertEquals(0, p1_1.getX());
        assertEquals(0, p1_1.getY());
    }
}
