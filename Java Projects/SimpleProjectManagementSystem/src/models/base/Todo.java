package models.base;

import models.TodoState;

public class Todo extends Item {
    private TodoState state;

    public Todo(String title, String description, TodoState state) {
        super(title, description);
        this.state = state;
    }

    public TodoState getState() {
        return state;
    }

    public void setState(TodoState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Title: %s Description: %s State: %s",
                getTitle(), getDescription(), state.toString());
    }
}
