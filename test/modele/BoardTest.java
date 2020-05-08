package modele;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest extends TestCase {
    Board b4_4 = new Board(4, 4);
    Board b10_1 = new Board(10,1);
    Board b1_3 = new Board(1,3);
    Board b1_1 = new Board(1,1);
    NormalZone nz00 = new NormalZone(0,0);

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testTestFillBoard1() {
        for (int x = 0; x < b4_4.getSizeX(); x += 1) {
            for (int y = 0; y < b4_4.getSizeY(); y += 1) {
                assertEquals(b4_4.getAt(x, y).x, x);
                assertEquals(b4_4.getAt(x, y).y, y);
            }
        }
    }
    public void testTestFillBoard2() {
        /*
        Inverted x y incrementation order down here:
        */
        for (int y = 0; y < b10_1.getSizeY(); y +=1){
            for (int x = 0; x < b10_1.getSizeX(); x +=1){
                assertEquals(b10_1.getAt(x,y).x, x);
                assertEquals(b10_1.getAt(x,y).y, y);
            }
        }

    }

    @Test
    public void testTestToString1() {
        assertEquals(b4_4.toString(),
                "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|\n" +
                        "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|\n" +
                        "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|\n" +
                        "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|\n");
    }
    public void testTestToString2() {
        assertEquals(b10_1.toString(),
                "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|" + nz00 + "|\n"
        );
    }
    public void testTestToString3() {
        assertEquals(b1_3.toString(),
                 "|"+nz00+"|\n"+
                        "|"+nz00+"|\n"+
                        "|"+nz00+"|\n");
    }


    @Test
    public void testHowManyZone (){
        int numberOfNormalZone = b4_4.howManyZone(WaterState.normal);
        assertEquals(numberOfNormalZone,16);
    }

    public void testHowManyZone2 (){
        b10_1.getAt(0,0).fillWithWater();
        b10_1.getAt(0,0).fillWithWater();
        b10_1.getAt(1,0).fillWithWater();
        assertEquals(b10_1.howManyZone(WaterState.normal), 8);
        assertEquals(b10_1.howManyZone(WaterState.flooded), 1);
        assertEquals(b10_1.howManyZone(WaterState.submerged), 1);
    }

    @Test
    public void testRandomFilling (){
        b4_4.randomFilling(3);
        assertEquals(b4_4.howManyZone(WaterState.flooded), 3);
    }

    public  void testRandomFilling2 (){
        b1_1.randomFilling(3);
        assertEquals(b1_1.howManyZone(WaterState.flooded), 1);
        assertEquals(b1_1.howManyZone(WaterState.normal), 0);
    }



}