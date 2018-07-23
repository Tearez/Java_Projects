public class Main {

    public static void main(String[] args) {
        int[][] grid = {{0,1}};

        System.out.println(Solution.islandPerimeter(grid));
    }

     static class Solution {
        public static int islandPerimeter(int[][] grid) {
            int perimeter = 0;

            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == 1){
                        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
                        for (int[] direction : directions) {
                            int currRow = row + direction[0];
                            int currCol = col + direction[1];

                            if (inRange(currRow, currCol, grid.length, grid[row].length)) {
                                if (grid[currRow][currCol] == 0) {
                                    perimeter++;
                                }
                            } else {
                                perimeter++;
                            }
                        }
                    }
                }
            }

            return perimeter;
        }
         static boolean inRange(int row, int col, int rows, int cols) {
             return (row >= 0 && row < rows) && (col >= 0 && col < cols);
         }
    }
}
