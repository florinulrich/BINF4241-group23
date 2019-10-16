package Classes;

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

        //TODO; Calculate algebraicIdentifier

    }

    public void make() {
        //Performs the move
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
}
