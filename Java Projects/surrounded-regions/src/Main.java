import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}};

        solve(board);
    }

    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]=='A'){
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void dfs(char[][] board, int row, int col) {
        if (board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'A';
        if (row > 0) {
            dfs(board, row - 1, col);
        }
        if (row < board.length - 1) {
            dfs(board, row + 1, col);
        }
        if (col > 0) {
            dfs(board, row, col - 1);
        }
        if (col < board[0].length - 1) {
            dfs(board, row, col + 1);
        }
    }

}
