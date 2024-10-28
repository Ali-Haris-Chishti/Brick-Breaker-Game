package breaker.physics;

import java.util.Random;

public class Velocity {

    private double xComponent;
    private double yComponent;


    public Velocity(double xComponent, double yComponent) {
        this.xComponent = xComponent;
        this.yComponent = yComponent;
    }

    public double getXComponent() {
        return xComponent;
    }

    public void setXComponent(double xComponent) {
        this.xComponent = xComponent;
    }

    public double getYComponent() {
        return yComponent;
    }

    public void setYComponent(double yComponent) {
        this.yComponent = yComponent;
    }

    public static Velocity getRandomVelocity() {
        double x = new Random().nextFloat(2.5f, 3.5f);
        double y = Math.sqrt(16 - Math.pow(x, 2f));

        int negativeFactor = new Random().nextInt(2);
        if (negativeFactor == 0)
            x = x * -1;

        return new Velocity(x, y);
    }

    @Override
    public String toString(){
        return "[xComponent: " + xComponent + ", yComponent: " + yComponent + "]";
    }
}
