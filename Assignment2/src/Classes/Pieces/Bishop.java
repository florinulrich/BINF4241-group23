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

public class Bishop implements IPiece {

    //Variables
    private PieceColor color;
    private Board parentBoard;
    private Coordinate coordinate;
    private static final PieceType TYPE = PieceType.BISHOP;

    //Methods
    @Override
    public void move(Coordinate to) throws IllegalMoveException {  }

    @Override
    public PieceType getType() {
        return TYPE;
    }

    @Override
    public ArrayList<Move> getPieceMoves() {

        ArrayList<Move> moves = new ArrayList<>();

        // Loop variables
        int i = 1;
        int x = this.coordinate.getX();
        int y = this.coordinate.getY();
        Occupant beatableOccupant = null;

        if (this.color == PieceColor.BLACK) {
            beatableOccupant = Occupant.WHITE;
        } else if (this.color == PieceColor.WHITE) {
            beatableOccupant = Occupant.BLACK;
        }

        //Search Up right
        while ((x+i) < 8 && (y+i) < 8) {

            Occupant squareStatus = parentBoard.getOccupantOfSquare((x+i), (y+i));
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+i, y+i)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x+i, y+i)));
                break;
            }
            else{
                break;
            }
            i++;
        }

        //Search Up left
        i = 1;

        while ((x-i) >= 0 && (y+i) < 8) {

            Occupant squareStatus = parentBoard.getOccupantOfSquare((x-i), (y+i));
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-i, y+i)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x-i, y+i)));
                break;
            }
            else{
                break;
            }
            i++;
        }

        //Search Down Right
        while ((x+i) < 8 && (y-i) >= 0) {

            Occupant squareStatus = parentBoard.getOccupantOfSquare((x+i), (y-i));
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+i, y-i)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x+i, y-i)));
                break;
            }
            else{
                break;
            }
            i++;
        }

        //Search Left
        while ((x-i) >= 0 && (y-i) >= 0) {

            Occupant squareStatus = parentBoard.getOccupantOfSquare((x-i), (y-i));
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-i, y-i)));
            }
            else if(squareStatus == beatableOccupant){
                moves.add(new Move(this, this.coordinate, new Coordinate(x-i, y-i)));
                break;
            }
            else{
                break;
            }
            i++;
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
