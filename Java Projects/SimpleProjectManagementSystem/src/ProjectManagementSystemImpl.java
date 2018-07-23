import base.ProjectManagementSystem;
import base.SortByName;
import models.TicketPriority;
import models.TodoState;
import models.base.Item;
import models.base.Task;
import models.base.Ticket;
import models.base.Todo;

import java.util.*;

public class ProjectManagementSystemImpl implements ProjectManagementSystem {
    private Data dataBase = new Data(new ArrayList<>());


    @Override
    public void addTicket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner) {
        dataBase.getAll().add(new Ticket(title, description, dueDate, priority, sender, owner));
    }

    @Override
    public void addTodo(String title, String description, TodoState state) {
        dataBase.getAll().add(new Todo(title, description, state));
    }

    @Override
    public void addTask(String title, String description, Date dueDate, TicketPriority priority, Date plannedTime, String assignee) {
        dataBase.getAll().add(new Task(title, description, dueDate, priority, plannedTime, assignee));
    }

    @Override
    public void listAll() {
        dataBase.getAll().sort(new SortByName());

        dataBase.getAll().forEach(System.out::println);
    }

    @Override
    public void listTickets() {
        dataBase.getAll().sort(new SortByName());



        for (Item item : dataBase.getAll()) {
            if (item instanceof Ticket) {
                System.out.println(item.toString());
            }
        }
    }

    @Override
    public void listTodos() {
        dataBase.getAll().sort(new SortByName());

        for (Item item : dataBase.getAll()) {
            if (item instanceof Todo) {
                System.out.println(item.toString());
            }
        }
    }

    @Override
    public void listTodos(TodoState state) {
        dataBase.getAll().sort(new SortByName());

        for (Item item : dataBase.getAll()) {
            if (item instanceof Todo && ((Todo) item).getState() == TodoState.NOT_DONE) {
                System.out.println(item.toString());
            }
        }
    }

    @Override
    public void listTasks() {
        dataBase.getAll().sort(new SortByName());

        for (Item item : dataBase.getAll()) {
            if (item instanceof Todo) {
                System.out.println(item.toString());
            }
        }
    }

    @Override
    public void searchByTitleOrDescription(String pattern) {
        for (Item item : dataBase.getAll()) {
            if (item.getTitle().toLowerCase().contains(pattern.toLowerCase())
                    || item.getDescription().contains(pattern.toLowerCase())){
                System.out.println(item.toString());
            }
        }
    }

    @Override
    public void changeTodoState(String pattern) {
        boolean hasNone = true;
        for (Item item : dataBase.getAll()) {
            if (item instanceof Todo && item.getTitle().contains(pattern)){
                if (((Todo) item).getState() == TodoState.NOT_DONE){
                    ((Todo) item).setState(TodoState.DONE);
                }
                else{
                    ((Todo) item).setState(TodoState.NOT_DONE);
                }
                hasNone = false;
            }
        }
        if (hasNone){
            System.out.println("There is no ToDo with such title");
        }
    }
}
