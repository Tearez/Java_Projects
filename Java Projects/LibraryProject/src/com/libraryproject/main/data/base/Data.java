package com.libraryproject.main.data.base;

import java.util.Date;
import java.util.List;

public interface Data<T> {
    void add(T Book);

    List<T> getAll();

    T getById(int id);

    List<T> searchByName(String sequence);
}
