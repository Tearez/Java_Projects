package models.base;

import models.TicketPriority;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Ticket extends Item{
    private Date date;
    private SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
    private TicketPriority priority;
    private String sender;
    private String owner;

    public Ticket(String title, String description, Date date, TicketPriority priority, String sender, String owner) {
        super(title, description);
        this.date = date;
        this.priority = priority;
        this.sender = sender;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("Title: %s Description: %s Planned date: %s Priority: %s Sender: %s Owner: %s",
                getTitle(), getDescription(), ft.format(date), priority.toString(), sender, owner);
    }
}
