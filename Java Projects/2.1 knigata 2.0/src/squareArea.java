import java.util.Scanner;

public class squareArea {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("a = ");
        Double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Area = " + a*a);
    }
}
