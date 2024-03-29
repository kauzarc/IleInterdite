package view;

import controller.ChangeModeHandler;
import controller.EndTurnHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Game;

public class ViewDirector {
    private final Stage mainWindow;
    private final Grid grid;

    public ViewDirector(Game game, Stage mainWindow) {
        this.mainWindow = mainWindow;
        this.grid = new Grid(game.getBoard());

        mainWindow.setHeight(570);
        mainWindow.setWidth(505);
        //had button and its action
        Button endTurnButton = createButton("fin de tour", 220, 500);
        endTurnButton.setOnAction(new EndTurnHandler(game));
        Button changeModeButton = createButton("switch on drying mode", 315, 500);
        changeModeButton.setOnAction(new ChangeModeHandler(game, changeModeButton));


        //add node root and its children
        Pane root = new Pane();
        root.getChildren().add(this.grid);
        root.getChildren().add(endTurnButton);
        root.getChildren().add(changeModeButton);


        Scene scene = new Scene(root);

        mainWindow.setScene(scene);
        mainWindow.show();
    }


    public Button createButton(String name, int x, int y) {
        Button button = new Button(name);
        button.setLayoutX(x);
        button.setLayoutY(y);
        return button;
    }
}
