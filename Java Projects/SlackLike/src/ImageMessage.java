public class ImageMessage extends Messages implements Likeable, Downloadable {
    private String imageAddress;
    private int likesCount=0;

    public ImageMessage(String author, String imageAddress) {
        super(author, messageType.Image);
        this.imageAddress = imageAddress;
    }

    @Override
    public void likeMessage() {
        likesCount++;
    }

    @Override
    public void download() {
        System.out.println("File Downloaded");
    }

    @Override
    public String toString() {
        return String.format("[%s] %s : %s [upvotes: %d]", getTimeStamp(), getAuthor(), imageAddress, likesCount);
    }
}
