public class FileMessage extends Messages implements Downloadable{
    private String fileAddress;


    public FileMessage(String author, String fileAddress) {
        super(author, messageType.File);
        this.fileAddress = fileAddress;
    }

    @Override
    public void download() {
        System.out.println("File Downloaded");
    }

    @Override
    public String toString() {
        return String.format("[%s] %s : %s [upvotes: %d]", getTimeStamp(), getAuthor(), fileAddress);
    }

}
