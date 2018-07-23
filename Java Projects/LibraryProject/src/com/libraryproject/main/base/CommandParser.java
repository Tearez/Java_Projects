package com.libraryproject.main.base;

import com.libraryproject.main.commands.Command;

public interface CommandParser {
    Command parseCommand(String commandString);
}
