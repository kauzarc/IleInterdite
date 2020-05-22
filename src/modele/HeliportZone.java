package modele;

import view.AbstractTile;
import view.HeliportTile;

import java.util.ArrayList;

public class HeliportZone extends AbstractZone {
    private Board board;

    public HeliportZone(Board board, int x, int y) {
        super(board, x, y);
    }

    public int howManyPlayersThere() {
        int howMany = 0;
        ArrayList<AbstractPlayer> playersList = (ArrayList<AbstractPlayer>) this.board.getGame().getPlayers();
        for (AbstractPlayer p : playersList) {
            if (p.getX() == this.x && p.getY() == this.y) {
                howMany++;
            }
        }
        return howMany;
    }

    @Override
    public AbstractTile createTile(int scale) {
        return new HeliportTile(this, scale);
    }
}
