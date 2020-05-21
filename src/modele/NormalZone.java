package modele;

import view.AbstractTile;
import view.NormalTile;

public class NormalZone extends AbstractZone {
    public NormalZone(Board board, int x, int y) {
        super(board, x, y);
        this.waterState = WaterState.normal;
    }

    @Override
    public AbstractTile createTile(int scale) {
        return new NormalTile(this, scale);
    }
}
