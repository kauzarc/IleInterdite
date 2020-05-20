package view;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Translate;
import modele.Character;
import observerObservable.Observer;

import java.awt.*;
import java.util.ArrayList;

public class CharacterGraphics extends Group implements Observer {
    private final Character character;
    private final int scale;
    private int previousX;
    private int previousY;

    private Rectangle boundRectangle;
    private ArrayList<Rectangle> actionRectangles;
    public CharacterGraphics(Character concernedCharacter, int SCALE) {
        super();
        this.setTranslateX(SCALE * concernedCharacter.getX());
        this.setTranslateY(SCALE * concernedCharacter.getY());
        this.boundRectangle = new Rectangle( SCALE/4,  SCALE/4, (SCALE / 2) - 2, (SCALE / 2) - 2);
        this.actionRectangles = new ArrayList<>(3);
        
        this.getChildren().add(boundRectangle);
        concernedCharacter.addObserver(this);
        this.character = concernedCharacter;
        System.out.println("Graphics [" + this.character.getX() + "," + this.character.getY() + "]");
        this.scale = SCALE;
        this.previousX = this.character.getX();
        this.previousY = this.character.getY();
        this.update();

    }

    @Override
    public void update() {
        int lateralMove = this.scale * (this.character.getX() - this.previousX);
        int horizontalMove = this.scale * (this.character.getY() - this.previousY);
        Translate translate = new Translate(lateralMove, horizontalMove);
        this.getTransforms().add(translate);
        this.previousX = this.character.getX();
        this.previousY = this.character.getY();
        System.out.println(translate);
        this.boundRectangle.setFill(Color.BLACK);
        if (this.character.getBoard().getGame().getCurrentPlayer() == this.character){
            this.boundRectangle.setStroke(Color.WHITE);

        }else{
            this.boundRectangle.setStroke(Color.GRAY);
        }
    }
}
