import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int moves = in.nextInt();
        in.nextLine();
        int startRow = in.nextInt();
        int startCol = in.nextInt();
        in.nextLine();
        int[] moveX = new int[moves];
        int[] moveY = new int[moves];
        for (int i = 0; i < moves; i++) {
            String[] m = in.nextLine().split(" ");
            moveX[i] = Integer.parseInt(m[0]);
            moveY[i] = Integer.parseInt(m[1]);
        }
        int index = 0;
        int numberOfMoves = 0;
        long sumOfNumbers = 0;
        boolean[][] visited = new boolean[rows][cols];

        while (true) {
            if (isInBox(startRow, rows, startCol, cols)) {
                System.out.println("escaped " + sumOfNumbers);
                break;
            }
            if (visited[startRow][startCol]) {
                System.out.println("caught " + numberOfMoves);
                break;
            }

            sumOfNumbers += sumNumbers(startRow, startCol, cols);
            visited[startRow][startCol] = true;
            startRow += moveX[index];
            startCol += moveY[index];
            index++;
            numberOfMoves++;
            if (index == moves ) {
                index = 0;
            }
        }
    }

    static boolean isInBox(int row, int rows, int col, int cols) {
        return (row < 0 || row >= rows) || (col < 0 || col >= cols);
    }

    static long sumNumbers(int row, int col, int cols) {
        return 1 + col + cols*row;
    }
}
