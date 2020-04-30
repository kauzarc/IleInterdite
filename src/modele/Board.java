package modele;

import java.util.ArrayList;

public class Board {
    public int sizeX;
    public int sizeY;

    private ArrayList< ArrayList<AbstractZone> > zones;

    public Board(int sizeX,int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.zones = new ArrayList<ArrayList<AbstractZone>>(sizeX);
        for (ArrayList<AbstractZone> column : this.zones){
            column =  new ArrayList<>(sizeY);
        }
    }

    @Override
    public String toString(){
        String toReturn = new String();
        for (int y = 0; y < sizeY; y+=1){
            toReturn += "|" ;
            for (int x = 0; x < sizeX; x +=1){
                AbstractZone zone = this.zones.get(x).get(y);
                if (zone == null){
                    toReturn += "_";
                }else{
                    toReturn += zone;
                }
                toReturn += "|";
            }
            toReturn+= "\n";
        }
        return toReturn;
    }


}
