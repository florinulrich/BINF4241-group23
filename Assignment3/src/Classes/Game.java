package Classes;

import Classes.Pieces.*;
import Enumerations.PieceColor;
import Interfaces.IPiece;

public class Game {

    static public void main(String[] args) {

        tester();


        Board board = new Board();
        pieceSetup(board);
        board.startGame();

    }

    private static void tester() {
    /* tester

    board.printBoard();
    try {
        pawn.move(pawn.getPieceMoves().get(0));
    } catch (IllegalMoveException e) {
        e.printStackTrace();
    }
    System.out.println();
    */

        //Test board.getOccupant WORKS
//        System.out.println(board.getOccupantOfSquare(0,0)); //Must return white
//        System.out.println(board.getOccupantOfSquare(7,7)); //Must return black


        //Test getPiece Moves
//        IPiece pawn = new Pawn(board,0, 1, PieceColor.WHITE);
//        board.addPiece(pawn);
//
//        try {
//            board.makeMove("a3", PieceColor.WHITE);
//        } catch (IllegalMoveException e) {
//            e.printStackTrace();
//        }
//
//        board.printBoard();

//        String algebraicIdentifier = "Tcxd3";
//
//
//        algebraicIdentifier = algebraicIdentifier.replace("x", "");
//
//        System.out.println(algebraicIdentifier);
    }

    private static void pieceSetup(Board board) {
        // WHITE Player
        // --pawns
        for (int i = 0; i <= 7; i++) {
            IPiece pawn = new Pawn(board, i, 1, PieceColor.WHITE);
            board.addPiece(pawn);
        }
        // --towers
        IPiece tower_w_1 = new Tower(board, 0, 0, PieceColor.WHITE);
        board.addPiece(tower_w_1);
        IPiece tower_w_2= new Tower(board, 7, 0, PieceColor.WHITE);
        board.addPiece(tower_w_2);

        // --knights
        IPiece knight_w_1 = new Knight(board, 1, 0, PieceColor.WHITE);
        board.addPiece(knight_w_1);
        IPiece knight_w_2= new Knight(board, 6, 0, PieceColor.WHITE);
        board.addPiece(knight_w_2);

        // --bishops
        IPiece bishop_w_1 = new Bishop(board, 2, 0, PieceColor.WHITE);
        board.addPiece(bishop_w_1);
        IPiece bishop_w_2= new Bishop(board, 5, 0, PieceColor.WHITE);
        board.addPiece(bishop_w_2);

        // --queen
        IPiece queen_w = new Queen(board, 3, 0, PieceColor.WHITE);
        board.addPiece(queen_w);

        // --king
        IPiece king_w = new King(board, 4, 0, PieceColor.WHITE);
        board.addPiece(king_w);

        // BLACK Player
        // --pawns
        for (int i = 0; i <= 7; i++) {
            IPiece pawn = new Pawn(board, i, 6, PieceColor.BLACK);
            board.addPiece(pawn);
        }
        // --towers
        IPiece tower_b_1 = new Tower(board, 0, 7, PieceColor.BLACK);
        board.addPiece(tower_b_1);
        IPiece tower_b_2= new Tower(board, 7, 7, PieceColor.BLACK);
        board.addPiece(tower_b_2);

        // --knights
        IPiece knight_b_1 = new Knight(board, 1, 7, PieceColor.BLACK);
        board.addPiece(knight_b_1);
        IPiece knight_b_2= new Knight(board, 6, 7, PieceColor.BLACK);
        board.addPiece(knight_b_2);

        // --bishops
        IPiece bishop_b_1 = new Bishop(board, 2, 7, PieceColor.BLACK);
        board.addPiece(bishop_b_1);
        IPiece bishop_b_2= new Bishop(board, 5, 7, PieceColor.BLACK);
        board.addPiece(bishop_b_2);

        // --queen
        IPiece queen_b = new Queen(board, 3, 7, PieceColor.BLACK);
        board.addPiece(queen_b);

        // --king
        IPiece king_b = new King(board, 4, 7, PieceColor.BLACK);
        board.addPiece(king_b);
    }

}
