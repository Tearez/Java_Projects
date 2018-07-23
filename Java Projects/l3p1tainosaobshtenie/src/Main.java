import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = new StringBuffer(in.nextLine()).reverse().toString();

        message.chars()
                .filter(x -> !Character.isDigit(x))
                .mapToObj(x -> (char) x)
                .forEach(System.out::print);

    }
}
