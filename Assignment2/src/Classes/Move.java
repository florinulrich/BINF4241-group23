package Classes;

import Classes.Pieces.Pawn;
import Enumerations.CastleType;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;

import java.util.ArrayList;

public class Move {

    private String algebraicIdentifier;
    private IPiece performingPiece;
    private Coordinate startCoordinate;
    private Coordinate endCoordinate;
    private boolean isEnPassantMove = false;
    private Coordinate enPassantBeatenPiece;
    private boolean leadsToCheck = false;
    private boolean leadsToCheckmate = false;
    private Move towerMove;
    private boolean isCastleMove = false;
    private CastleType castleType;


    public boolean leadsToCheckmate() {
        return leadsToCheckmate;
    }

    void setLeadsToCheckmate(boolean leadsToCheckmate) {
        this.leadsToCheckmate = leadsToCheckmate;
    }

    public boolean leadsToCheck() {
        return leadsToCheck;
    }

    void setLeadsToCheck(boolean leadsToCheck) {
        this.leadsToCheck = leadsToCheck;
    }

    public Move(IPiece piece, Coordinate start, Coordinate end) {

        this.performingPiece = piece;
        this.startCoordinate = start;
        this.endCoordinate = end;

        this.calculateAlgebraicIdentifier();

    }

    public Move(IPiece piece, Coordinate start, Coordinate end, boolean enPassant, Coordinate pieceToBeBeaten) {

        this.performingPiece = piece;
        this.startCoordinate = start;
        this.endCoordinate = end;
        this.isEnPassantMove = enPassant;
        this.enPassantBeatenPiece = pieceToBeBeaten;

        this.calculateAlgebraicIdentifier();
        correctAmbiguousIdentifier();
    }

    public Move(IPiece piece, Coordinate start, Coordinate end, CastleType type, Move towerMove) {

        this.performingPiece = piece;
        this.startCoordinate = start;
        this.endCoordinate = end;

        this.isCastleMove = true;
        this.towerMove = towerMove;
        this.castleType = type;

        calculateAlgebraicIdentifier();


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

        if (isCastleMove) {
            if (this.castleType == CastleType.LONG) {
                algebraicIdentifier = "0-0-0";
            } else {
                algebraicIdentifier = "0-0";
            }
        }
    }

    void make() {

        try {
            this.performingPiece.move(this);

            if (isCastleMove) {
                towerMove.make();
            }

        } catch (IllegalMoveException e) {
            e.printStackTrace();
            System.out.println("Move.make in Move Class not working");
        }
    }

    void revert() {
        Move moveBack = new Move(performingPiece, endCoordinate, startCoordinate);
        try {
            this.performingPiece.move(moveBack);

            if (isCastleMove) {
                towerMove.revert();
            }

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
    void correctAmbiguousIdentifier() {

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

            StringBuilder prefix = new StringBuilder();
            char piece = algebraicIdentifier.charAt(0);
            prefix.append(piece);
            String move = endCoordinate.getAlgebraicNotation();

            if (algebraicIdentifier.length() == 3) {
                prefix.append(additive.charAt(0));
            }
            else if (algebraicIdentifier.length() == 4 && additive.charAt(0) == algebraicIdentifier.charAt(1)) {

                prefix.append(additive.charAt(1));
            }
            else {
                prefix.append(additive);
            }

            algebraicIdentifier = prefix + move;
        }

        correctIdentifierForCapture();

    }

    private void removeCaptureInformation() {
        algebraicIdentifier = algebraicIdentifier.replace("x", "");
    }

    private void correctIdentifierForCapture() {

        String prefix = algebraicIdentifier.substring(0, algebraicIdentifier.length() - 2);
        String move = endCoordinate.getAlgebraicNotation();

        if (performingPiece.willCaptureOnCoordinate(endCoordinate) || this.isEnPassantMove) {
            algebraicIdentifier = prefix + "x" + move;
        }
    }

    public void correctIdentifierForCheck() {

        if (leadsToCheck) {
            algebraicIdentifier = algebraicIdentifier + "+";
        }
    }

    public void correctIdentifierForCheckmate() {

        if (leadsToCheckmate) {
            algebraicIdentifier = algebraicIdentifier.replace("+", "");
            algebraicIdentifier = algebraicIdentifier + "#";
        }
    }

    PieceColor performingPlayer(){
        return performingPiece.getColor();
    }

    PieceType performingPieceType() {
        return performingPiece.getType();
    }

    ArrayList<Move> getPerformingPiecesMoves() {
        return performingPiece.getPieceMoves();
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

    Coordinate getEnPassantBeatenPiece() {
        if (isEnPassantMove) {
            return enPassantBeatenPiece;
        }
        return null;
    }
}
