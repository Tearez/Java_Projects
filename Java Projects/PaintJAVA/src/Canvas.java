import java.util.ArrayList;

public class Canvas {
    private ArrayList<GraphicalObject> objects;
    private ArrayList<GraphicalObject> selectedObjects;

    public Canvas() {
        objects = new ArrayList<>();
    }

    public void addObject(GraphicalObject object){
        objects.add(object);
    }

    public void render(){
        for (GraphicalObject object: objects) {
            System.out.println(object.toString());
        }
    }

    public void selectObjects(Point from, Point to){
        selectedObjects.clear();
        for (GraphicalObject object: objects){
            if (object instanceof Locatable && trySelectObject(object, from, to)){
                selectedObjects.add(object);
            }
        }
    }

    private boolean trySelectObject(GraphicalObject object, Point from, Point to) {
        Point location = ((Locatable)object).getLocations();
    }
}
