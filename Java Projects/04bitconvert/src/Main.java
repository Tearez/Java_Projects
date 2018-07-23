import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        String result = "";
        String temp;
        for (int i = 0; i < array.length; i++) {
            if (i%2==0){
                temp = convertToBinary(array[i]);
                for (int j = 1; j < temp.length(); j+=2) {
                    result+= temp.charAt(j);
                }
            }
            else {
                temp = convertToBinary(array[i]);
                for (int j = 0; j < temp.length(); j+=2) {
                    result += temp.charAt(j);
                }
            }
        }
        System.out.println(result);
    }

    static String convertToBinary(int number){
        int[] binary = new int[8];

        String result = "";

        for (int i = binary.length-1; i >= 0 ; i--) {
            binary[i] = number%2;
            number = number/2;
            if (number==0){
                break;
            }
        }
        for (int i = 0; i < binary.length; i++) {
            result += binary[i];
        }
        return result;
    }
}
