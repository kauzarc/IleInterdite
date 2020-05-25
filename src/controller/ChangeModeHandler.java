package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import modele.Game;
import view.ActionButton;


public class ChangeModeHandler implements EventHandler<MouseEvent> {

    private final Game game;
    private final ActionButton button;
    private final Game.PlayerActionMode toEnable;

    public ChangeModeHandler(Game game, ActionButton button, Game.PlayerActionMode toEnable) {
        this.game = game;
        this.button = button;
        this.toEnable = toEnable;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        this.game.setActionMode(toEnable);
    }
}
