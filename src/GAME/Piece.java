package GAME;

public class Piece {
    public static final boolean BLACK_PIECE = true;
    public static final boolean WHITE_PIECE = false;

    private boolean pieceColor;

    public Piece(){ }

    public Piece (boolean theColor) {
        this.pieceColor = theColor;

    }
    public boolean getPieceColor() {
        return pieceColor;
    }

    public String printPieceColor() {
        if (this.pieceColor == BLACK_PIECE){
            return ("BLACK");
        }
        else{
            return ("WHITE");
        }
    }

}
