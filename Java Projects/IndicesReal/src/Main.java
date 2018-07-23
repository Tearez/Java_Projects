import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = Integer.parseInt(in.nextLine());
        String[] numbers = in.nextLine().split(" ");

        ArrayList<Integer> array = new ArrayList<>();
        for (String number : numbers) {
            array.add(Integer.parseInt(number));
        }
        int currentIndex = 0;
        boolean hasLoop = false;
        ArrayList<String> newArray = new ArrayList<>();
        HashSet<Integer> used = new HashSet<>();
        while (true) {
            if (currentIndex > array.size() || currentIndex < 0) {
                break;
            }
            if (used.contains(currentIndex)) {
                hasLoop = true;
                newArray.set(newArray.size() - 1, newArray.get(newArray.size() - 1) + ")");
                break;
            }

            newArray.add(String.valueOf(currentIndex));
            used.add(currentIndex);
            currentIndex = array.get(currentIndex);
        }
        if (hasLoop) {
            newArray.set(newArray.indexOf(String.valueOf(currentIndex)), "(" + currentIndex);

            for (int i = 0; i < newArray.size() - 1; i++) {
                if (newArray.get(i).matches("-?\\d+(\\.\\d+)?") && newArray.get(i + 1).matches("-?\\d+(\\.\\d+)?")) {
                    System.out.print(newArray.get(i) + " ");
                } else if (!newArray.get(i).matches("-?\\d+(\\.\\d+)?") && !newArray.get(i + 1).matches("-?\\d+(\\.\\d+)?")) {
                    System.out.print(newArray.get(i));
                } else if (!newArray.get(i).matches("-?\\d+(\\.\\d+)?") && newArray.get(i + 1).matches("-?\\d+(\\.\\d+)?")) {
                    System.out.print(newArray.get(i) + " ");
                } else if (newArray.get(i).matches("-?\\d+(\\.\\d+)?") && !newArray.get(i + 1).matches("-?\\d+(\\.\\d+)?")) {
                    System.out.print(newArray.get(i));
                }

            }
            if (!newArray.get(newArray.size() - 1).matches("-?\\d+(\\.\\d+)?")) {
                System.out.print(" " + newArray.get(newArray.size() - 1));
            }
        } else {
            for (int i = 0; i < newArray.size(); i++) {
                if (i == newArray.size() - 1) {
                    System.out.print(newArray.get(i));
                } else {
                    System.out.print(newArray.get(i) + " ");
                }
            }
        }
    }
}