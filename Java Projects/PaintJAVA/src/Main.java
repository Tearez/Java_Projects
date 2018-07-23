public class Main {

    public static void main(String[] args) {
	    Canvas c = new Canvas();

	    c.addObject(new Circle("Red", 0 ,0, 3));
	    c.addObject(new Rectangle("Green", new Point(3, 5) ,2, 3));
	    c.addObject(new Curve("Purple", 2));

	    c.render();
    }
}
