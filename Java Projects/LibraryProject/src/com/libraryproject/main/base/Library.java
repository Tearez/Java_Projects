package com.libraryproject.main.base;

import com.libraryproject.main.models.Book;

import java.util.Date;
import java.util.List;

public interface Library {
    void addBook(String title, String authorName, Date releaseDate, int quantity);

    List<Book> allBooks();

    List searchByTitle(String title);

    List<Book> combinedSearch(String title, String authorName);

}
