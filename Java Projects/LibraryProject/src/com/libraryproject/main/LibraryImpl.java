package com.libraryproject.main;

import com.libraryproject.main.base.Library;
import com.libraryproject.main.data.GenericData;
import com.libraryproject.main.models.Author;
import com.libraryproject.main.models.Book;
import com.libraryproject.main.models.Student;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibraryImpl implements Library {
    private GenericData<Book> allBooks;
    private List<Student> allStudents;

    public LibraryImpl(GenericData<Book> allBooks, List<Student> allStudents) {
        this.allBooks = allBooks;
        this.allStudents = allStudents;
    }

    public GenericData<Book> getAllBooks() {
        return allBooks;
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

    private int getNewBookId(){
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int bookId = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Dimitrov970109");
            stmt = conn.createStatement();
            String sql = "select MAX(id) as id\n" +
                    "from books";
            ResultSet rs1 = stmt.executeQuery(sql);
            rs1.next();
            bookId = rs1.getInt("id");
            rs1.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return bookId;
    }

    private int getNewAuthorId(){
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int authorId = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Dimitrov970109");
            stmt = conn.createStatement();
            String sql = "select MAX(id) as id\n" +
                    "from authors";
            ResultSet rs1 = stmt.executeQuery(sql);
            rs1.next();
            authorId = rs1.getInt("id");
            rs1.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return authorId;
    }

    @Override
    public void addBook(String title, String authorName, Date releaseDate, int quantity) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Book newBook;
        Author newAuthor;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Dimitrov970109");
            stmt = conn.createStatement();
            String sql = "insert into books(title, releaseDate, quantity) values('"+title+"','"+format.format(releaseDate)+"',"+quantity+")";
            stmt.executeUpdate(sql);
            sql = "insert into authors(name) values('"+authorName+"')";
            stmt.executeUpdate(sql);
            int newAuthorId = getNewAuthorId();
            int newBookId = getNewBookId();
            sql = "insert into author_book values("+newAuthorId+", "+newBookId+")";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            newAuthor = new Author(newAuthorId, authorName);
            List<Author> temp = new ArrayList<>();
            temp.add(newAuthor);
            newBook = new Book(newBookId, title,temp,releaseDate,quantity);
            getAllBooks().add(newBook);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    @Override
    public List<Book> allBooks() {
        return allBooks.getAll();
    }

    @Override
    public List searchByTitle(String title) {
        return allBooks.searchByName(title);
    }

    @Override
    public List<Book> combinedSearch(String title, String authorName) {
        return allBooks.getAll().stream()
                .filter(x -> x.getTitle().contains(title) && x.getAuthors().stream().filter(y -> y.getTitle().contains(authorName)).collect(Collectors.toList())
                        .size() > 0).collect(Collectors.toList());
    }

}
