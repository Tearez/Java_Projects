package models.base;

import models.TicketPriority;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task extends Item {
    private Date date;
    private SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
    private TicketPriority priority;
    private Date plannedTime;
    private String assignee;


    public Task(String title, String description, Date date,
                    TicketPriority priority, Date plannedTime, String assignee) {
        super(title, description);
        this.date = date;
        this.priority = priority;
        this.plannedTime = plannedTime;
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return String.format("Title: %s Description: %s Planned at: %s Due to: %s Priority: %s Assignee: %s",
                getTitle(), getDescription(), ft.format(plannedTime), ft.format(date), priority.toString(), assignee);
    }

}
