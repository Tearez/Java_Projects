import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Messages {
    private String author;
    private messageType type;
    private String timeStamp;
    private Date currentTime = new Date();
    SimpleDateFormat time = new SimpleDateFormat("hh:mm");

    public Messages(String author, messageType type) {
        this.author = author;
        this.type = type;
        timeStamp = currentTime.toString();

    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getAuthor() {
        return author;
    }


}
