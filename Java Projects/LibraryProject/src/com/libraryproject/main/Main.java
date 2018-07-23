package com.libraryproject.main;

import com.libraryproject.main.base.Library;
import com.libraryproject.main.data.GenericData;
import com.libraryproject.main.models.Author;
import com.libraryproject.main.models.Book;
import com.libraryproject.main.models.Student;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "Dimitrov970109";

    public static void main(String[] args) {
        LibraryImpl LibraryImpl = new LibraryImpl(allBooks(), allUsers());
        CommandParserImpl cmdParser = new CommandParserImpl();

        Application app = new Application(cmdParser,LibraryImpl);

        app.run();
    }

    public static GenericData<Book> allBooks() {
        Connection conn = null;
        Statement stmt = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        GenericData<Book> books = new GenericData<>();
        Book newBook;
        List<Author> authorsList;
        List<Student> users = new ArrayList<>();
        Author newAuthor;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT b.id, b.title, b.releaseDate, b.quantity, a.id as authorId, a.name \n" +
                    "FROM books as b\n" +
                    "join authors as a on b.id IN(\n" +
                    "\tselect book_id\n" +
                    "    from author_book\n" +
                    "    where author_id = a.id)\n" +
                    "order by b.id ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String date = rs.getString("releaseDate");
                int quantity = rs.getInt("quantity");
                int authorId = rs.getInt("authorId");
                String authorName = rs.getString("name");
                newAuthor = new Author(authorId, authorName);
                authorsList = new ArrayList<>();
                authorsList.add(newAuthor);
                newBook = new Book(id, title, authorsList, format.parse(date), quantity);
                books.add(newBook);
            }

            rs.close();
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
        return books;
    }

    public static List<Student> allUsers() {
        Connection conn = null;
        Statement stmt = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        GenericData<Book> books = new GenericData<>();
        Book newBook;
        List<Author> authorsList;
        List<Student> users = new ArrayList<>();
        Author newAuthor;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql = "select id, userName, studentName, password\n" +
                    "from users";

            ResultSet rs1 = stmt.executeQuery(sql);

            while (rs1.next()) {
                //Retrieve by column name
                int userId = rs1.getInt("id");
                String userName = rs1.getString("userName");
                String studentName = rs1.getString("studentName");
                String password = rs1.getString("password");
                Student newStudent = null;
                GenericData<Book> studentBooks = studentBooks(userName);
                newStudent = new Student(userId, userName, studentName, password, studentBooks);
                users.add(newStudent);
            }
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
        return users;
    }

    public static GenericData<Book> studentBooks(String userName) {
        Connection conn = null;
        Statement stmt = null;

        GenericData<Book> books = new GenericData<>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Author> authorsList;
        Author newAuthor;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql = "SELECT b.id, b.title, b.releaseDate, b.quantity, a.id as authorId, a.name \n" +
                    "FROM books as b\n" +
                    "join authors as a on b.id IN(\n" +
                    "\tselect book_id\n" +
                    "    from author_book\n" +
                    "    where author_id = a.id)\n" +
                    "join users as u on b.id in(\n" +
                    "\tselect book_id\n" +
                    "    from user_book\n" +
                    "    where user_id = u.id)\n" +
                    "where u.userName = '" + userName + "'";
            ;

            ResultSet rs1 = stmt.executeQuery(sql);

            while (rs1.next()) {
                int bookId = rs1.getInt("id");
                String bookTitle = rs1.getString("title");
                Date releaseDate = format.parse(rs1.getString("releaseDate"));
                int quantity = rs1.getInt("quantity");
                int authorId = rs1.getInt("authorId");
                String authorName = rs1.getString("name");
                newAuthor = new Author(authorId, authorName);
                authorsList = new ArrayList<>();
                authorsList.add(newAuthor);
                Book newBook = new Book(bookId, bookTitle, authorsList, releaseDate, quantity);
                books.add(newBook);
            }
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
        return books;
    }
}