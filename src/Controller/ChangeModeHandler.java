package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class ChangeModeHandler implements EventHandler<ActionEvent> {

    private Button button;
    public ChangeModeHandler (Button button){
        this.button = button;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        UserActionState uas = UserActionState.getInstance();
        if(uas.getMod() == UserActionState.Mode.drying){
            uas.setMod(UserActionState.Mode.moving);
            this.button.setText("switch on drying mode");
        }
        else{
            uas.setMod(UserActionState.Mode.drying);
            this.button.setText("switch on moving mode");
        }
    }
}
