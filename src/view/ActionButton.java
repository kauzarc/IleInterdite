package view;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import modele.Game;

import java.util.ArrayList;


public class ActionButton extends Group{
    private static Image walkImg;
    private static Image dryImg;
    private static Image lootImg;
    private static boolean initializedOnce = false;

    private static ArrayList<ActionButton> allButtons = new ArrayList<>();

    private Rectangle backgroundRectangle = new Rectangle(0.0,0.0, 50.0, 50.0);
    private ImageView imgView;

    private final Game.PlayerActionMode buttonType;

    private boolean enabled = false;
    ActionButton( double x, double y, Game.PlayerActionMode type){
        super();
        allButtons.add(this);
        if (!initializedOnce){
            initializedOnce = true;
            walkImg = new Image(getClass().getResource("movement.png").toString());
            dryImg = new Image(getClass().getResource("pail.png").toString());
            lootImg = new Image(getClass().getResource("explorer-hat.png").toString());
        }
        backgroundRectangle.setFill(Color.YELLOW);
        this.buttonType = type;

        this.getChildren().add(backgroundRectangle);
        Label shortcutLabel = new Label("A");
        switch (this.buttonType){
            case  moving:
                imgView = new ImageView(walkImg);
                shortcutLabel.setText("Z");
                break;
            case drying:
                imgView = new ImageView(dryImg);
                shortcutLabel.setText("A");
                break;
            case looting:
                imgView = new ImageView(lootImg);
                shortcutLabel.setText("E");
                break;
        }
        shortcutLabel.setPrefHeight(50.0);
        shortcutLabel.setStyle("-fx-font: 45.0 arial;");
        this.getChildren().add(shortcutLabel);
        imgView.setX(0.0);
        imgView.setY(0.0);
        imgView.setFitHeight(50);
        imgView.setFitWidth(50);

        this.getChildren().add(imgView);
        this.getTransforms().add(new Translate(x,y));
    }

    public void updateActivation(Game game){
        for (ActionButton button : allButtons) {
            if (game.getActionMode() == button.buttonType) {
                button.backgroundRectangle.setFill(Color.GREEN);
                System.out.println(button.buttonType);
            } else {
                button.backgroundRectangle.setFill(Color.YELLOW);
                System.out.println("not " + button.buttonType);
            }
        }
    }
}
