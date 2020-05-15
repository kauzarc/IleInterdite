package modele;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class NormalZoneTest extends TestCase{
    NormalZone zone;

    @Before
    public void setUp() {
        this.zone = null;
    }

    @Test
    public void testTestToString() {
        zone = new NormalZone(0, 0);
        assertEquals("#", zone.toString());
    }

    @Test
    public void testCanReceiveWater() {
        zone = new NormalZone(0, 0);
        assertTrue(zone.canReceiveWater());
    }

    @Test
    public void testFillWithWater (){
        zone = new NormalZone(0, 0);
        zone.fillWithWater();
        assertEquals(zone.getWaterState(), WaterState.flooded);
    }

    //je sais pas
    public void testFillWithWater2 (){
        zone = new NormalZone(0,0);
        zone.fillWithWater();
        zone.fillWithWater();
        assertEquals(zone.getWaterState(), WaterState.submerged);
    }
}