package Classes.Pieces;

import Classes.Coordinate;
import Classes.Move;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public abstract class Piece implements IPiece {

    //Variables:
    //TODO: Which Variables are in all Subclasses?

    //Methods:
    @Override
    public void move(Coordinate from, Coordinate to) throws IllegalMoveException {
        //TODO: Implement here if it is the same for all classes
    }

    @Override
    public PieceType getType() {
        //TODO: Implement here if it is the same for all classes
        return null;
    }

    @Override
    public ArrayList<Move> getPieceMoves() {
        //TODO: Implement here if it is the same for all classes
        return null;
    }

    @Override
    public PieceColor getColor() {
        //TODO: Implement here if it is the same for all classes
        return null;
    }

    @Override
    public Pair<Integer, Integer> getCoordinates() {
        //TODO: Implement here if it is the same for all classes
        return null;
    }
}
