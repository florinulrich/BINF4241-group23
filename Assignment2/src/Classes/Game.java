package Classes;

import Classes.Pieces.Pawn;
import Enumerations.PieceColor;

public class Game {



    static public void main(String[] args) {
        Board board = new Board();

        Coordinate coord = new Coordinate(1, 1);
        board.addPiece(new Pawn(board, coord, PieceColor.WHITE));
        board.printBoard();
    }
}
