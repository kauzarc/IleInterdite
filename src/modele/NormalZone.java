package modele;

import view.AbstractTile;
import view.NormalTile;

public class NormalZone extends AbstractZone {
    public NormalZone(Board board, int x, int y) {
        super(board, x, y);
    }

    @Override
    public AbstractTile createTile(int scale) {
        return new NormalTile(this, scale);
    }
}
