import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.nextLine());
        ArrayList<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            permutation.add(i+1);
        }
        getAllPermutations(0, number, permutation, new HashSet<>());
    }

    static void getAllPermutations(int index, int n, ArrayList<Integer> currentPermutation, HashSet<Integer> used) {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                if (i != n-1) {
                    System.out.print(currentPermutation.get(i) + " ");
                } else {
                    System.out.print(currentPermutation.get(i));
                }
            }
            System.out.println();
            return;
        }

        for (int value = 1; value <= n; value++) {
            if (used.contains(value)) {
                continue;
            }
            used.add(value);
            currentPermutation.set(index, value);
            getAllPermutations(index + 1, n, currentPermutation, used);
            used.remove(value);
        }
    }
}
