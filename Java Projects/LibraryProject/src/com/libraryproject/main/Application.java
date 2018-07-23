package com.libraryproject.main;

import com.libraryproject.main.commands.Command;
import com.libraryproject.main.commands.CommandType;
import com.libraryproject.main.models.Student;

import java.text.ParseException;
import java.util.Date;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Application {

    private CommandParserImpl cmdParser;
    private LibraryImpl system;

    public Application(CommandParserImpl cmdParser, LibraryImpl system) {
        this.cmdParser = cmdParser;
        this.system = system;
    }

    void run() {
        boolean existingUser = false;
        while (!existingUser) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Username: ");
            String userName = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            Student currentStudent = system.getAllStudents().stream()
                    .filter(x -> x.getTitle()
                            .equals(userName) && x.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);
            if (currentStudent != null) {
                mainMenu(currentStudent);
                existingUser = true;
            } else {
                System.out.println("Wrong Username or Password!!");
            }
        }
    }

    void mainMenu(Student current) {
        Scanner in = new Scanner(System.in);
        String[] menuArr = {"1. Donate a book (ADD-BOOK)\n",
                "2. List every book in the Library(LIST-ALL-BOOKS)\n",
                "3. List the books you rented(LIST-BOOKS)\n",
                "4. Search for a book by it's name(SEARCH-BY-NAME)\n",
                "5. Search for a book by it's name and author(COMBINED-SEARCH)\n",
                "6. Exit(EXIT)\n\n",
                "Enter command -->  "};
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while (true) {
            Arrays.stream(menuArr).forEach(System.out::print);

            String commandString = in.nextLine();
            Command command = this.cmdParser.parseCommand(commandString);
            if (command.getCommandType() == CommandType.EXIT) {
                break;
            }

            switch (command.getCommandType()) {
                case ADD_BOOK:
                    System.out.print("ENTER the book title: ");
                    String bookTitle = in.nextLine();
                    System.out.print("ENTER the authors name: ");
                    String authorName = in.nextLine();
                    System.out.print("ENTER the books release date: ");
                    Date releaseDate;
                    while (true) {
                        try {
                            releaseDate = format.parse(in.nextLine());
                            break;
                        } catch (ParseException e) {
                            System.out.println("NOT a valid date!");
                        }
                    }
                    System.out.print("ENTER how many copies you are donating: ");
                    int quantity = Integer.parseInt(in.nextLine());
                    system.addBook(bookTitle, authorName, releaseDate, quantity);
                    break;
                case LIST_ALL_BOOKS:
                    system.getAllBooks().getAll().forEach(System.out::println);
                    break;
                case LIST_BOOKS:
                    current.getListOfBooks().getAll().forEach(System.out::println);
                    break;
                case SEARCH_BY_NAME:
                    System.out.print("ENTER the book title: ");
                    String title = in.nextLine();
                    current.getListOfBooks().searchByName(title).forEach(System.out::println);
                    break;
                case COMBINED_SEARCH:
                    System.out.print("ENTER the book title: ");
                    title = in.nextLine();
                    System.out.print("ENTER the authors name: ");
                    authorName = in.nextLine();
                    system.combinedSearch(title, authorName).forEach(System.out::println);
                    break;
                default:
                    System.out.println("Invalid Command!");
            }
        }

    }

}
