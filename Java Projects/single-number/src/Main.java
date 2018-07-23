import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        Set<Integer> numbers = new HashSet<>();
        for (int number: nums) {
            if (numbers.contains(number)){
                numbers.remove(number);
            }else {
                numbers.add(number);
            }
        }
        for (Object number : numbers) {
            ans = (int) number;
        }
        return ans;
    }
}
