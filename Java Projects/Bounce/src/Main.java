import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        in.nextLine();
        BigInteger result = BigInteger.ZERO;
        result = result.add(calculations(0,0));
        if (rows==1&&cols==2){
            System.out.println(result.toString());
            return;
        }
        int currentRow = 1;
        int currentCol = 1;

        int indexX = 1;
        int indexY = 1;
        while (!checkCorners(currentRow, currentCol, rows - 1, cols - 1)) {
            if (checkWall(currentRow, rows - 1)) {
                indexX *= -1;
            } else if (checkWall(currentCol, cols - 1)) {
                indexY *= -1;
            }

            result = result.add(calculations(currentRow, currentCol));
            currentRow += indexX;
            currentCol += indexY;

        }
         result = result.add(calculations(currentRow,currentCol));
        System.out.println(result.toString());
    }

    static BigInteger calculations(int row, int col) {
        BigInteger number = BigInteger.ONE.add(BigInteger.ONE);
        return number.pow(row + col);
    }

    static boolean checkCorners(int currentRow, int currentCol, int rows, int cols) {
        return (currentRow == 0 && currentCol == cols)
                || (currentRow == rows && currentCol == cols)
                || (currentRow == rows && currentCol == 0);
    }

    static boolean checkWall(int value, int max) {
        return value <= 0 || value >= max;
    }
}
