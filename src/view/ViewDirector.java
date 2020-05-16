package view;

import Controller.DryingModeHandler;
import Controller.EndTurnHandler;
import Controller.MoveModeHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Board;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class ViewDirector {
    private final Stage mainWindow;
    private final Grid grid;

    public ViewDirector(Stage mainWindow, Board board) {
        this.mainWindow = mainWindow;
        this.grid = new Grid(board);

        mainWindow.setHeight(570);
        mainWindow.setWidth(505);
        //had button and its action
        Button endTurnButton = endTurnButton("fin de tour", 220, 500, board);
        Button dryingModeButton = dryingModeButton("drying", 315, 500);
        Button moveModeButton = moveModeButton("moove", 150, 500);

        //add node root and its children
        Pane root = new Pane();
        root.getChildren().add(this.grid);
        root.getChildren().add(endTurnButton);
        root.getChildren().add(dryingModeButton);
        root.getChildren().add(moveModeButton);


        Scene scene = new Scene(root);

        mainWindow.setScene(scene);
        mainWindow.show();
    }


    public Button endTurnButton (String name, int x, int y, Board board){
        Button button = new Button(name);
        button.setOnAction(new EndTurnHandler(board));
        button.setLayoutX(x);
        button.setLayoutY(y);
        return button;
    }

    public Button dryingModeButton(String name, int x, int y){
        Button button = new Button(name);
        button.setOnAction(new DryingModeHandler());
        button.setLayoutX(x);
        button.setLayoutY(y);
        return button;
    }

    public Button moveModeButton(String name, int x, int y){
        Button button = new Button(name);
        button.setOnAction(new MoveModeHandler());
        button.setLayoutX(x);
        button.setLayoutY(y);
        return button;
    }
}
