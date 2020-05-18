package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modele.AbstractZone;
import modele.Board;
import modele.Direction;
import modele.Game;
import view.AbstractTile;

public class TileClickedHandler implements EventHandler<MouseEvent> {
    private final AbstractTile tile;
    private final Game game;

    public TileClickedHandler(Game game, AbstractTile tile) {
        this.tile = tile;
        this.game = game;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        AbstractZone zone = tile.getZone();

        if (this.game.getActionCount() < 3) {
            switch (this.game.getActionMode()) {
                case moving:
                    if (this.game.getCurrentPlayer().zoneReachable(zone)) {
                        this.game.upActionCount();
                        Direction direction = this.game.getCurrentPlayer().playerToZoneDirection(zone);
                        this.game.getCurrentPlayer().walk(direction);
                    }
                    break;

                case drying:
                    System.out.println("Try to dry at : " + zone.getX() + ", " + zone.getY());
                    break;
            }
        }
    }
}
