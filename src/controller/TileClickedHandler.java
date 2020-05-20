package controller;

import exception.ZoneUnreachableException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modele.AbstractZone;
import modele.Direction;
import modele.Game;
import modele.WaterState;
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
        System.out.println("x :" + zone.getX() + "y : " + zone.getY() + ", player x : " + this.game.getCurrentPlayer().getX() + "y : " + this.game.getCurrentPlayer().getY());

        if (this.game.getActionCount() < 3) {
            switch (this.game.getActionMode()) {
                case moving:
                    move();
                    break;

                case drying:
                    dry();
                    break;
            }
        }
    }

    private void move() {
        AbstractZone zone = tile.getZone();
        if (this.game.getCurrentPlayer().zoneReachable(zone)) {
            try {
                this.game.upActionCount();
                Direction direction = this.game.getCurrentPlayer().playerToZoneDirection(zone);
                this.game.getCurrentPlayer().walk(direction);
            } catch (ZoneUnreachableException e) {
                // NEEDS TO BE FILLED WITH SOMETHING BETTER
                System.out.println(e.getMessage());
            }
        }
    }

    private void dry() {
        AbstractZone zone = tile.getZone();
        if (this.game.getCurrentPlayer().zoneReachable(zone) || zone == this.game.getCurrentPlayer().getZone()) {
            if (zone.getWaterState() == WaterState.flooded) {
                this.game.upActionCount();
                zone.dryWater();
            }
        }
    }
}
