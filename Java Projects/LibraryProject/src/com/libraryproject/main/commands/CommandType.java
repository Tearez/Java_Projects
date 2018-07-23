package com.libraryproject.main.commands;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {
    LOGIN, EXIT, ADD_BOOK, LIST_ALL_BOOKS, LIST_BOOKS, SEARCH_BY_NAME, COMBINED_SEARCH, NONE;

    private static final String LOGIN_COMMAND_NAME = "LOGIN";
    private static final String ADD_BOOK_COMMAND_NAME = "ADD-BOOK";
    private static final String LIST_ALL_BOOKS_COMMAND_NAME = "LIST-ALL-BOOKS";
    private static final String LIST_USER_BOOKS_COMMAND_NAME = "LIST-BOOKS";
    private static final String EXIT_COMMAND_NAME = "EXIT";
    private static final String SEARCH_BY_NAME_COMMAND_NAME = "SEARCH-BY-NAME";
    private static final String COMBINED_SEARCH_COMMAND_NAME = "COMBINED-SEARCH";

    private static final Map<String, CommandType> namesToCommandTypes;


    static {
        namesToCommandTypes = new HashMap<>();
        namesToCommandTypes.put(LOGIN_COMMAND_NAME, LOGIN);
        namesToCommandTypes.put(ADD_BOOK_COMMAND_NAME, ADD_BOOK);
        namesToCommandTypes.put(LIST_ALL_BOOKS_COMMAND_NAME, LIST_ALL_BOOKS);
        namesToCommandTypes.put(LIST_USER_BOOKS_COMMAND_NAME, LIST_BOOKS);
        namesToCommandTypes.put(SEARCH_BY_NAME_COMMAND_NAME, SEARCH_BY_NAME);
        namesToCommandTypes.put(COMBINED_SEARCH_COMMAND_NAME, COMBINED_SEARCH);
        namesToCommandTypes.put(EXIT_COMMAND_NAME, EXIT);
    }

    public static CommandType fromName(String commandName) {
        if (!namesToCommandTypes.containsKey(commandName)) {
            return NONE;
        }

        return namesToCommandTypes.get(commandName);
    }

}
