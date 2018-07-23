import java.util.ArrayList;

public class Channel {
    private String channelName;
    private ArrayList<Messages> messages;


    public Channel(String channelName) {
        this.channelName = channelName;
        messages = new ArrayList<>();
    }

    public String getChannelName(){
        return this.channelName;
    }


    public Channel switchToChannel(ArrayList<Channel> channels, String channelName){
        for (Channel c: channels) {
            if (c.channelName.equals(channelName)){
                return c;
            }
        }
        System.out.println("A channel with that name doesn't exist!");
        return null;
    }

    public void sendTextMessage(String author, String messageText){
        messages.add(new TextMessage(author, messageText));
    }

    public void sendImage(String author, String imageAddress){
        messages.add(new ImageMessage(author, imageAddress));
    }

    public void sendIcon(String author, String iconAddress){
        messages.add(new IconMessage(author, iconAddress));
    }

    public void sendFile(String author, String fileAddress){
        messages.add(new FileMessage(author, fileAddress));
    }

    public void getHistory(){
        for(Messages m: messages){
            System.out.println(m.toString());
        }
    }

    public void clearHistory(){
        messages.clear();
    }
}
