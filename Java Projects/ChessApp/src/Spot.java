public class Spot {
    private int xPosition;
    private int yPosition;
    ChessPiece piece;

    public Spot(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.piece = null;
    }

    public boolean isSpotOccupied() {
        return piece != null;
    }

    public void OccupySpot(ChessPiece piece){
        if(this.piece!=null){
            this.piece.setAvailable(false);
        }
        this.piece = piece;
    }


}
