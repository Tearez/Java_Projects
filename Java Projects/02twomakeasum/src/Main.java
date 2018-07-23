
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] numbers = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] results = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        for (String str : numbers
//                ) {
//            list.add(Integer.parseInt(String.valueOf(str)));
//        }
//        for (String str: results) {
//            sums.add(Integer.parseInt(str));
//        }
        int counter = 0;
        for (int result : results) {
            counter += checkSum(numbers, result);
        }
        System.out.println(counter);
    }

    static int checkSum(int[] list, int sum) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > sum) {
                continue;
            }
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] > sum) {
                    continue;
                }
                if (list[i] + list[j] == sum) {
                    return 1;
                }
            }
        }
        return 0;
    }

}