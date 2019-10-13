package Classes;

import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class Pawn implements IPiece {

    //Variables
    private PieceColor color;
    private Board parentBoard;
    private Coordinate coordinate;
    private PieceType TYPE = PieceType.PAWN;
    private PieceType promotionType;

    //Methods
    @Override
    public void move(Coordinate from, Coordinate to) throws IllegalMoveException {

        //TODO: Normal Move Behavior

        if (to.getY() == 7) {

            askForPromotion();

            switch (promotionType) {
                case QUEEN: parentBoard.addPromotedPieceAt(to.getX(), to.getY(), PieceType.QUEEN); break;
                case BISHOP: parentBoard.addPromotedPieceAt(to.getX(), to.getY(), PieceType.BISHOP); break;
                case KNIGHT: parentBoard.addPromotedPieceAt(to.getX(),to.getY(), PieceType.KNIGHT); break;
                case TOWER: parentBoard.addPromotedPieceAt(to.getX(), to.getY(), PieceType.TOWER); break;
            }

            parentBoard.removePiece(this);

        }
    }

    @Override
    public PieceType getType() {
        return TYPE;
    }

    @Override
    public ArrayList<Move> getPieceMoves() {
        ArrayList<Move> moves = new ArrayList<>();

        int x = this.coordinate.getX();
        int y = this.coordinate.getY();

        Occupant beatableOccupant = null;

        if (this.color == PieceColor.BLACK) {
            beatableOccupant = Occupant.WHITE;
        } else if (this.color == PieceColor.WHITE) {
            beatableOccupant = Occupant.BLACK;
        }

        //Normal Forward move
        if (parentBoard.getOccupantOfSquare(x,y+1) == Occupant.EMPTY) {
            moves.add(new Move(this, this.coordinate, new Coordinate(x, y+1)));
        }

        //Capture to the left
        if (parentBoard.getOccupantOfSquare(x-1,y+1) == beatableOccupant) {
            moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y+1)));
        }

        //Capture to the right
        if (parentBoard.getOccupantOfSquare(x+1,y+1) == beatableOccupant) {
            moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y+1)));
        }

        //Initial Two step Move
        if (parentBoard.getOccupantOfSquare(x,y+1) == Occupant.EMPTY
                && parentBoard.getOccupantOfSquare(x, y+2) == Occupant.EMPTY
                && this.coordinate.getY() == 1) {

            moves.add(new Move(this, this.coordinate, new Coordinate(x, y+2)));
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

    private void askForPromotion() {

        //TODO: Get User Input fot the Promotion Type
        this.promotionType = PieceType.QUEEN;
    }
}