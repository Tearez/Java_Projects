public class ChessPiece {
    private int xPosition;
    private int yPosition;
    private boolean isAvailable;

    public ChessPiece(int xPosition, int yPosition, boolean isAvailable) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isAvailable = isAvailable;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isValidMovement(Board Board, int currentX, int currentY, int toX, int toY) {
        if (currentX == toX && currentY == toY) {
            return false;
        }
        if (currentX < 0 || currentX > 7 || currentY < 0 || currentY > 7 || toX < 0 || toX > 7 || toY < 0 || toY > 0){
            return false;
        }
        return true;
    }
}
