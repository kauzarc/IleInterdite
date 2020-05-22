package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.ItemGraphics;

public class ItemClickedHandler implements EventHandler<MouseEvent> {

    private final ItemGraphics itemGraphics;

    public ItemClickedHandler(ItemGraphics itemGraphics) {
        this.itemGraphics = itemGraphics;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("Item clicked");
        mouseEvent.consume();
    }
}
