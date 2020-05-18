package Controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modele.AbstractZone;
import modele.Board;
import modele.ZoneUnreachableException;
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
        System.out.println("x :" + zone.getX() + "y : "+zone.getY() + "player x : "+board.getNowPlayer().getX() + "y : " + board.getNowPlayer().getY());
        if (UserActionState.getInstance().getActionCount() <3) {
            switch (UserActionState.getInstance().getMod()) {
                case moving:
                    if (board.getNowPlayer().zoneReachable(zone)) {
                        try {
                            board.getNowPlayer().walk(board.getNowPlayer().playerToZoneDirection(zone));
                            UserActionState.getInstance().actionCountUp();
                        }
                        catch (ZoneUnreachableException e){
                            //NEEDS TO BE FILLED WITH SOMETHING BETTER
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case drying:
                    System.out.println("Try to dry at : " + zone.getX() + ", " + zone.getY());
                    break;
            }
        }
    }
}
