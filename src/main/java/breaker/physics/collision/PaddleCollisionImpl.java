package breaker.physics.collision;

import breaker.game.element.Ball;
import breaker.game.element.Paddle;
import breaker.physics.CollisionDirection;
import breaker.physics.Point;

public class PaddleCollisionImpl implements CollisionManager {

    private static PaddleCollisionImpl instance;
    public static PaddleCollisionImpl getInstance(){
        if(instance == null)
            instance = new PaddleCollisionImpl();
        return instance;
    }

    private PaddleCollisionImpl(){}

    Paddle paddle = Paddle.getInstance();
    Ball ball = Ball.getInstance();

    @Override
    public void checkCollision() {
        // get ball center coordinates
        double ballCenterX =  ball.getPositionX() + ball.radius;
        double ballCenterY =  ball.getPositionY() + ball.radius;

        // get the point coordinates of paddle closest to ball
        double closestX = Math.max(paddle.getXPosition(), Math.min(ballCenterX, paddle.getXPosition() + paddle.getPaddleWidth()));
        double closestY = Math.max(paddle.getYPosition(), Math.min(ballCenterY, paddle.getYPosition() + paddle.getPaddleHeight()));

        // check distance
        double distanceX = ballCenterX - closestX;
        double distanceY = ballCenterY - closestY;

        // using distance square formula
        boolean isColliding = (distanceX * distanceX + distanceY * distanceY) < (ball.radius * ball.radius);

        if (isColliding) {
            double x = 0, y = 0;
            // collided in left half of paddle
            if (closestX < paddle.getXPosition() + paddle.getPaddleWidth()/2){
                // velocity's x component according to distance from center
                x = (paddle.getXPosition() + paddle.getPaddleWidth()/2 -closestX) / (paddle.getPaddleWidth()/2) * 3.5;
                y = Math.sqrt(16 - Math.pow(x, 2f)); // y component to make total velocity 4
                x = Math.abs(x) * -1; // if ball collided on left half, ball will move left irrespective of previous velocity
                y = y *-1; // first ball was moving down now up
            }
            // collided on right half of paddle
            else if (closestX > paddle.getXPosition() + paddle.getPaddleWidth()/2){
                // velocity's x component according to distance from center
                x = (paddle.getXPosition() + paddle.getPaddleWidth()/2 - closestX) / (paddle.getPaddleWidth()/2) * 3.5;
                x = Math.abs(x); // y component to make total velocity 4
                y = Math.sqrt(16 - Math.pow(x, 2f)); // if ball collided on left half, ball will move left irrespective of previous velocity
                y = y *-1; // first ball was moving down now up
            }

            // ball collided on top of the paddle
            if (closestY == paddle.getYPosition() && ballCenterY < paddle.getYPosition()) {
                ball.paddleCollisionHappened(CollisionDirection.BOTTOM, new Point(x, y));
            }
        }

    }
}
