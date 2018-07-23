package com.libraryproject.main;

import com.libraryproject.main.base.CommandParser;
import com.libraryproject.main.commands.Command;
import com.libraryproject.main.commands.CommandType;

import java.util.Arrays;

public class CommandParserImpl implements CommandParser {
    @Override
    public Command parseCommand(String commandString) {
        String[] commandParts = commandString.split(" ");

        CommandType commandType = CommandType.fromName(commandParts[0]);
        String[] args = Arrays.copyOfRange(commandParts, 1, commandParts.length);
        return new Command(commandType, args);
    }

}
