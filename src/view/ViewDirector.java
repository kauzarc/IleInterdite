package view;

import controller.ChangeModeHandler;
import controller.EndTurnHandler;
import controller.TileClickedHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Game;

import javax.swing.*;

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
        ActionButton dryModeButton = new ActionButton( 220, 500,Game.PlayerActionMode.drying);
        dryModeButton.setOnMouseClicked(new ChangeModeHandler(game, dryModeButton, Game.PlayerActionMode.drying));

        ActionButton walkModeButton = new ActionButton( 450, 500,Game.PlayerActionMode.moving);
        walkModeButton.setOnMouseClicked(new ChangeModeHandler(game, walkModeButton, Game.PlayerActionMode.moving));
        ActionButton lootModeButton = new ActionButton( 500, 500,Game.PlayerActionMode.looting);
        lootModeButton.setOnMouseClicked(new ChangeModeHandler(game, lootModeButton, Game.PlayerActionMode.looting));

        //add node root and its children
        Pane root = new Pane();
        root.getChildren().add(this.grid);
        root.getChildren().add(endTurnButton);

        root.getChildren().add(walkModeButton);
        root.getChildren().add(dryModeButton);
        root.getChildren().add(lootModeButton);

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
