package Controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import modele.Board;

public class EndTurnHandler implements EventHandler<ActionEvent> {
    private Board board;
     public EndTurnHandler (Board board){
         super();
         this.board = board;
     }
     //faire des test
    @Override
    public void handle(ActionEvent actionEvent) {
         UserActionState.getInstance().reset();
         board.randomFilling(3);
    }
}
