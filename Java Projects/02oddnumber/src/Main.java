import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numbersCount = Integer.parseInt(in.nextLine());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < numbersCount; i++) {
            long curr = Long.parseLong(in.nextLine());
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
            } else {
                int value = map.get(curr);
                value++;
                map.put(curr, value);
            }
        }

        for (Long key : map.keySet()) {
            int value = map.get(key);
            if (value % 2 == 1){
                System.out.println(key);
                break;
            }
        }
    }
}
