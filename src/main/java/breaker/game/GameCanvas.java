package breaker.game;

import breaker.game.element.Ball;
import breaker.game.element.Brick;
import breaker.game.element.Paddle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.List;

public class GameCanvas extends Canvas {

    public final Image background;

    private static GameCanvas instance;
    private static Ball ball = Ball.getInstance();
    private static Paddle paddle = Paddle.getInstance();

    public final static double width = 800;
    public final static double height = 600;

    static GraphicsContext graphicsContext;

    private GameCanvas() {
        setWidth(width);
        setHeight(height);

        setLayoutX(25);
        setLayoutY(25);

        background = new Image(getClass().getResourceAsStream("game background.png"));

        graphicsContext = this.getGraphicsContext2D();
    }

    public static GameCanvas getInstance() {
        if (instance == null)
            instance = new GameCanvas();
        return instance;
    }


    public void redrawCanvas(List<Brick> bricks) {
        graphicsContext.clearRect(0, 0, getWidth(), getHeight());
        ball.move();

        graphicsContext.drawImage(background, 0, 0, width, height);

        graphicsContext.drawImage(ball.getImage(), ball.getPositionX(), ball.getPositionY(), ball.radius*2, ball.radius*2);
        graphicsContext.drawImage(paddle, paddle.getXPosition(), paddle.getYPosition(), paddle.getPaddleWidth(), paddle.getPaddleHeight());

        for (Brick brick : bricks) {
            graphicsContext.drawImage(brick, brick.xPosition, brick.yPosition, Brick.brickWidth, Brick.brickHeight);
        }
    }

}
