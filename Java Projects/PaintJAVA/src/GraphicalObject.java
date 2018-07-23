public abstract class GraphicalObject {
    private String color;
    private static final String defaultColor = "Black";



    public GraphicalObject(){
        this(defaultColor);
    }

    public GraphicalObject(String color){
        this.color = color;
    }

    public abstract void draw();

    public String getColor() {
        return color;
    }

}
