public class TextMessage extends Messages implements Likeable {
    private String messageText;
    private int likesCount=0;

    public TextMessage(String author, String messageText) {
        super(author, messageType.Text);
        this.messageText = messageText;
    }


    @Override
    public void likeMessage() {
        likesCount++;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s : %s [upvotes: %d]", getTimeStamp(), getAuthor(), messageText, likesCount);
    }
}
