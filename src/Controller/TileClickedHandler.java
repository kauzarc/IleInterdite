package Controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modele.AbstractZone;
import view.AbstractTile;

public class TileClickedHandler implements EventHandler<MouseEvent> {
    private final AbstractTile tile;

    public TileClickedHandler(AbstractTile tile) {
        this.tile = tile;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        AbstractZone zone = tile.getZone();
        switch (UserActionState.getInstance().getMod()) {
            case moving:
                System.out.println("Try to move to : " + zone.getX() + ", " + zone.getY());
                break;

            case drying:
                System.out.println("Try to dry at : " + zone.getX() + ", " + zone.getY());
                break;
        }

    }
}
