package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveModeHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        UserActionState uas = UserActionState.getInstance();
        uas.setMod(UserActionState.Mode.moving);
        if(uas.getMod() == UserActionState.Mode.moving){
            System.out.println("move");
        }
    }
}
