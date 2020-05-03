package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Board;

public class ViewDirector {
    private Stage mainWindow;

    public ViewDirector(Stage mainWindow, Board board){
        this.mainWindow = mainWindow;

        Scene scene = new Scene(new Group(new Grid(board)));
        mainWindow.setScene(scene);
        mainWindow.show();
    }
}
