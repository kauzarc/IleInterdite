package modele;
import observerObservable.Observable;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Board extends Observable {
    private Game game;

    private int sizeX;
    private int sizeY;

    private ArrayList< ArrayList<AbstractZone> > zones;
    private ArrayList<Player> players;

    public Board(Game game, int sizeX,int sizeY){
        super();
        this.game = game;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.zones = new ArrayList<ArrayList<AbstractZone>>(sizeX);
        this.players = new ArrayList<Player>();
        fillBoard();
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY(){
        return sizeY;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    /**
     * count the number of zone in the board wich is the same state as mod
     * @param mod waterstate
     * @return numberOfZone int
     */
    public int howManyZone(WaterState mod){
        int numberOfZone = 0;
        for(int y = 0; y < this.sizeY; y += 1) {
            for (int x = 0; x < this.sizeX; x += 1) {
                AbstractZone actualZone = this.zones.get(x).get(y);
                if (actualZone.getWaterState() == mod){
                    numberOfZone ++;
                }
            }
        }
        return numberOfZone;
    }

    /**
     * fill the board with NormalZone
     */
    public void fillBoard(){
        for (int x=0; x<this.sizeX; x +=1){
            ArrayList<AbstractZone> column = new ArrayList<>(sizeY);
            for (int y = 0; y < this.sizeY; y+=1){
                column.add( new NormalZone(x,y));
            }
            this.zones.add(column);
        }
    }

    /**
     * permit to get the zone at the cooordinates X and Y
     * @param x int
     * @param y int
     * @return an AbstractZone
     * @throws IndexOutOfBoundsException
     */
    public AbstractZone getAt(int x, int y) throws IndexOutOfBoundsException{
        if (x < 0 || x >= this.sizeX || y < 0 || y >= this.sizeY){
            throw new IndexOutOfBoundsException("Wrong x or y index at access for this board :"+this);
        }
        return zones.get(x).get(y);
    }

    /**
     * fill a number equal of the number in parametter, of zone in the board
     * @param number
     */
    public void randomFilling (int number){
        ArrayList<AbstractZone> fillable = new ArrayList<AbstractZone>();
        for(int y = 0; y < this.sizeY; y += 1){
            for(int x = 0; x < this.sizeX;  x += 1){
                AbstractZone actualZone = this.zones.get(x).get(y);
                if(actualZone.canReceiveWater()){
                    fillable.add(actualZone);
                }
            }
        }
        if (number >= fillable.size()){
            number = fillable.size();
        }
        while(number > 0){
            int randomNum = ThreadLocalRandom.current().nextInt(0, fillable.size());
            fillable.get(randomNum).fillWithWater();
            fillable.remove(randomNum);
            number -= 1;
        }
    }

    public void addPlayer(Player p1){
        this.players.add(p1);
    }

    @Override
    public String toString() {
        String toReturn = new String();
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

    public Game getGame(){
        return this.game;
    }
}
