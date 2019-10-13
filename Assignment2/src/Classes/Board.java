package Classes;

import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class Board {

    private ArrayList<IPiece> pieces;
    private ArrayList<ArrayList<PrintSquares>> printSquares = new ArrayList<ArrayList<PrintSquares>>();

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

    public void printBoard() {
        for(int i = 0; i < 8; i++) {
            printSquares.add(new ArrayList<PrintSquares>());
        }
        for (ArrayList<PrintSquares> list: printSquares) {
            for(int i = 0; i < 8; i++) {
                list.add(new PrintSquares());
            }
        }

        for (int i = 7; i >= 0; i--) {
            String line = "";
            for (PrintSquares square: printSquares.get(i)) {
                line = line + square.getOutputString();
            }
            System.out.println(line);
        }

        for (IPiece piece: pieces) {
            //getCoordinates
            Pair<Integer, Integer> coordinates = piece.getCoordinates();
            Integer x = coordinates.getKey();
            Integer y = coordinates.getValue();

            printSquares.get(y).get(x).setOccupant(piece.getType(), piece.getColor());
        }

    }



}
