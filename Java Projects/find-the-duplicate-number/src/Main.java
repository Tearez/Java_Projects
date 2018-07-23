import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2,}));
    }

    public static int findDuplicate(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int number: nums) {
            if (set.contains(number)){
                ans = number;
                break;
            }else {
                set.add(number);
            }
        }
        return ans;
    }
}
