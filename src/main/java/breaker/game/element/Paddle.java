package breaker.game.element;

import breaker.game.GameCanvas;
import javafx.scene.image.Image;

public class Paddle extends Image {
    private final double paddleHeight;
    private double paddleWidth;

    private double xPosition;
    private final double yPosition;

    private static Paddle instance;
    public static Paddle getInstance() {
        if (instance == null)
            instance = new Paddle();
        return instance;
    }

    private Paddle() {
        super(Paddle.class.getResourceAsStream("/breaker/game/element/paddle.png"));
        this.paddleHeight = 20f;
        this.paddleWidth = 160f;
        this.yPosition =  GameCanvas.height - 30;
        this.xPosition = 200;
    }

    public double getPaddleHeight() {
        return paddleHeight;
    }

    public double getPaddleWidth() {
        return paddleWidth;
    }

    public void setPaddleWidth(double paddleWidth) {
        this.paddleWidth = paddleWidth;
    }

    public double getXPosition() {
        return xPosition;
    }

    public void setXPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }
}
