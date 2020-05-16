package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DryingModeHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        UserActionState uas = UserActionState.getInstance();
        uas.setMod(UserActionState.Mode.drying);
        if(uas.getMod() == UserActionState.Mode.drying){
            System.out.println("drying");
        }
    }
}
