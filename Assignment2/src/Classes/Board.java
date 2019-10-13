package Classes;

import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;

import java.util.ArrayList;

public class Board {

    private ArrayList<IPiece> pieces;

    private ArrayList<Move> legalMovesBlack;
    private ArrayList<Move> legalMovesWhite;


    private void computeLegalMovesFor(ArrayList<Move> movesArray, PieceColor color) {

        for (IPiece piece: pieces) {
            if (piece.getColor() == color) {

                ArrayList<Move> PieceMoves = piece.getPieceMoves();

                for (Move move: PieceMoves) {
                    if (move.isLegal()) {movesArray.add(move);}
                }
            }
        }
    }

    public void makeMove(String algebraicMove, ArrayList<Move> moveArray) throws IllegalMoveException {

        Move chosenMove = null;
        for (Move move: moveArray) {
            if (move.getAlgebraicIdentifier() == algebraicMove) { chosenMove = move; }
        }

        if (chosenMove == null) {
            throw new IllegalMoveException();
        } else {
            chosenMove.make();
        }
    }

    public Occupant getOccupantOfSquare(int xCoordinate, int yCoordinate) {
        return Occupant.EMPTY;
        //TODO: Implement this!
        //Also Check for the case that the Square does not exist --> return null
    }

    public void addPromotedPieceAt(int x, int y, PieceType type) {

        //TODO: Add the promoted Piece
    }

    public void removePiece(IPiece piece) {
        //TODO: Remove piece from Board
    }



}
