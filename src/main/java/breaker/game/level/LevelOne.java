package breaker.game.level;

import breaker.game.element.Brick;

import java.util.Arrays;
import java.util.List;

public class LevelOne implements GameLevel{

    @Override
    public List<Brick> getLevelBricks() {
        return Arrays.asList(
                new Brick(GameLevel.getRandomBrickImage(), 40, 80),
                new Brick(GameLevel.getRandomBrickImage(), 100, 80),
                new Brick(GameLevel.getRandomBrickImage(), 160, 80),
                new Brick(GameLevel.getRandomBrickImage(), 220, 80),
                new Brick(GameLevel.getRandomBrickImage(), 280, 80),
                new Brick(GameLevel.getRandomBrickImage(), 340, 80),
                new Brick(GameLevel.getRandomBrickImage(), 400, 80),
                new Brick(GameLevel.getRandomBrickImage(), 460, 80),
                new Brick(GameLevel.getRandomBrickImage(), 520, 80),
                new Brick(GameLevel.getRandomBrickImage(), 580, 80),
                new Brick(GameLevel.getRandomBrickImage(), 640, 80),
                new Brick(GameLevel.getRandomBrickImage(), 700, 80),
                new Brick(GameLevel.getRandomBrickImage(), 40, 120),
                new Brick(GameLevel.getRandomBrickImage(), 100, 120),
                new Brick(GameLevel.getRandomBrickImage(), 160, 120),
                new Brick(GameLevel.getRandomBrickImage(), 220, 120),
                new Brick(GameLevel.getRandomBrickImage(), 280, 120),
                new Brick(GameLevel.getRandomBrickImage(), 340, 120),
                new Brick(GameLevel.getRandomBrickImage(), 400, 120),
                new Brick(GameLevel.getRandomBrickImage(), 460, 120),
                new Brick(GameLevel.getRandomBrickImage(), 520, 120),
                new Brick(GameLevel.getRandomBrickImage(), 580, 120),
                new Brick(GameLevel.getRandomBrickImage(), 640, 120),
                new Brick(GameLevel.getRandomBrickImage(), 700, 120),
                new Brick(GameLevel.getRandomBrickImage(), 40, 160),
                new Brick(GameLevel.getRandomBrickImage(), 100, 160),
                new Brick(GameLevel.getRandomBrickImage(), 160, 160),
                new Brick(GameLevel.getRandomBrickImage(), 220, 160),
                new Brick(GameLevel.getRandomBrickImage(), 280, 160),
                new Brick(GameLevel.getRandomBrickImage(), 340, 160),
                new Brick(GameLevel.getRandomBrickImage(), 400, 160),
                new Brick(GameLevel.getRandomBrickImage(), 460, 160),
                new Brick(GameLevel.getRandomBrickImage(), 520, 160),
                new Brick(GameLevel.getRandomBrickImage(), 580, 160),
                new Brick(GameLevel.getRandomBrickImage(), 640, 160),
                new Brick(GameLevel.getRandomBrickImage(), 700, 160)
        );
    }
}
