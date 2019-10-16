package Classes;

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
    }

    public void make() {
        try {
            this.performingPiece.move(this);
        } catch (IllegalMoveException e) {
            e.printStackTrace();
            System.out.println("Move.make in Move Class not working");
        }
    }

    public boolean isLegal() {

        //TODO: return if move is legal or not
        return true;
    }

    public String getAlgebraicIdentifier() {
        return algebraicIdentifier;
    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }

    public void correctAmbiguousIdentifier() {
        if (algebraicIdentifier.length() = )

    }
}
