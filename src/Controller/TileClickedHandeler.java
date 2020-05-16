package Controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.AbstractTile;

public class TileClickedHandeler implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent mouseEvent) {
        Object o = mouseEvent.getSource();
        if (o instanceof AbstractTile)
            System.out.println("yo");
    }
}
