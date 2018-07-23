package base;

import models.base.Item;

import java.util.Comparator;

public class SortByName implements Comparator<Item> {


    @Override
    public int compare(Item o1, Item o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
