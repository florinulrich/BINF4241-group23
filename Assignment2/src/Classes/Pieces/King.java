package Classes.Pieces;

import Classes.Board;
import Classes.Coordinate;
import Classes.Move;
import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class King implements IPiece {

    //Variables
    private PieceColor color;
    private Board parentBoard;
    private Coordinate coordinate;
    private static final PieceType TYPE = PieceType.KING;

    //Initializer
    public King(Board board, int xCoordinate, int yCoordinate, PieceColor color) {

        Coordinate coordinate = new Coordinate(xCoordinate, yCoordinate);

        this.parentBoard = board;
        this.coordinate = coordinate;
        this.color = color;
    }

    //Methods
    @Override
    public void move(Move move) throws IllegalMoveException {    }

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

        //Search Up
        if (y+1 < 8) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x, y + 1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x, y + 1)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x, y + 1)));
            }
        }

        //Search Up Right
        if (x+1 < 8 && y+1 < 8) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x+1, y + 1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y + 1)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y + 1)));
            }
        }

        //Search Up Left
        if (x-1 >= 0 && y+1 < 8) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x-1, y + 1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y + 1)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y + 1)));
            }
        }

        //Search Down
        if (y-1 >= 0) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x, y - 1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x, y - 1)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x, y - 1)));
            }
        }

        //Search Down Right
        if (x+1 < 8 && y-1 >= 0) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x+1, y - 1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y - 1)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y - 1)));
            }
        }

        //Search Down Left
        if (x-1 >=0 && y-1 >= 0) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x-1, y - 1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y - 1)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y - 1)));
            }
        }

        //Search Right
        if (x+1 < 8) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x+1, y);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y)));
            }
        }

        //Search Left
        if (x-1 >=0) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x-1, y);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y)));
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
        return new Pair<>(this.coordinate.getX(), this.coordinate.getY());
    }
}
