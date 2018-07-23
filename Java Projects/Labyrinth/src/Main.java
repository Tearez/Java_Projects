public class Main {

    public static void main(String[] args) {
        var lab = new char[][]{
                {'x', ' ', ' ', ' ', 'x', ' ', 'x', 'x'},
                {'s', ' ', 'x', ' ', ' ', ' ', ' ', ' '},
                {'x', ' ', 'x', ' ', 'x', 'x', ' ', ' '},
                {'x', ' ', 'x', ' ', 'x', 'x', ' ', ' '},
                {'x', ' ', ' ', ' ', 'x', 'x', ' ', ' '},
                {'x', ' ', ' ', ' ', 'x', 'x', 'e', 'x'}

        };

        var hasExit = pathsExists(1, 0, lab);
        System.out.println(hasExit);
    }

    static boolean inRange(int value, int max) {
        return 0 <= value && value < max;
    }

    static boolean pathsExists(int row, int col, char[][] lab) {
        int rows = lab.length;
        int cols = lab[row].length;

        int[] dRows = {0, -1, 0, 1};
        int[] dCols = {-1, 0, 1, 0};

        for (int dir = 0; dir < dRows.length; dir++) {
            var nextRow = row + dRows[dir];
            var nextCol = col + dCols[dir];

            // outside of the lab
            if (!inRange(nextRow, rows) || !inRange(nextCol, cols)) {
                continue;
            }
            // cell already visited or wall
            if (lab[nextRow][nextCol] == 'x') {
                continue;
            }
            // exit
            if (lab[nextRow][nextCol] == 'e') {
                return true;
            }

            lab[nextRow][nextCol] = 'x';
            var hasPath = pathsExists(nextRow, nextCol, lab);
            lab[nextRow][nextCol] = ' ';
            if (hasPath){
                return true;
            }
        }
        return false;
    }
}
