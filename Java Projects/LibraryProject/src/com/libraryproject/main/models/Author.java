package com.libraryproject.main.models;

import com.libraryproject.main.models.base.IHaveID;

public class Author implements IHaveID {
    private int id;
    private String name;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\tName: %s", id, name);
    }
}
