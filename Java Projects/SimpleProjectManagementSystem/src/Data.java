import models.base.Item;
import java.util.List;

public class Data {
    private List<Item> allItems;

    public Data(List<Item> list) {
        allItems= list;
    }

    public List<Item> getAll() {
        return allItems;
    }


}
