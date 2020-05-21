package modele;

import controller.TileClickedHandler;
import view.AbstractTile;
import view.NormalTile;

public class NormalZone extends AbstractZone {
    public NormalZone(Board board, int x, int y) {
        super(board, x, y);
        this.waterState = WaterState.normal;
    }

    @Override
    public AbstractTile createTile(int scale) {
        NormalTile tile = new NormalTile(this, scale);
        addObserver(tile);
        tile.setOnMouseClicked(new TileClickedHandler(this.board.getGame(), tile));
        return tile;
    }
}
