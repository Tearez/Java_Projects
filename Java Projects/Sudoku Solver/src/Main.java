import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String line = in.nextLine();
            for (int j = 0; j < 9; j++) {
                if (line.charAt(j) == '-') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
            }
        }

        if (solveSudoku(grid)) {
            for (int[] aGrid : grid) {
                for (int j = 0; j < grid[0].length; j++) {
                    System.out.print(aGrid[j]);
                }
                System.out.println();
            }
        }

    }

    static boolean isAdditionValid(int[][] grid, int row, int col) {
        return (rowValid(grid, row)
                && columnValid(grid, col)
                && subsectionValid(grid, row, col));
    }

    static boolean columnValid(int[][] grid, int col) {
        boolean[] constraint = new boolean[grid.length];
        return IntStream.range(0, 9)
                .allMatch(row -> checkConstraint(grid, row, constraint, col));

    }

    static boolean rowValid(int[][] grid, int row) {
        boolean[] constraint = new boolean[grid.length];
        return IntStream.range(0, 9)
                .allMatch(column -> checkConstraint(grid, row, constraint, column));
    }

    static boolean subsectionValid(int[][] grid, int row, int col) {
        boolean[] constraint = new boolean[grid.length];
        int subsectionRowStart = (row / 3) * 3;
        int subsectionRowEnd = subsectionRowStart + 3;

        int subsectionColumnStart = (col / 3) * 3;
        int subsectionColumnEnd = subsectionColumnStart + 3;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(grid, r, constraint, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkConstraint(int[][] grid, int row, boolean[] constraint, int column) {
        if (grid[row][column] != 0) {
            if (!constraint[grid[row][column] - 1]) {
                constraint[grid[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean solveSudoku(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        grid[row][column] = k;
                        if (isAdditionValid(grid, row, column) && solveSudoku(grid)) {
                            return true;
                        }
                        grid[row][column] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}