import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(Integer.parseInt(in.nextLine()));
        }

        int currentSequence = 1;
        int maxSequence = 1;
        System.out.print("");
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) < array.get(i + 1)) {
                currentSequence++;
            }
            else {
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                    //System.out.println(maxSequence);
                }
                currentSequence = 1;
            }
        }

        System.out.println(maxSequence);
    }
}
