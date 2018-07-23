import java.util.Scanner;

public class CtoF {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Celsius degrees = ");
        Double celsius = Double.parseDouble(scanner.nextLine());
        Double fahrenheit = (celsius*1.8)+32;
        System.out.printf("Fahrenheit degrees = %g", fahrenheit);
    }
}
