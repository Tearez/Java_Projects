import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());
        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(in.nextLine()));
        }
        int largest = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if(largest<list.get(j+1)){
                    largest = list.get(j+1);
                }
            }
            list.set(list.indexOf(largest), 0);
            sum+=largest;
            largest=0;
        }
        System.out.println(sum);
    }
}
