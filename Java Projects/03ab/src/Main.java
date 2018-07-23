import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = Integer.parseInt(in.nextLine());
        String[] numbers = in.nextLine().split(" ");
        Arrays.sort(numbers);
        ArrayList<String> results = variations(numbers, length, new ArrayList<>(), new StringBuilder());
        for (String str: results) {
            System.out.println(str);
        }
    }
    static ArrayList<String> variations(String[] numbers, int length, ArrayList<String> output, StringBuilder variation) {
        if (length == 0) {
            output.add(variation.toString());
        } else {
            for (String number : numbers) {
                variation.append(number);
                variations(numbers, length - 1, output, variation);
                variation.deleteCharAt(variation.length() - 1);
            }
        }
        return output;
    }
}
