public class Rectangle extends GraphicalObject implements Locatable{
    private Point topLeftCorner;
    private double width, height;

    public Rectangle(String color, Point topLeftCorner, double width, double height) {
        super(color);
        this.topLeftCorner = topLeftCorner;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("%s rectangle with top left corner %s and dimensions (%.2f, %.2f)",
                getColor(), topLeftCorner, width, height);
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public Point Locate() {
        return topLeftCorner;
    }
}
