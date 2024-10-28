package breaker.game;

import breaker.game.element.Ball;
import breaker.game.element.Brick;
import breaker.game.element.Paddle;
import breaker.game.level.GameLevel;
import breaker.game.level.LevelOne;
import breaker.physics.collision.BorderCollisionImpl;
import breaker.physics.collision.BrickCollisionImpl;
import breaker.physics.collision.PaddleCollisionImpl;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GameController{
    Pane pane;
    GraphicsContext graphicsContext;

    GameCanvas canvas = GameCanvas.getInstance();
    Ball ball = Ball.getInstance();
    Paddle paddle = Paddle.getInstance();

    BorderCollisionImpl borderCollision = BorderCollisionImpl.getInstance();
    PaddleCollisionImpl paddleCollision = PaddleCollisionImpl.getInstance();
    BrickCollisionImpl brickCollision = BrickCollisionImpl.getInstance();

    private boolean gamePaused = true;

    private static GameController instance;

    private static GameLevel gameLevel;
    public static List<Brick> currentBricks;

    public static GameController getInstance() {
        if (instance == null)
            instance = new GameController();
        return instance;
    }

    private GameController(){
        graphicsContext = canvas.getGraphicsContext2D();

        pane = new Pane(canvas);
        pane.setPrefSize(canvas.getWidth() + 50, canvas.getHeight() + 50);

        gameLevel = new LevelOne();
        currentBricks = new ArrayList<>();
        currentBricks.addAll(gameLevel.getLevelBricks());
    }

    public static void removeBrick(Brick brick) {
        currentBricks.remove(brick);
    }



    private AnimationTimer animationTimer;


    public void startGame(Stage stage) {
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        manageKeyEvent();
        canvas.redrawCanvas(currentBricks);

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    canvas.requestFocus();
                    if (gamePaused)
                        return;
                    canvas.redrawCanvas(currentBricks);

                    borderCollision.checkCollision();
                    paddleCollision.checkCollision();
                    brickCollision.checkCollision();

                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };
        animationTimer.start();

    }

    void manageKeyEvent() {
        canvas.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case SPACE -> {
                    gamePaused = !gamePaused;
                }
                case RIGHT -> {
                    if (!gamePaused)
                        if (paddle.getXPosition() + paddle.getPaddleWidth() != canvas.getWidth())
                            paddle.setXPosition(paddle.getXPosition() + 20);
                }
                case LEFT -> {
                    if (!gamePaused)
                        if (paddle.getXPosition() != 0)
                            paddle.setXPosition(paddle.getXPosition() - 20);
                }
            }
        });
    }

}
