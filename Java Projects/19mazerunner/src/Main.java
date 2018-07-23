import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = Integer.parseInt(in.nextLine());
        Stream.generate(in::nextLine)
                .limit(lines)
                .map(x-> {
            int sum1=x.chars().filter(e->(e-'0')%2==0).sum();
            int sum2=x.chars().filter(j->(j-'0')%2!=0).sum();
            if (sum1==sum2){
                return "straight";
            }
            else if (sum1>sum2){
                return "left";
            }
            else{
                return "right";
            }
        }).forEach(System.out::println);

    }
}
