import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());
        Integer sum = Stream.generate(in::nextLine)
                .limit(n)
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .mapToInt(x->x)
                .sum();
        System.out.println(sum.toString());
    }

}
