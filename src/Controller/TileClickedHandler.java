package Controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modele.AbstractZone;
import modele.Board;
import view.AbstractTile;

import java.util.ArrayList;

public class TileClickedHandler implements EventHandler<MouseEvent> {
    private final AbstractTile tile;
    private final Board board;
    public TileClickedHandler(AbstractTile tile, Board board) {
        this.tile = tile;
        this.board = board;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        AbstractZone zone = tile.getZone();
        if (UserActionState.getInstance().getActionCount() <3) {
            switch (UserActionState.getInstance().getMod()) {
                case moving:
                    if (board.getNowPlayer().zoneReachable(zone)) {
                        UserActionState.getInstance().actionCountUp();
                        board.getNowPlayer().walk(board.getNowPlayer().playerToZoneDirection(zone));
                    }

                    break;

                case drying:
                    System.out.println("Try to dry at : " + zone.getX() + ", " + zone.getY());
                    break;
            }
        }
    }
}
