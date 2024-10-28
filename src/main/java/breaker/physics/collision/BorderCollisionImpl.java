package breaker.physics.collision;

import breaker.game.GameCanvas;
import breaker.game.element.Ball;
import breaker.physics.CollisionDirection;

public class BorderCollisionImpl implements CollisionManager {

    private static BorderCollisionImpl instance;
    public static BorderCollisionImpl getInstance(){
        if(instance == null)
            instance = new BorderCollisionImpl();
        return instance;
    }
    private BorderCollisionImpl() {

    }

    private Ball ball = Ball.getInstance();

    @Override
    public void checkCollision() {
        if (ball.getPositionY() <= 0)
            ball.collisionHappened(CollisionDirection.TOP);
        else if (ball.getPositionX() >= GameCanvas.width - Ball.radius*2)
            ball.collisionHappened(CollisionDirection.RIGHT);
        else if (ball.getPositionX() <= 0)
            ball.collisionHappened(CollisionDirection.LEFT);
    }

}
