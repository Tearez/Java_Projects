import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Zadacha1 {
    static void enterNumber() {
        Scanner scan = new Scanner(System.in);
        int a, b;
        System.out.print("Enter a number ");
        while (true) {
            try {
                a = Integer.parseInt(scan.nextLine());
                b = a * 2;
                System.out.printf("%d * 2=%d", a, b);
                break;
            } catch (Exception e) {
                System.err.println(Arrays.toString(e.getStackTrace()) + " " + new Date());
            }
        }
    }
}
