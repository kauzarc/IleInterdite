package modele;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class GameTest extends TestCase {

    Game game5_5_1 = Game.gameForTest(5, 5, 1);
    Game game5_5_2 = Game.gameForTest(5, 5, 2);

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testNextPlayer() throws Exception {
        AbstractPlayer p = game5_5_1.getCurrentPlayer();
        game5_5_1.nextPlayer();
        assertEquals(p, game5_5_1.getCurrentPlayer());
    }

    @Test
    public void testNextPlayer2() throws Exception {
        AbstractPlayer p = game5_5_2.getCurrentPlayer();
        game5_5_2.nextPlayer();
        assertNotSame(p, game5_5_2.getCurrentPlayer());
        game5_5_2.nextPlayer();
        assertEquals(p, game5_5_2.getCurrentPlayer());
    }

    @Test
    public void testSwitchActionMode() throws Exception {
    }

    @Test
    public void testSwitchActionMode2() throws Exception {
    }
}