import java.util.Scanner;

public class inchToCents {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inches = ");
        Double inches = Double.parseDouble(scanner.nextLine());
        Double centimeters = inches*2.54;
        System.out.printf("Centimerters = %g", centimeters);
    }
}
