package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import modele.AbstractPlayer;
import observerObservable.Observer;

import java.util.ArrayList;

public abstract class AbstractPlayerGraphics extends Group implements Observer {
    private final AbstractPlayer character;
    private final int scale;
    private int previousX;
    private int previousY;

    private Rectangle boundRectangle;
    private ArrayList<Rectangle> actionRectangles;

    public AbstractPlayerGraphics(AbstractPlayer concernedCharacter, int SCALE) {
        super();
        this.scale = SCALE;
        this.setTranslateX(this.scale * concernedCharacter.getX());
        this.setTranslateY(this.scale * concernedCharacter.getY());

        concernedCharacter.addObserver(this);
        initBoundRectangle();
        initActionRectangles();
        this.character = concernedCharacter;
        System.out.println("Graphics [" + this.character.getX() + "," + this.character.getY() + "]");
        this.previousX = this.character.getX();
        this.previousY = this.character.getY();
        this.update();

    }

    private void initActionRectangles() {
        this.actionRectangles = new ArrayList<>(0);
        this.actionRectangles.add(new Rectangle(4 * this.scale / 12, this.scale / 4 + 0.5 * this.scale / (2 * 6), 4 * this.scale / 12, this.scale / (2 * 6)));
        this.actionRectangles.add(new Rectangle(4 * this.scale / 12, this.scale / 4 + 2.5 * this.scale / (2 * 6), 4 * this.scale / 12, this.scale / (2 * 6)));
        this.actionRectangles.add(new Rectangle(4 * this.scale / 12, this.scale / 4 + 4.5 * this.scale / (2 * 6), 4 * this.scale / 12, this.scale / (2 * 6)));
        for (Rectangle actionRectangle : this.actionRectangles) {
            actionRectangle.setFill(Color.YELLOW);
            this.getChildren().add(actionRectangle);
        }
    }

    private void initBoundRectangle() {
        this.boundRectangle = new Rectangle(this.scale / 4, this.scale / 4, this.scale / 2, this.scale / 2);
        this.getChildren().add(boundRectangle);
        this.boundRectangle.setFill(Color.BLACK);
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
        updateRectangles();
    }


    private void updateRectangles() {
        if (this.character.getBoard().getGame().getCurrentPlayer() == this.character) {
            this.boundRectangle.setStroke(Color.WHITE);
            for (int i = 0; i < this.actionRectangles.size(); i += 1) {
                this.actionRectangles.get(i).setFill(i >= this.character.getBoard().getGame().getActionCount() ?
                        Color.GREEN :
                        Color.RED);
            }
        } else {
            this.boundRectangle.setStroke(Color.GRAY);
            for (Rectangle actionRectangle : actionRectangles) {
                actionRectangle.setFill(Color.YELLOW);
            }
        }
    }
}
