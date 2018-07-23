import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int number = Integer.parseInt(in.nextLine());

        List<Integer> list= IntStream.range(0, number)
                .boxed()
                .map(x -> x * 5)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
