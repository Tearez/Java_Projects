import java.util.Scanner;

public class radToDegrees {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("rads = ");
        Double rads = Double.parseDouble(scanner.nextLine());
        Double degrees = (180/Math.PI)*rads;
        System.out.printf("degrees = %g", degrees);
    }
}
