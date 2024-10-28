package breaker.game.level;

import breaker.game.element.Brick;

import java.util.List;
import java.util.Random;

public interface GameLevel {
    public final int noOfBrickColors = 4;

    public List<Brick> getLevelBricks();

    public static int getRandomBrickImage() {
        Random random = new Random();
        return random.nextInt(noOfBrickColors) + 1;
    }
}
