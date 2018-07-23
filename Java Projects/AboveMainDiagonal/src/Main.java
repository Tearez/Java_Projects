import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());
        ArrayList<Integer> array = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            array.add(Integer.parseInt(in.nextLine()));
        }
        Collections.sort(array);
        for (int i = 0; i < k; i++) {

            sum += array.get(array.size()-1-i);
        }
        System.out.println(sum);
    }
}
