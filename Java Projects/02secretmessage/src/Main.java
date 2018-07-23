import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();


        System.out.println();
    }

    static int getNumber(int index, String message) {
        int number = 0;
        while (true) {
            number += Integer.parseInt(String.valueOf(message.charAt(index)));
            if (Character.isDigit(message.charAt(index + 1))) {
                number = number * 10;
                index++;
            } else {
                break;
            }
        }
        return number;
    }

    static String decodeMessage(String message, int startIndex) {
        int index = startIndex;
        StringBuilder decodedMessage = new StringBuilder();

        while (index < message.length()) {
            char currentChar = message.charAt(index);
            String number = "";
            int parsedNumber = 0;
            while (Character.isDigit(currentChar)){
                number+=currentChar;
                index++;
                currentChar = message.charAt(index);
            }

            index++;
            parsedNumber = Integer.parseInt(number);

            while (Character.isLetter(currentChar)) {
                index++;
                currentChar = message.charAt(index);
            }

            for (int i = 0; i < parsedNumber; i++) {

            }

            String incodedMessage = message.substring(startIndex, index);


        }
    }
}
