package modele;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest extends TestCase {
    Board b;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        b = new Board(10, 10);
    }

    @Test
    public void testTestFillBoard() {
    }

    @Test
    public void testTestToString1() {
    }
}