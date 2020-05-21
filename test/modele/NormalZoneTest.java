package modele;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class NormalZoneTest extends TestCase {
    NormalZone zone;
    Board board = Board.boardForTest(5, 5);

    @Before
    public void setUp() {
        this.zone = null;
    }

    @Test
    public void testTestToString() {
        zone = new NormalZone(board, 0, 0);
        assertEquals("#", zone.toString());
    }

    @Test
    public void testCanReceiveWater() {
        zone = new NormalZone(board, 0, 0);
        assertTrue(zone.canReceiveWater());
    }

    @Test
    public void testFillWithWater() {
        zone = new NormalZone(board, 0, 0);
        zone.fillWithWater();
        assertEquals(zone.getWaterState(), WaterState.flooded);
    }

    @Test
    public void testFillWithWater2() {
        zone = new NormalZone(board, 0, 0);
        zone.fillWithWater();
        zone.fillWithWater();
        assertEquals(zone.getWaterState(), WaterState.submerged);
    }

    @Test
    public void testDryWater() {
        zone = new NormalZone(board, 0, 0);
        zone.fillWithWater();
        zone.fillWithWater();
        assertEquals(zone.getWaterState(), WaterState.submerged);
        zone.dryWater();
        assertEquals(zone.getWaterState(), WaterState.flooded);
        zone.dryWater();
        assertEquals(zone.getWaterState(), WaterState.normal);
        zone.dryWater();
        assertEquals(zone.getWaterState(), WaterState.normal);
    }
}