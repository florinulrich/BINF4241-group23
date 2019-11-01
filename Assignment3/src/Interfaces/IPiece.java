package Interfaces;

import Classes.Coordinate;
import Classes.Move;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import javafx.util.Pair;

import java.util.ArrayList;

public interface IPiece {

    //Moves the Interfaces.Piece, throws an exception if the Interfaces.Piece can not go there
    void move(Move move) throws IllegalMoveException;

    //Get the Pieces Type, may be Nil!
    PieceType getType();

    //Returns all moves the piece could make,
    ArrayList<Move> getPieceMoves();

    PieceColor getColor();

    Pair<Integer, Integer> getCoordinates();

    boolean willCaptureOnCoordinate(Coordinate coordinate);
}
