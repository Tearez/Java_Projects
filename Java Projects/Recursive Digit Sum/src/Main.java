import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String string = "";
        for (int i = 0; i < k; i++) {
            string += n;
        }
        System.out.println(digitSum(string));
    }



    static long digitSum(String string){
        long p = Long.parseLong(string);
        long sum = 0;
        if (p<10){
            return p;
        }
        for (int i = 0; i < string.length(); i++) {
            sum += p%10;
            p = p/10;
        }
        return digitSum(String.valueOf(sum));
    }
}
