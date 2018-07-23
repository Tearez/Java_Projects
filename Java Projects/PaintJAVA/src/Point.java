public class Point extends GraphicalObject{
    private double x, y;

    public Point(double x, double y) {
        super("");
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }

    @Override
    public void draw() {

    }

}
