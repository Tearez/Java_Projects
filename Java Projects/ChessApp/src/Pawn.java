public class Pawn extends ChessPiece {


    public Pawn(int xPosition, int yPosition, boolean isAvailable) {
        super(xPosition, yPosition, isAvailable);
    }

    @Override
    public boolean isValidMovement(Board Board, int currentX, int currentY, int toX, int toY) {
        if (!super.isValidMovement(Board, currentX, currentY, toX, toY)){
            return false;
        }
        else {
            if (currentY)
        }
    }
}
