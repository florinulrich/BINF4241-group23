package Classes;

import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;
import javafx.util.Pair;

import java.util.ArrayList;

import java.util.Scanner;

public class Board {

    private ArrayList<IPiece> pieces =  new ArrayList<>();
    private ArrayList<ArrayList<PrintSquares>> printSquares = new ArrayList<ArrayList<PrintSquares>>();

    private ArrayList<Move> legalMovesBlack;
    private ArrayList<Move> legalMovesWhite;

    private int scoreWhite = 0;
    private int scoreBlack = 0;

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

    //Needs to check if move is possible in the move array of the respective player
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
        for (IPiece piece: pieces) {
            if (piece.getCoordinates().equals(new Pair<>(xCoordinate, yCoordinate))) {
                switch (piece.getColor()) {
                    case BLACK: return Occupant.BLACK;
                    case WHITE: return Occupant.WHITE;
                }
            }
        }
        return Occupant.EMPTY;
    }

    public void addPromotedPieceAt(int x, int y, PieceType type) {

    }

    public void removePiece(IPiece piece) {
        this.pieces.remove(piece);

        if (piece.getcolor() == WHITE) {
            scoreWhite += 1;
        } else {
            scoreBlack += 1;
        }
    }

    public void addPiece(IPiece piece) {
        this.pieces.add(piece);
    }

    public void printBoard() {

        printSquares = new ArrayList<>();

        for(int i = 0; i < 8; i++) {
            printSquares.add(new ArrayList<PrintSquares>());
        }
        for (ArrayList<PrintSquares> list: printSquares) {
            for(int i = 0; i < 8; i++) {
                list.add(new PrintSquares());
            }
        }

        for (IPiece piece: this.pieces) {
            //getCoordinates
            Pair<Integer, Integer> coordinates = piece.getCoordinates();
            Integer x = coordinates.getKey();
            Integer y = coordinates.getValue();

            printSquares.get(y).get(x).setOccupant(piece.getType(), piece.getColor());
        }

        for (int i = 7; i >= 0; i--) {

            String line = "("+ (i+1) +")"+"\t";

            for (PrintSquares square: printSquares.get(i)) {
                line = line + square.getOutputString();
            }
            System.out.print(line + "\t\t HISTORY");
            if (i==7){
                System.out.println("\t\t WHITE Player score: " + scoreWhite);
            } else if (i==6){
                System.out.println("\t\t BLACK Player score: " + scoreBlack);
            } else{
                System.out.print("\n");
            }
        }

        System.out.println("\t(a )(b )(c )(d )(e )(f )(g )(h )\n");
        System.out.println("COLOR Player move >> ");

        //TODO: Space after Board and some way to show the moves that have been made (last 8 for example)

    }

}
