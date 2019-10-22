package Classes;

import Classes.Pieces.Pawn;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;

public class Move {

    private String algebraicIdentifier;
    private IPiece performingPiece;
    private Coordinate startCoordinate;
    private Coordinate endCoordinate;

    public Move(IPiece piece, Coordinate start, Coordinate end) {

        this.performingPiece = piece;
        this.startCoordinate = start;
        this.endCoordinate = end;

        this.calculateAlgebraicIdentifier();

    }

    private void calculateAlgebraicIdentifier() {
        String identifier = "";

        switch (this.performingPiece.getType()) {
            case QUEEN: identifier = "Q"; break;
            case KING: identifier = "K"; break;
            case PAWN: identifier = ""; break;
            case TOWER: identifier = "T"; break;
            case BISHOP: identifier = "B"; break;
            case KNIGHT: identifier = "N"; break;
        }

        identifier += endCoordinate.getAlgebraicNotation();

        algebraicIdentifier = identifier;

        correctIdentifierForCapture();
    }

    void make() {

        try {
            this.performingPiece.move(this);
        } catch (IllegalMoveException e) {
            e.printStackTrace();
            System.out.println("Move.make in Move Class not working");
        }
    }

    void revert() {
        Move moveBack = new Move(performingPiece, endCoordinate, startCoordinate);
        try {
            this.performingPiece.move(moveBack);
        } catch (IllegalMoveException e) {
            e.printStackTrace();
            System.out.println("Revert Method not working");
        }
    }

    String getAlgebraicIdentifier() {
        return algebraicIdentifier;
    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }


    //TODO: Use this method somewhere useful
    public void correctAmbiguousIdentifier() {

        removeCaptureInformation();

        String additive = startCoordinate.getAlgebraicNotation();

        //Move by a Pawn
        if (performingPiece.getType() == PieceType.PAWN) {
            if (algebraicIdentifier.length() == 2) {
                algebraicIdentifier = additive.charAt(0) + algebraicIdentifier;
            }
            else if (algebraicIdentifier.length() == 3 && additive.charAt(0) == algebraicIdentifier.charAt(0)) {
                algebraicIdentifier = additive.charAt(1) + algebraicIdentifier;
            }
            else {
                algebraicIdentifier = additive + algebraicIdentifier;
            }

        //Any other Piece
        } else {
            char piece = algebraicIdentifier.charAt(0);
            String move = endCoordinate.getAlgebraicNotation();

            if (algebraicIdentifier.length() == 3) {
                algebraicIdentifier = piece + additive.charAt(0) + move;
            }
            else if (algebraicIdentifier.length() == 4 && additive.charAt(0) == algebraicIdentifier.charAt(1)) {

                algebraicIdentifier = piece + additive.charAt(1) + move;
            }
            else {
                algebraicIdentifier = piece + additive + move;
            }
        }

        correctIdentifierForCapture();

    }

    private void removeCaptureInformation() {
        algebraicIdentifier = algebraicIdentifier.replace("x", "");
    }

    private void correctIdentifierForCapture() {

        String prefix = algebraicIdentifier.substring(0, algebraicIdentifier.length() - 2);
        String move = endCoordinate.getAlgebraicNotation();

        if (performingPiece.willCaptureOnCoordinate(endCoordinate)) {
            algebraicIdentifier = prefix + "x" + move;
        }
    }

    PieceColor performingPlayer(){
        return performingPiece.getColor();
    }

    Coordinate getStartCoordinate() {
        return this.startCoordinate;
    }

    void checkForPromotion() {

        if (performingPiece.getType() == PieceType.PAWN) {

            int pawnRow = endCoordinate.getY();

            if (pawnRow == 7 || pawnRow == 0) {
                Pawn promotionPawn = (Pawn) performingPiece;
                promotionPawn.promote(this);
            }
        }
    }
}
