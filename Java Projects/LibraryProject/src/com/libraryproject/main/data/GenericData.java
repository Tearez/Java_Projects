package com.libraryproject.main.data;

import com.libraryproject.main.data.base.Data;
import com.libraryproject.main.models.base.IHaveID;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericData<T extends IHaveID> implements Data {
    private List<Object> values = new ArrayList<>();


    @Override
    public void add(Object Book) {
        values.add(Book);
    }

    @Override
    public List<T> getAll() {
        return values.stream()
                .map(x -> (T) x)
                .collect(Collectors.toList());
    }

    @Override
    public Object getById(int id) {
        return values.stream()
                .map(x -> (T) x)
                .filter(x->x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<T> searchByName(String sequence) {
        return values.stream()
                .map(x-> (T) x)
                .filter(x->x.getTitle().contains(sequence))
                .collect(Collectors.toList());
    }

}
