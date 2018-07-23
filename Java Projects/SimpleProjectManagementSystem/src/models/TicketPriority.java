package models;

public enum  TicketPriority {
    HIGH, LOW;

    private static final String STATE_HIGH = "HIGH";
    private static final String STATE_LOW = "LOW";

    public static TicketPriority fromName(String name) {
        switch (name) {
            case STATE_HIGH:
                return HIGH;
            case STATE_LOW:
                return LOW;
            default:
                return null;
        }
    }
}
