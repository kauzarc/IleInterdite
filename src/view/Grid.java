package view;

import ObserverObservable.Observer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import modele.AbstractZone;
import modele.Board;
import modele.NormalZone;
import modele.WaterState;


public class Grid extends Pane implements Observer {
    final static int SCALE = 50;
    final static Color NORMAL = Color.BROWN, FLOODED = Color.BLUE, SUBMERGED = Color.DARKBLUE;

    private final Board board;

    public Grid(Board board) {
        super();
        this.board = board;
        this.board.addObserver(this);

        setUp();
    }

    public void setUp(){
        for (int x = 0; x < board.getSizeX(); x++) {
            for (int y = 0; y < board.getSizeY(); y++) {
                AbstractZone actualZone = this.board.getAt(x,y);
                if (actualZone instanceof NormalZone){
                    NormalTile normalTile =new NormalTile( ((NormalZone) actualZone) , SCALE);
                    this.getChildren().add(normalTile);
                    actualZone.addObserver(normalTile);
                }
            }
        }
    }

    @Override
    public void update() {
        
    }
}
