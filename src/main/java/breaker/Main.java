package breaker;

import breaker.game.GameController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    GameController controller = GameController.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        controller.startGame(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}