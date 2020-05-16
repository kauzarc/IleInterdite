package Controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modele.AbstractZone;
import view.AbstractTile;

public class TileClickedHandeler implements EventHandler<MouseEvent> {
    private final AbstractTile tile;

    public TileClickedHandeler(AbstractTile tile) {
        this.tile = tile;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        AbstractZone zone = tile.getZone();
        System.out.println("" + zone.getX() + ", " + zone.getY());
    }
}
