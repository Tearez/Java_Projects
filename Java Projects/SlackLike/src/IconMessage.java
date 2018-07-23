public class IconMessage extends Messages {
    public String iconAddress;

    public IconMessage(String author, String iconAddress) {
        super(author, messageType.Icon);
        this.iconAddress = iconAddress;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s : %s ", getTimeStamp(), getAuthor(), iconAddress);
    }
}
