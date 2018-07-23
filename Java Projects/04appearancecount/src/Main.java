import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        List<Integer> list = Stream.generate(in::nextInt)
                .limit(size)
                .collect(Collectors.toList());
        in.nextLine();
        int wanted = Integer.parseInt(in.nextLine());
        System.out.println(list.stream()
            .filter(x->x==wanted)
            .count());
    }
}
