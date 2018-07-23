public class Cube {
    private double a;

    public Cube(double a) {
        this.a = a;
    }

    public double volume(){
        return this.a*this.a*this.a;
    }

    @Override
    public String toString(){
        return "Куб със страна а="+a;
    }
}
