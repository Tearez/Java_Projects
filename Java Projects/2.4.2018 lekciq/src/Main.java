import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        /*numberTriangle(n);*/
        ArrayList<Integer> list = getAllPrimesTo(n);
        for (int i = 0; i < list.size(); i++) {
            if(i!=list.size()-1){
                System.out.print(list.get(i)+" ");
            }
            else{
                System.out.print(list.get(i));
            }
        }
    }

    static void numberTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static boolean checkPrime(int number) {
        int maxDivider = (int) Math.sqrt(number);
        boolean isPrime = true;

        for (int i = 2; i <= maxDivider; i++) {
            if (number % i != 0) {
                return isPrime;
            }
        }
        return isPrime;
    }

    static ArrayList<Integer> getAllPrimesTo(int number) {
        ArrayList<Integer> primes = new ArrayList<>();
        List<Boolean> isPrime = Stream.generate(() -> true).limit(number + 1).collect(Collectors.toList());
        for (int i = 2; i < number + 1; i++) {
            for (int j = i * 2; j < number + 1; j += i) {
                isPrime.set(j - 1, false);
            }
        }
        for (int i = 0; i < isPrime.size()-1; i++) {
            if (!isPrime.get(i)) {
                continue;
            } else {
                primes.add(i + 1);
            }
        }
        return primes;
    }

}
