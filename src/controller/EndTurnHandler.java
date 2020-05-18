package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modele.Game;

public class EndTurnHandler implements EventHandler<ActionEvent> {
    private Game game;

     public EndTurnHandler (Game game){
         super();
         this.game = game;
     }
     //faire des test
    @Override
    public void handle(ActionEvent actionEvent) {
         this.game.getBoard().randomFilling(3);
    }
}
