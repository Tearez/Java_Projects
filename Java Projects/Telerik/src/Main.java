import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, K, sum = 0;
        N = Integer.parseInt(scanner.nextLine());
        int[] array = new int[N];
        K = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < K; i++) {
            sum += array[array.length - 1 - i];
        }
        System.out.println(sum);
    }
}
