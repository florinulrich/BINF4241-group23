package Classes;

import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class Knight implements IPiece {

    //Variables
    private PieceColor color;
    private Board parentBoard;
    private Coordinate coordinate;
    private static final PieceType TYPE = PieceType.KNIGHT;

    //Methods
    @Override
    public void move(Coordinate from, Coordinate to) throws IllegalMoveException { }

    @Override
    public PieceType getType() {
        return TYPE;
    }

    @Override
    public ArrayList<Move> getPieceMoves() {

        ArrayList<Move> moves = new ArrayList<>();

        // Variables
        int x = this.coordinate.getX();
        int y = this.coordinate.getY();
        Occupant beatableOccupant = null;

        if (this.color == PieceColor.BLACK) {
            beatableOccupant = Occupant.WHITE;
        } else if (this.color == PieceColor.WHITE) {
            beatableOccupant = Occupant.BLACK;
        }

        //Search Up Right var 1
        if (x+1 < 8 && y+2 < 8){
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x+1, y+2);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y+2)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y+2)));
            }
        }

        //Search Up Right var 2
        if (x+2 < 8 && y+1 < 8){
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x+2, y+1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+2, y+1)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x+2, y+1)));
            }
        }

        //Search Up Left var 1
        if (x-1 >= 0 && y+2 < 8){
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x-1, y+2);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y+2)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y+2)));
            }
        }

        //Search Up Left var 2
        if (x-2 >= 0 && y+1 < 8){
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x-2, y+1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-2, y+1)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x-2, y+1)));
            }
        }

        //Search Down Right var 1
        if (x+1 < 8 && y-2 >= 0){
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x+1, y-2);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y-2)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y-2)));
            }
        }

        //Search Down Right var 2
        if (x+2 < 8 && y-1 >= 0){
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x+2, y-1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+2, y-1)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x+2, y-1)));
            }
        }

        //Search Down Left var 1
        if (x-1 >= 0 && y-2 < 8){
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x-1, y-2);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y-2)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y-2)));
            }
        }

        //Search Up Left var 2
        if (x-2 >= 0 && y-1 < 8){
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x-2, y-1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-2, y-1)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x-2, y-1)));
            }
        }

        return moves;
    }

    @Override
    public PieceColor getColor() {
        return color;
    }

    @Override
    public Pair<Integer, Integer> getCoordinates() {
        return null;
    }
}
