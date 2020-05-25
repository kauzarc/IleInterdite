package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import modele.Game;
import view.ActionButton;


public class ChangeModeHandler implements EventHandler<Event>{

    private final Game game;
    private final ActionButton button;
    private final Game.PlayerActionMode toEnable;
    private final KeyCode toPress;

    public ChangeModeHandler(Game game, ActionButton button, Game.PlayerActionMode toEnable, KeyCode toPress) {
        this.game = game;
        this.button = button;
        this.toEnable = toEnable;
        this.toPress = toPress;
    }


    @Override
    public void handle(Event event) {
        if (event instanceof KeyEvent){
            System.out.println(event);
            if (((KeyEvent) event).getCode() != toPress){
                return;
            }
        }
        System.out.println(event);
        this.game.setActionMode(toEnable);
        button.updateActivation(game);
    }
}
