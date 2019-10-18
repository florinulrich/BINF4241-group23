package Classes;

import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.CheckmateException;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;
import javafx.beans.binding.BooleanExpression;
import javafx.util.Pair;

import java.util.ArrayList;

import java.util.Scanner;

public class Board {

    private ArrayList<IPiece> pieces =  new ArrayList<>();

    private ArrayList<Move> legalMovesBlack = new ArrayList<>();
    private ArrayList<Move> legalMovesWhite = new ArrayList<>();

    private int scoreWhite = 0;
    private int scoreBlack = 0;

    private ArrayList<Move> history = new ArrayList<>();

    private void computeLegalMoves() {

        legalMovesWhite = new ArrayList<>();
        legalMovesBlack = new ArrayList<>();

        for (IPiece piece: pieces) {

            ArrayList<Move> PieceMoves = piece.getPieceMoves();

            for (Move move: PieceMoves) {
                if (move.isLegal() && piece.getColor() == PieceColor.BLACK) {
                    legalMovesBlack.add(move);
                } else {
                    legalMovesWhite.add(move);
                }
            }
        }

        removeSuicideMoves(PieceColor.WHITE, legalMovesWhite, PieceColor.BLACK);
        removeSuicideMoves(PieceColor.BLACK, legalMovesBlack, PieceColor.WHITE);
    }

    //Needs to check if move is possible in the move array of the respective player
    public void makeMove(String algebraicMove, PieceColor playerColor) throws CheckmateException {

        computeLegalMoves();

        ArrayList<Move> moveArray;

        if (playerColor == PieceColor.WHITE) {
            moveArray = legalMovesWhite;
        } else {
            moveArray = legalMovesBlack;
        }


        Move chosenMove = null;
        for (Move move: moveArray) {
            if (move.getAlgebraicIdentifier().equals(algebraicMove)) { chosenMove = move; }
        }

        if (chosenMove == null) {
            System.out.println("Chosen move: " + algebraicMove);
            System.out.println("This is not a legal move, try another one!");
            System.out.println("Available Moves:");

            for (Move move: moveArray) {
                System.out.print(move.getAlgebraicIdentifier() + " ");
            }
            System.out.println();

            String newMove = getMoveInput();
            makeMove(newMove, playerColor);

        } else {
            chosenMove.make();

            history.add(chosenMove);
        }
        computeLegalMoves();

        //After move is performed, is the opponent checkmated?

        // If there are no moves available it is checkmate
        // Player is now checkmated, if he has no moves available -> Stalemate == Checkmate

        ArrayList<Move> opponentMoves;
        PieceColor opponentColor;
        if (playerColor == PieceColor.BLACK) {
            opponentMoves = legalMovesWhite;
        } else {
            opponentMoves = legalMovesBlack;
        }

        if (opponentMoves.isEmpty()) {
            System.out.println("Checkmate! Player " + playerColor + " wins!");
            throw new CheckmateException();
        }
    }

    private String getMoveInput(){

        Scanner playerInput = new Scanner(System.in);
        String playerMove = playerInput.next();

        return playerMove;
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

        //TODO: Pawn Promotion

    }

    public void removePiece(IPiece piece) {
        this.pieces.remove(piece);

        if (piece.getColor() == PieceColor.WHITE) {
            scoreBlack += 1;
        } else {
            scoreWhite += 1;
        }
    }

    public void addPiece(IPiece piece) {
        this.pieces.add(piece);
    }

    public void printBoard() {

        ArrayList<ArrayList<PrintSquares>> printSquares = new ArrayList<>();

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

            System.out.print(line + "\t\t History");

//            //get history from arraylist and print out latest history
//            //if arraylist has more than 7 items:
//            if(history.size() >= 8){
//                Move getHistory = history.get(history.size() - i + 1);
//                String historyLine = getHistory.getAlgebraicIdentifier();
//                System.out.print(line + "\t\t " + historyLine);
//                }
//
//            //if arraylist has less than 8 items:
//            else{
//                for(int n = 1; n <= history.size(); n++) {
//                    Move getHistory = history.get(history.size() - n);
//                    String historyLine = getHistory.getAlgebraicIdentifier();
//                    System.out.print(line + "\t\t " + historyLine);
//                    }
//            }

            if (i==7){
                System.out.println("\t\t WHITE Player score: " + scoreWhite);
            } else if (i==6){
                System.out.println("\t\t BLACK Player score: " + scoreBlack);
            } else{
                System.out.print("\n");
            }
        }

        System.out.println("\t(a )(b )(c )(d )(e )(f )(g )(h )\n");

        PieceColor colorCurrent = PieceColor.WHITE;

        if (history.size() > 0) {
            colorCurrent = history.get(history.size() - 1).performingPlayer();
        }

        System.out.print(colorCurrent + " Player move >> ");

        String nextMove = getMoveInput();
        try {
            makeMove(nextMove, colorCurrent);
            printBoard();
        } catch (CheckmateException e) {
            return;
        }

        //TODO: Space after Board and some way to show the moves that have been made (last 8 for example)

    }

    private void removeSuicideMoves(PieceColor playerColor, ArrayList<Move> playerMoves , PieceColor opponentColor) {

        for (Move move: playerMoves) {

            boolean illegal = false;

            move.make();

            ArrayList<Move> opponentMoves = new ArrayList<>();
            for (IPiece piece: pieces) {
                if (piece.getColor().equals(opponentColor)) {
                    opponentMoves.addAll(piece.getPieceMoves());
                }
            }

            if (kingIsChecked(playerColor, opponentMoves)) {
                illegal = true;
            }

            move.revert();

            if (illegal) {
                playerMoves.remove(move);
            }

        }

        //1. Make Move
        //2. Check for check
        //3. Save result
        //4. Revert Move
        //5. If necessary remove move from list

    }

    private boolean kingIsChecked(PieceColor color, ArrayList<Move> opponentsMoves) {

        Coordinate kingCoordinate = null;

        for (IPiece piece: pieces) {
            if (piece.getType() == PieceType.KING && piece.getColor() == color) {
                Pair<Integer, Integer> coordinatePair = piece.getCoordinates();
                kingCoordinate = new Coordinate(coordinatePair.getKey(), coordinatePair.getValue());
            }
        }


        for (Move move: opponentsMoves) {
            assert kingCoordinate != null;
            if (move.getEndCoordinate().equals(kingCoordinate)) {
                return true;
            }
        }

        return false;
    }

}
