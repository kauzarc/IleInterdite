package modele;

import java.util.ArrayList;

public class HeliportZone extends AbstractZone {
    private Board board;
    public HeliportZone(int x, int y, Board board) {
        super(x, y);
        this.board = board;
    }

    public int howManyPlayersThere (){
        int howMany = 0;
        ArrayList<Player> playersList = (ArrayList<Player>) this.board.getGame().getPlayers();
        for (Player p : playersList){
            if(p.getX() == this.x && p.getY() == this.y){
                howMany ++;
            }
        }
        return howMany;
    }

}
