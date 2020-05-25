package view;

import controller.ChangeModeHandler;
import controller.EndTurnHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Game;

import java.util.Scanner;

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

        ActionButton dryModeButton = new ActionButton( 320, 500,Game.PlayerActionMode.drying);
        ChangeModeHandler drier = new ChangeModeHandler(game, dryModeButton, Game.PlayerActionMode.drying, KeyCode.Q);
        dryModeButton.setOnMouseClicked(drier);
        mainWindow.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> { drier.handle(key);});

        ActionButton walkModeButton = new ActionButton( 380, 500,Game.PlayerActionMode.moving);
        ChangeModeHandler walker = new ChangeModeHandler(game, walkModeButton, Game.PlayerActionMode.moving, KeyCode.W);
        walkModeButton.setOnMouseClicked(walker);
        mainWindow.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> { walker.handle(key);});

        ActionButton lootModeButton = new ActionButton( 440, 500,Game.PlayerActionMode.looting);
        ChangeModeHandler looter = new ChangeModeHandler(game, lootModeButton, Game.PlayerActionMode.looting, KeyCode.E);
        lootModeButton.setOnMouseClicked(looter);
        mainWindow.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> { looter.handle(key);});


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
