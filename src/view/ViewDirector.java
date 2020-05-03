package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Board;

public class ViewDirector {
    private final Stage mainWindow;
    private final Grid grid;

    public ViewDirector(Stage mainWindow, Board board) {
        this.mainWindow = mainWindow;
        this.grid = new Grid(board);

        Group root = new Group();
        root.getChildren().add(this.grid);

        Scene scene = new Scene(root);

        mainWindow.setScene(scene);
        mainWindow.show();
    }
}
