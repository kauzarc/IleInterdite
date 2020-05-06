package modele;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NormalZoneTest {
    NormalZone zone;

    @Before
    public void setUp() {
        this.zone = null;
    }

    @Test
    public void testTestToString() {
        zone = new NormalZone(0, 0);
        Assert.assertEquals("#", zone.toString());
    }

    @Test
    public void testCanReceiveWater() {
        zone = new NormalZone(0, 0);
        Assert.assertTrue(zone.canReceiveWater());
    }

    @Test
    public void testFillWithWater (){
        zone = new NormalZone(0, 0);
        zone.fillWitchWater();
        Assert.assertTrue(zone.getWaterState() == WaterState.flooded);
    }

    public void testFillWithWater2 (){
        zone = new NormalZone(0,0);
        zone.fillWitchWater();
        zone.fillWitchWater();
        Assert.assertTrue(zone.getWaterState() == WaterState.submerged);
    }
}