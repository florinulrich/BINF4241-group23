public interface Piece {

    //Moves the Piece, throws an exception if the Piece can not go there
    public void move(Coordinate from, Coordinate to) throws IllegalMoveException;

    //Get the Pieces Type, may be Nil!
    public PieceType getType();

    //Returns all moves the piece could make,
    public Move[] getPieceMoves();

    public PieceColor getColor();
}
