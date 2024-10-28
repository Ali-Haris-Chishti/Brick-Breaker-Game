package breaker.game.element;

import javafx.scene.image.Image;

public class Brick extends Image {

    public static final double brickHeight = 40;
    public static final double brickWidth = 60;

    public final double xPosition;
    public final double yPosition;


    public Brick(int brickNo, double xPosition, double yPosition) {
        super(Brick.class.getResourceAsStream("/breaker/game/element/brick " + brickNo + ".png"));
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

}
