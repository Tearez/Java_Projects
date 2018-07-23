import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        System.out.println(calcFactorial(10));
//        oneToN(1, 10);
//        System.out.println(reverse("Telerik"));
//        int n = 4;
//        List<Integer> permutation = Stream.generate(() -> 0)
//                .limit(n)
//                .collect(Collectors.toList());
//
//        getAllPermutations(0, n, permutation, new HashSet<>());

    }

    static void getAllPermutations(int index, int n, List<Integer> currentPermutation, HashSet<Integer> used) {
        if (index == n) {
            System.out.println(currentPermutation);
            return;
        }

        for (int value = 1; value <= n; value++) {
            if (!used.contains(value)) {
                continue;
            }
            used.add(value);
            currentPermutation.set(index, value);
            getAllPermutations(index + 1, n, currentPermutation, used);
            used.remove(value);
        }
    }

    static String reverse(String str) {
        if (str.length() == 0) {
            return str;
        }
        String rest = str.substring(1);
        return reverse(rest) + str.charAt(0);
    }

    static void oneToN(int index, int n) {
        if (index == n + 1) {
            return;
        }
        System.out.println(index);
        oneToN(index + 1, n);
    }

    static int calcFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * (calcFactorial(n - 1));
    }
}
