package view;

import ObserverObservable.Observer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.Character;
import modele.NoramlCaracter;

public class CharacterGraphics extends Rectangle implements Observer {
    private Character character;
    private int scale;

    public CharacterGraphics (Character concernedCharacter, int SCALE){
        super(SCALE * concernedCharacter.getX()+1,SCALE * concernedCharacter.getY()+1,(SCALE/2) -2, (SCALE/2) -2);
        this.character = concernedCharacter;
        this.scale = SCALE;
        this.update();
    }

    @Override
    public void update() {
        this.setX(this.character.getX() * this.scale + 1);
        this.setY(this.character.getY() * this.scale + 1);
        this.setFill(Color.BLACK);
    }
}
