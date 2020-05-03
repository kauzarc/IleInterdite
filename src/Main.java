import javafx.application.Application;
import javafx.stage.Stage;

import view.ViewDirector;
import modele.Board;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Board b = new Board(10, 10);
        ViewDirector viewDirector = new ViewDirector(stage, b);
    }
}
