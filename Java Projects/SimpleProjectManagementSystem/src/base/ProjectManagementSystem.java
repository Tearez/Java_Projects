package base;

import models.TicketPriority;
import models.TodoState;

import java.util.Date;

public interface ProjectManagementSystem {

    void addTicket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner);

    void addTodo(String title, String description, TodoState state);

    void addTask(String title, String description, Date dueDate, TicketPriority priority, Date plannedTime, String assignee);

    void listAll();

    void listTickets();

    void listTodos();

    void listTodos(TodoState state);

    void listTasks();

    void searchByTitleOrDescription(String pattern);

    void changeTodoState(String pattern);
}
