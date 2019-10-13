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
    public void move(Coordinate from, Coordinate to) throws IllegalMoveException;

    //Get the Pieces Type, may be Nil!
    public PieceType getType();

    //Returns all moves the piece could make,
    public ArrayList<Move> getPieceMoves();

    public PieceColor getColor();

    public Pair<Integer, Integer> getCoordinates();
}
