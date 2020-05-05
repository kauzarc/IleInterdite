package view;

import Controller.EndTurnHandler;
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

        //had button and its action
        Button endTurnButton = endTurnButton("fin de tour", 250, 250);

        //add node root and its children
        Pane root = new Pane();
        root.getChildren().add(this.grid);
        root.getChildren().add(endTurnButton);


        Scene scene = new Scene(root);

        mainWindow.setScene(scene);
        mainWindow.show();
    }


    public Button endTurnButton (String name, int x, int y){
        Button button = new Button(name);
        button.setOnAction(new EndTurnHandler());
        button.setLayoutX(x);
        button.setLayoutY(y);
        return button;
    }
}
