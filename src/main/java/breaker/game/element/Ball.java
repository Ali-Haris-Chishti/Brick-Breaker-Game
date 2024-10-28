package breaker.game.element;

import breaker.game.GameCanvas;
import breaker.physics.CollisionDirection;
import breaker.physics.Point;
import breaker.physics.Velocity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ball extends ImageView {

    private final Velocity velocity = Velocity.getRandomVelocity();

    private double positionX = GameCanvas.width / 2;
    private double positionY = GameCanvas.height / 2;

    private static Ball instance;

    public static final double  radius = 10;

    private Ball() {
        setImage(new Image(getClass().getResourceAsStream("beach ball.png")));
    }
    public static Ball getInstance() {
        if (instance == null)
            instance = new Ball();
        return instance;
    }


    public void move() {
        positionX += velocity.getXComponent();
        positionY += velocity.getYComponent();
//        System.out.println(velocity);
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void collisionHappened(CollisionDirection direction){
        velocity.setXComponent(velocity.getXComponent() * direction.x);
        velocity.setYComponent(velocity.getYComponent() * direction.y);
    }

    public void paddleCollisionHappened(CollisionDirection direction, Point velocityCoordinates) {
        velocity.setXComponent(velocityCoordinates.x);
        velocity.setYComponent(velocityCoordinates.y);

    }
}
