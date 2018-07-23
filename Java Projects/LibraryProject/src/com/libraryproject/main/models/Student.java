package com.libraryproject.main.models;

import com.libraryproject.main.data.GenericData;
import com.libraryproject.main.models.base.IHaveID;

public class Student implements IHaveID {
    private int id;
    private String userName;
    private String studentName;
    private String password;
    private GenericData<Book> listOfBooks;

    public Student(int id, String userName, String studentName, String password, GenericData<Book> listOfBooks) {
        this.id = id;
        this.userName = userName;
        this.studentName = studentName;
        this.password = password;
        this.listOfBooks = listOfBooks;
    }

    public GenericData<Book> getListOfBooks() {
        return listOfBooks;
    }

    public String getUserName() {
        return userName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return userName;
    }

    @Override
    public String toString() {
        return String.format("ID: %d UserName: %s",id,userName);
    }
}
