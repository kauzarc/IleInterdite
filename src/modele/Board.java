package modele;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    private int sizeX;
    private int sizeY;

    private ArrayList< ArrayList<AbstractZone> > zones;

    public Board(int sizeX,int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.zones = new ArrayList<ArrayList<AbstractZone>>(sizeX);
        fillBoard();
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY(){
        return sizeY;
    }

    public void fillBoard(){
        for (int x=0; x<sizeX; x +=1){
            ArrayList<AbstractZone> column = new ArrayList<>(sizeY);
            for (int y = 0; y < sizeY; y+=1){
                column.add( new NormalZone(x,y));
            }
            this.zones.add(column);
        }
    }

    public AbstractZone getAt(int x, int y) throws IndexOutOfBoundsException{
        if (x < 0 || x >= sizeX || y < 0 || y >= sizeY){
            throw new IndexOutOfBoundsException("Wrong x or y index at access for this board :"+this);
        }
        return zones.get(x).get(y);
    }

    @Override
    public String toString() {
        String toReturn = new String();
        for (int y = 0; y < sizeY; y += 1) {
            toReturn += "|";
            for (int x = 0; x < sizeX; x += 1) {
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
}
