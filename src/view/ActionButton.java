package view;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import modele.Game;


public class ActionButton extends Group{
    private static Image walkImg;
    private static Image dryImg;
    private static Image lootImg;
    private static boolean initializedOnce = false;

    private Rectangle backgroundRectangle = new Rectangle(0.0,0.0, 50.0, 50.0);
    private ImageView imgView;

    private final Game.PlayerActionMode buttonType;
    ActionButton( double x, double y, Game.PlayerActionMode type){
        super();
        if (!initializedOnce){
            initializedOnce = true;
            walkImg = new Image(getClass().getResource("movement.png").toString());
            dryImg = new Image(getClass().getResource("pail.png").toString());
            lootImg = new Image(getClass().getResource("explorer-hat.png").toString());
        }
        backgroundRectangle.setFill(Color.BLUE);
        this.buttonType = type;

        this.getChildren().add(backgroundRectangle);
        switch (this.buttonType){
            case  moving:
                imgView = new ImageView(walkImg);
                break;
            case drying:
                imgView = new ImageView(dryImg);
                break;
            case looting:
                imgView = new ImageView(lootImg);
                break;
        }
        imgView.setX(0.0);
        imgView.setY(0.0);
        imgView.setFitHeight(50);
        imgView.setFitWidth(50);

        this.getChildren().add(imgView);
        this.getTransforms().add(new Translate(x,y));

    }

}
