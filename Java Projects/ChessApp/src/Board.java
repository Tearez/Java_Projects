public class Board {
    private Spot[][] Board = new Spot[8][8];

    public Board(Spot[][] board) {
        for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[row].length; col++) {
                this.Board[row][col] = new Spot(row, col);
            }
        }
    }

    public Spot getSpot(int xPosition, int yPosition) {
        return Board[xPosition][yPosition];
    }
}
