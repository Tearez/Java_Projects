import base.CommandParser;
import commands.Command;
import commands.CommandType;

import java.util.Arrays;

public class CommandParserImpl implements CommandParser {
    private static final String ADD_TODO_COMMAND_NAME = "ADD-TODO";
    private static final String ADD_TASK_COMMAND_NAME = "ADD-TASK";
    private static final String ADD_TICKET_COMMAND_NAME = "ADD-TICKET";
    private static final String LIST_ALL_COMMAND_NAME = "LIST-ALL";
    private static final String LIST_TASKS_COMMAND_NAME = "LIST-TASKS";
    private static final String LIST_TODOS_COMMAND_NAME = "LIST-TODOS";
    private static final String UPDATE_TODO_COMMAND_NAME = "UPDATE-TODO";
    private static final String LIST_TICKETS_COMMAND_NAME = "LIST-TICKETS";
    private static final String LIST_TODOS_NOT_DONE_COMMAND_NAME = "LIST-TODOS-NOT-DONE";
    private static final String EXIT_COMMAND_NAME = "EXIT";
    private static final String SEARCH_COMMAND_NAME = "SEARCH";

    @Override
    public Command parseCommand(String commandString) {
        String[] commandParts = commandString.split(" ");

        CommandType commandType = getCommandTypeByName(commandParts[0]);
        String[] args = Arrays.copyOfRange(commandParts, 1, commandParts.length);
        return new Command(commandType, args);
    }

    private CommandType getCommandTypeByName(String commandName) {
        if (commandName.equals(ADD_TODO_COMMAND_NAME)) {
            return CommandType.ADD_TODO;
        }
        if (commandName.equals(ADD_TASK_COMMAND_NAME)) {
            return CommandType.ADD_TASK;
        }
        if (commandName.equals(ADD_TICKET_COMMAND_NAME)) {
            return CommandType.ADD_TICKET;
        }
        if (commandName.equals(LIST_ALL_COMMAND_NAME)) {
            return CommandType.LIST_ALL;
        }
        if (commandName.equals(LIST_TASKS_COMMAND_NAME)) {
            return CommandType.LIST_TASKS;
        }
        if (commandName.equals(LIST_TODOS_COMMAND_NAME)) {
            return CommandType.LIST_TODOS;
        }
        if (commandName.equals(UPDATE_TODO_COMMAND_NAME)) {
            return CommandType.UPDATE_TODO;
        }
        if (commandName.equals(LIST_TICKETS_COMMAND_NAME)) {
            return CommandType.LIST_TICKETS;
        }
        if (commandName.equals(LIST_TODOS_NOT_DONE_COMMAND_NAME)) {
            return CommandType.LIST_TODOS_NOT_DONE;
        }
        if (commandName.equals(EXIT_COMMAND_NAME)) {
            return CommandType.EXIT;
        }
        if (commandName.equals(SEARCH_COMMAND_NAME)){
            return CommandType.SEARCH;
        }
        return null;
    }
}
