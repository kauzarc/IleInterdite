package modele;

import ObserverObservable.Observable;
import ObserverObservable.Observer;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Board extends Observable {
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

    //faut faire des tests
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
            fillable.get(randomNum).fillWitchWater();
            fillable.remove(randomNum);
            number -= 1;
        }
        notifyObservers();
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
