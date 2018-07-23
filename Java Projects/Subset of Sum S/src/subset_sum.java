import java.util.ArrayList;
import java.util.Scanner;

public class subset_sum {
    public static void subsetOfSum() {
        Scanner in = new Scanner(System.in);
        int sum = Integer.parseInt(in.nextLine());

        ArrayList<Integer> list = new ArrayList<>();

        String[] numbers = in.nextLine().split(" ");

        for (String str : numbers
                ) {
            list.add(Integer.parseInt(String.valueOf(str)));
        }
        System.out.println(checkSubSet(list, sum));
    }

    public static boolean checkSubSet(ArrayList<Integer> list, int sum) {
        boolean[][] solution = new boolean[list.size() + 1][sum + 1];

        for (int i = 1; i <= sum; i++) {
            solution[0][i] = false;
        }

        for (int i = 0; i < list.size(); i++) {
            solution[i][0] = true;
        }

        for (int row = 1; row <= list.size(); row++) {
            for (int col = 1; col <= sum; col++) {
                solution[row][col] = solution[row-1][col];

                if (solution[row][col]==false&&col>=list.get(row-1)){
                    solution[row][col] = solution[row][col]||solution[row-1][col-list.get(row-1)];
                }
            }
        }
        return solution[list.size()][sum];
    }
}
