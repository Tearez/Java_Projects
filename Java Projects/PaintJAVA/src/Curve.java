public class Curve extends GraphicalObject {
    private int weight;

    public Curve(String color, int weight) {
        super(color);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s line with weight %d", getColor(), weight);
    }

    @Override
    public void draw() {
        System.out.println(this);
    }
}
