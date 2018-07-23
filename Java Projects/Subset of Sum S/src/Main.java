import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int sum = Integer.parseInt(in.nextLine());

        ArrayList<Integer> list = new ArrayList<>();

        String[] numbers = in.nextLine().split(" ");

        for (String str : numbers
                ) {
            list.add(Integer.parseInt(String.valueOf(str)));
        }
        System.out.println(checkSubSet(list, sum)?"yes":"no");
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


    static boolean isSubsetOfSum(ArrayList<Integer> list, int sizeOfArray, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sizeOfArray == 0 && sum != 0) {
            return false;
        }

        if (list.get(sizeOfArray - 1) > sum) {
            return isSubsetOfSum(list, sizeOfArray - 1, sum);
        }
        return isSubsetOfSum(list, sizeOfArray - 1, sum) ||
                isSubsetOfSum(list, sizeOfArray - 1, sum - list.get(sizeOfArray - 1));
    }
}
