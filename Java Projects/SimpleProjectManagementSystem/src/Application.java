import base.CommandParser;
import base.ProjectManagementSystem;
import commands.Command;
import commands.CommandType;
import models.TicketPriority;
import models.TodoState;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    //private static final String EXIT_STATE = "EXIT";
    private final CommandParser commandParser;
    private ProjectManagementSystem system;
    private DateFormat format = new SimpleDateFormat("yyyy.MM.dd");

    public Application(CommandParser commandParser, ProjectManagementSystem system) {
        this.system = system;
        this.commandParser = commandParser;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String commandString = in.nextLine();
            Command command = this.commandParser.parseCommand(commandString);
            if (command.getCommandType() == CommandType.EXIT) {
                break;
            }

            switch (command.getCommandType()) {
                case ADD_TODO:
                    String title = command.getParams()[0];
                    String description = command.getParams()[1];
                    TodoState state;
                    if (command.getParams().length == 3) {
                        state = TodoState.fromName(command.getParams()[2]);
                    } else {
                        state = TodoState.fromName(command.getParams()[2] + " " + command.getParams()[3]);
                    }
                    system.addTodo(title, description, state);
                    break;
                case ADD_TASK:
                    title = command.getParams()[0];
                    description = command.getParams()[1];
                    TicketPriority priority = TicketPriority.fromName(command.getParams()[2]);
                    Date dueDate;
                    Date plannedTime;
                    try {
                        dueDate = format.parse(command.getParams()[3]);
                        plannedTime = format.parse(command.getParams()[4]);
                    } catch (ParseException e) {
                        System.out.println("Invalid Date");
                        continue;
                    }
                    String assignee = command.getParams()[5] + "" + command.getParams()[6];
                    system.addTask(title, description, dueDate, priority, plannedTime, assignee);
                    break;
                case ADD_TICKET:
                    title = command.getParams()[0];
                    description = command.getParams()[1];
                    priority = TicketPriority.fromName(command.getParams()[2]);
                    try {
                        dueDate = format.parse(command.getParams()[3]);
                    } catch (ParseException e) {
                        System.out.println("Invalid Date");
                        continue;
                    }
                    String sender = command.getParams()[4] + "" + command.getParams()[5];
                    String owner = command.getParams()[6] + "" + command.getParams()[7];
                    system.addTicket(title, description, dueDate, priority, sender, owner);
                    break;
                case LIST_ALL:
                    system.listAll();
                    break;
                case LIST_TASKS:
                    system.listTasks();
                    break;
                case LIST_TODOS:
                    system.listTodos();
                    break;
                case UPDATE_TODO:
                    String pattern = command.getParams()[0];
                    system.changeTodoState(pattern);
                    break;
                case LIST_TICKETS:
                    system.listTickets();
                    break;
                case LIST_TODOS_NOT_DONE:
                    system.listTodos(TodoState.NOT_DONE);
                    break;
                case SEARCH:
                    pattern = command.getParams()[0];
                    system.searchByTitleOrDescription(pattern);
                    break;
            }
        }
    }
}
