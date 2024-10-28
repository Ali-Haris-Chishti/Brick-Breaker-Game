package breaker.physics;

public enum CollisionDirection {

    TOP(1, -1),
    RIGHT(-1, 1),
    BOTTOM(1, -1),
    LEFT(-1, 1);

    public int x;
    public int y;

    CollisionDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
