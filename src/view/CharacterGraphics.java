package view;

import ObserverObservable.Observer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import modele.Character;

public class CharacterGraphics extends Rectangle implements Observer {
    private Character character;
    private int scale;
    private int previousX;
    private int previousY;

    public CharacterGraphics (Character concernedCharacter, int SCALE){
        super(SCALE * concernedCharacter.getX()+1,SCALE * concernedCharacter.getY()+1,(SCALE/2) -2, (SCALE/2) -2);
        concernedCharacter.addObserver(this);
        this.character = concernedCharacter;
        this.scale = SCALE;
        this.previousX = this.character.getX();
        this.previousY = this.character.getY();
        this.update();
    }

    @Override
    public void update() {
        int  lateralMove = this.scale * (this.character.getX() - this.previousX);
        int horizontalMove = this.scale * (this.character.getY() - this.previousY);
        Translate translate = new Translate(lateralMove, horizontalMove);
        this.getTransforms().addAll(translate);
        this.setFill(Color.BLACK);
    }
}
