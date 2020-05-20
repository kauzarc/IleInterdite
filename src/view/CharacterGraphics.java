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

public class CharacterGraphics extends Group implements Observer {
    private final Character character;
    private final int scale;
    private int previousX;
    private int previousY;

    private Rectangle boundRectangle;
    public CharacterGraphics(Character concernedCharacter, int SCALE) {
        super();
        this.boundRectangle = new Rectangle(SCALE * concernedCharacter.getX() + SCALE/4, SCALE * concernedCharacter.getY() + SCALE/4, (SCALE / 2) - 2, (SCALE / 2) - 2);
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
