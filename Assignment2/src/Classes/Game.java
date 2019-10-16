package Classes;

import Classes.Pieces.Pawn;
import Enumerations.PieceColor;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;

public class Game {



    static public void main(String[] args) {
        Board board = new Board();

        Coordinate coordinate = new Coordinate(7, 1);
        IPiece pawn = new Pawn(board, coordinate, PieceColor.WHITE);
        board.addPiece(pawn);
        board.printBoard();
        try {
            pawn.move(pawn.getPieceMoves().get(0).getEndCoordinate());
        } catch (IllegalMoveException e) {
            e.printStackTrace();
        }
        System.out.println();

        board.printBoard();

    }
}
