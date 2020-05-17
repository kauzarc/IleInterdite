package view;

import Controller.TileClickedHandler;
import ObserverObservable.Observer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import modele.AbstractZone;
import modele.Board;
import modele.Character;
import modele.NormalZone;


public class Grid extends Pane implements Observer {
    final static int SCALE = 50;
    final static Color NORMAL = Color.BROWN, FLOODED = Color.BLUE, SUBMERGED = Color.DARKBLUE;

    private final Board board;

    public Grid(Board board) {
        super();
        this.board = board;
        this.board.addObserver(this);

        setUp();
        setUpPlayer();
    }

    public void setUp(){
        for (int x = 0; x < board.getSizeX(); x++) {
            for (int y = 0; y < this.board.getSizeY(); y++) {
                AbstractZone actualZone = this.board.getAt(x, y);
                AbstractTile tile = null;

                if (actualZone instanceof NormalZone) {
                    tile = new NormalTile(((NormalZone) actualZone), this.SCALE);
                    this.getChildren().add(tile);
                    actualZone.addObserver(tile);
                }

                tile.setOnMouseClicked(new TileClickedHandler(tile,board));
            }
        }
    }

    public void setUpPlayer (){
        for(Character p : this.board.getPlayers()){
            CharacterGraphics cg = new CharacterGraphics(p,this.SCALE);
            this.getChildren().add(cg);
        }
    }

    @Override
    public void update() {
        
    }
}
