public class IllegalMoveException extends Exception{

    public IllegalMoveException() {
        super("Piece can not perform this move");
    }
}
