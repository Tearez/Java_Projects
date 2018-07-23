public class Main {

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        image = Solution.floodFill(image, 1, 1, 1);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.printf("%d ", image[i][j]);
            }
            System.out.println();
        }
    }

    static class Solution {
        public static int[][] floodFill(int[][] image, int startRow, int startCol, int newColor) {
            int currColor = image[startRow][startCol];
            if (currColor != newColor) {
                dfs(image, startRow, startCol, currColor, newColor);
            }
            return image;
        }

        public static void dfs(int[][] image, int row, int col, int currColor, int newColor) {
            if (image[row][col] == currColor) {
                image[row][col] = newColor;
                if (row >= 1) {
                    dfs(image, row - 1, col, currColor, newColor);
                }
                if (col >= 1) {
                    dfs(image, row, col - 1, currColor, newColor);
                }
                if (row + 1 < image.length) {
                    dfs(image, row + 1, col, currColor, newColor);
                }
                if (col + 1 < image[0].length) {
                    dfs(image, row, col + 1, currColor, newColor);
                }
            }
        }
    }
}
