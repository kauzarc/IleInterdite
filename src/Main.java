import javafx.application.Application;
import javafx.stage.Stage;
import modele.Game;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Game g = new Game(stage, 10, 10, 4);
    }
}
