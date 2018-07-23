package com.libraryproject.main.models;

import com.libraryproject.main.models.base.IHaveID;

import java.util.*;
import java.util.stream.Collectors;

public class Book implements IHaveID {
    private int id;
    private String title;
    private List<Author> authors;
    private Date releaseDate;
    private int quantity;

    public Book() {
    }

    public Book(int id, String title, List<Author> authors, Date releaseDate, int quantity) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nTitle: %s\nAuthor(s): %s", id, title, authors.stream().map(x->x.toString()).collect(Collectors.joining(", ")));
    }
}
