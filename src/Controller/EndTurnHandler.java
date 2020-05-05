package Controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class EndTurnHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("fin de tour");
    }
}
