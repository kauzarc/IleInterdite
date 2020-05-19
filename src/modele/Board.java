package modele;

import observerObservable.Observable;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Board extends Observable {
    private final Game game;

    private final int sizeX;
    private final int sizeY;

    private final ArrayList<ArrayList<AbstractZone>> zones;

    public Board(Game game, int sizeX, int sizeY) {
        super();
        this.game = game;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.zones = new ArrayList<>(sizeX);
        fillBoard();
    }

    private Board(int sizeX, int sizeY) {
        super();
        this.game = null;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.zones = new ArrayList<>(sizeX);
        fillBoard();
    }

    static Board boardForTest(int sizeX, int sizeY) {
        return new Board(sizeX, sizeY);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    /**
     * count the number of zone in the board wich is the same state as mod
     *
     * @param mod waterstate
     * @return numberOfZone int
     */
    public int howManyZone(WaterState mod) {
        int numberOfZone = 0;
        for (int y = 0; y < this.sizeY; y += 1) {
            for (int x = 0; x < this.sizeX; x += 1) {
                AbstractZone actualZone = this.zones.get(x).get(y);
                if (actualZone.getWaterState() == mod) {
                    numberOfZone++;
                }
            }
        }
        return numberOfZone;
    }

    /**
     * fill the board with NormalZone
     */
    public void fillBoard() {
        for (int x = 0; x < this.sizeX; x += 1) {
            ArrayList<AbstractZone> column = new ArrayList<>(sizeY);
            for (int y = 0; y < this.sizeY; y += 1) {
                column.add(new NormalZone(x, y));
            }
            this.zones.add(column);
        }
    }

    /**
     * permit to get the zone at the cooordinates X and Y
     *
     * @param x int
     * @param y int
     * @return an AbstractZone
     * @throws IndexOutOfBoundsException if x,y out of bound
     */
    public AbstractZone getAt(int x, int y) throws IndexOutOfBoundsException {
        if (x < 0 || x >= this.sizeX || y < 0 || y >= this.sizeY) {
            throw new IndexOutOfBoundsException("Wrong x or y index at access for this board :" + this);
        }
        return zones.get(x).get(y);
    }

    /**
     * fill a number equal of the number in parametter, of zone in the board
     *
     * @param number
     */
    public void randomFilling(int number) {
        ArrayList<AbstractZone> fillable = new ArrayList<>();
        for (int y = 0; y < this.sizeY; y += 1) {
            for (int x = 0; x < this.sizeX; x += 1) {
                AbstractZone actualZone = this.zones.get(x).get(y);
                if (actualZone.canReceiveWater()) {
                    fillable.add(actualZone);
                }
            }
        }
        if (number >= fillable.size()) {
            number = fillable.size();
        }
        while (number > 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, fillable.size());
            fillable.get(randomNum).fillWithWater();
            fillable.remove(randomNum);
            number -= 1;
        }
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int y = 0; y < this.sizeY; y += 1) {
            toReturn += "|";
            for (int x = 0; x < this.sizeX; x += 1) {
                AbstractZone zone = this.zones.get(x).get(y);
                if (zone == null) {
                    toReturn += "_";
                } else {
                    toReturn += zone;
                }
                toReturn += "|";
            }
            toReturn += "\n";
        }
        return toReturn;
    }

    public Game getGame() {
        return this.game;
    }
}
