import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();

        int[][] matrix = new int[rows][cols];

        int startRow = 0, startCol = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = in.nextInt();
                if (matrix[row][col] == 0) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int[] dRows = {0, 0, -1, +1};
        int[] dCols = {-1, +1, 0, 0};

        int coinsCount = 0;



        while (!inRange(startRow, startCol, rows, cols)) {
            int currentRow = 0;
            int currentCol = 0;
            int value = 0;

            for (int i = 0; i <dRows.length; i++) {

                int nextRow = startRow + dRows[i];
                if (nextRow < 0 || nextRow > rows - 1) {
                    continue;
                }

                int nextCol = startCol + dCols[i];
                if (nextCol < 0 || nextCol > cols - 1){
                    continue;
                }

                if (matrix[nextRow][nextCol]>value){
                    value = matrix[nextRow][nextCol];
                    currentRow = nextRow;
                    currentCol = nextCol;
                }
            }

            if (value==0){
                break;
            }
            matrix[currentRow][currentCol] = value-1;
            coinsCount++;
            startRow = currentRow;
            startCol = currentCol;
        }


        System.out.println(coinsCount);
    }

    static boolean inRange(int row, int col, int rows, int cols) {
        return (row < 0 || row > rows) && (col < 0 || col > cols);
    }
}

