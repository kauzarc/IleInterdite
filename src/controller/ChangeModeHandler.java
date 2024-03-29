package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modele.Game;


public class ChangeModeHandler implements EventHandler<ActionEvent> {

    private final Game game;
    private final Button button;

    public ChangeModeHandler(Game game, Button button) {
        this.game = game;
        this.button = button;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        switch (game.getActionMode()) {
            case moving:
                this.button.setText("switch on moving mode");
                break;

            case drying:
                this.button.setText("switch on drying mode");
                break;
        }
        this.game.switchActionMode();
    }
}
