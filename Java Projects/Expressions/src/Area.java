import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = Integer.parseInt(console.nextLine());

        for (int i = 1,k=0; i <= a; i++) {
            if ((i==1)||(i==a)){
                for(k=0; k<a; k++){System.out.print("*");}
                System.out.println("");
            }
            else{
                System.out.print("*");
                for(k=0; k<a-2; k++){System.out.print(" ");}
                System.out.println("*");
            }
        }
    }
}
