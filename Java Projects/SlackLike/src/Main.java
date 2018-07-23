import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Channel> channels = new ArrayList<>();
        channels.add(new Channel("Main"));
        channels.add(new Channel("Spam"));

        Channel currentChannel = channels.get(0);

        while(true){
            System.console().flush();
            break;
        }
    }
}
