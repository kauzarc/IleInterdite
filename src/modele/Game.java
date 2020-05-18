package modele;

import javafx.stage.Stage;
import view.ViewDirector;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public enum PlayerActionMode {
        moving, drying;
    }

    private Board board;
    private List<Player> players;
    private ViewDirector viewDirector;

    private int currentPlayerIndex;
    private int actionCount;
    private PlayerActionMode actionMode;

    public Game(Stage stage, int sizeX, int sizeY, int nbPlayer){
        this.board = new Board(this, sizeX, sizeY);
        this.players = new ArrayList<>();
        this.viewDirector = new ViewDirector(this, stage);

        for (int i = 0; i < nbPlayer; i++){
            addPlayer();
        }

        this.currentPlayerIndex = 0;
        this.actionCount = 0;
        this.actionMode = PlayerActionMode.moving;
    }

    private void addPlayer()
    {
        int i = this.players.size();
        this.players.add(new Player(i, i, this.board));
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getCurrentPlayer() {
        return this.players.get(currentPlayerIndex);
    }

    public void upActionCount(){
        this.actionCount++;
    }

    public int getActionCount() {
        return actionCount;
    }

    public void switchActionMode(){
        switch (this.actionMode){
            case moving:
                this.actionMode = PlayerActionMode.drying;
                break;
            case drying:
                this.actionMode = PlayerActionMode.moving;
                break;
        }
    }

    public PlayerActionMode getActionMode() {
        return actionMode;
    }
}
