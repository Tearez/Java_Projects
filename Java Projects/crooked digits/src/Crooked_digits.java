import java.util.Scanner;

public class Crooked_digits {
    public static void numbers() {
        int num, sum = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("enter a number <=300");
        num = Integer.parseInt(scan.nextLine());
        while (true) {
            if (num > 99) {
                sum += num / 100;
                sum += (num / 10) % 10;
            }
            if(num<100){
                sum+=num/10;
            }
            sum += num % 10;
            if (sum > 9) {
                num = sum;
                sum=0;
            } else {
                break;
            }
        }
        System.out.println("The sum of the digits is " + sum);
    }
}

