package breaker.physics.collision;

import breaker.game.GameController;
import breaker.game.element.Ball;
import breaker.game.element.Brick;
import breaker.physics.CollisionDirection;

public class BrickCollisionImpl implements CollisionManager{

    private static BrickCollisionImpl instance;
    public static BrickCollisionImpl getInstance(){
        if(instance == null)
            instance = new BrickCollisionImpl();
        return instance;
    }
    private BrickCollisionImpl(){}

    @Override
    public void checkCollision() {
        Ball ball = Ball.getInstance();

        double ballX = ball.getPositionX();
        double ballY = ball.getPositionY();
        double ballRadius = Ball.radius;

        for (Brick brick : GameController.currentBricks) {
            double brickLeft = brick.xPosition;
            double brickRight = brick.xPosition + Brick.brickWidth;
            double brickTop = brick.yPosition;
            double brickBottom = brick.yPosition + Brick.brickHeight;

            // Check if ball intersects with the brick
            boolean collisionX = ballX + ballRadius*2 > brickLeft && ballX < brickRight;
            boolean collisionY = ballY + ballRadius*2 > brickTop && ballY < brickBottom;

            if (collisionX && collisionY) {
                // Determine the side of collision based on overlap distances
                double overlapTop = Math.abs((brickTop - (ballY + ballRadius*2)));
                double overlapBottom = Math.abs((ballY) - brickBottom);
                double overlapLeft = Math.abs((brickLeft - (ballX + ballRadius*2)));
                double overlapRight = Math.abs((ballX) - brickRight);

                // Find the smallest overlap to determine the collision side
                double minOverlap = Math.min(Math.min(overlapTop, overlapBottom), Math.min(overlapLeft, overlapRight));

                if (minOverlap == overlapTop) {
                    ball.collisionHappened(CollisionDirection.BOTTOM);
                } else if (minOverlap == overlapBottom) {
                    ball.collisionHappened(CollisionDirection.TOP);
                } else if (minOverlap == overlapLeft) {
                    ball.collisionHappened(CollisionDirection.RIGHT);
                } else if (minOverlap == overlapRight) {
                    ball.collisionHappened(CollisionDirection.LEFT);
                }

                GameController.removeBrick(brick);
                break;
            }
        }
    }


}
