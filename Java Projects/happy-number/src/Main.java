import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);

            n = getSum(n);

            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    public static int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sum;
    }
}
