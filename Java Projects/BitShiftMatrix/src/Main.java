import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        in.nextLine();
        in.nextLine();
        int[] codes = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[][] visited = new boolean[rows][cols];

        int row = rows - 1;
        int col = 0;
        int coef = Math.max(rows, cols);
        BigInteger result = BigInteger.ZERO;

        for (int move : codes) {
            int nextRow = move / coef;
            int nextCol = move % coef;

            int colDir = (col < nextCol) ? +1 : -1;
            while (col!=nextCol){
                visited[row][col] = true;
                col += colDir;
            }

            int rowDir = (row < nextRow) ? +1 : -1;
            while (row != nextRow) {
                visited[row][col] = true;
                row += rowDir;
            }
            visited[row][col] = true;
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (visited[r][c]){
                     result = result.add(getValue(rows-1-r,c));
                }
            }
        }

        System.out.println(result.toString());
    }

    static BigInteger getValue(int row, int col) {
        int power = row + col;
        return BigInteger.TWO.pow(power);
    }
}
