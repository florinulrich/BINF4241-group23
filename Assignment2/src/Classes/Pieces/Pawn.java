package Classes.Pieces;

import Classes.Board;
import Classes.Coordinate;
import Classes.Move;
import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.CoordinateFormException;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Pawn implements IPiece {

    //Variables
    private PieceColor color;
    private Board parentBoard;
    private Coordinate coordinate;
    private PieceType TYPE = PieceType.PAWN;
    private PieceType promotionType;

    //Initializer
    public Pawn(Board board, int xCoordinate, int yCoordinate, PieceColor color) {

        Coordinate coordinate = new Coordinate(xCoordinate, yCoordinate);

        this.parentBoard = board;
        this.coordinate = coordinate;
        this.color = color;
    }

    //Methods
    @Override
    public void move(Move move) {

        Coordinate endCoordinate = move.getEndCoordinate();

        this.coordinate = endCoordinate;

    }

    @Override
    public PieceType getType() {
        return TYPE;
    }

    @Override
    public ArrayList<Move> getPieceMoves() {
        if (getColor() == PieceColor.WHITE) {
            return getPieceMovesWhite();
        } else {
            return getPieceMovesBlack();
        }
    }

    private ArrayList<Move> getPieceMovesBlack() {
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
        if (parentBoard.getOccupantOfSquare(x,y-1) == Occupant.EMPTY) {
            moves.add(new Move(this, this.coordinate, new Coordinate(x, y-1)));
        }

        //Capture to the left
        if (parentBoard.getOccupantOfSquare(x-1,y-1) == beatableOccupant) {
            moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y-1)));
        }

        //Capture to the right
        if (parentBoard.getOccupantOfSquare(x+1,y-1) == beatableOccupant) {
            moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y-1)));
        }

        //Initial Two step Move
        if (parentBoard.getOccupantOfSquare(x,y-1) == Occupant.EMPTY
                && parentBoard.getOccupantOfSquare(x, y-2) == Occupant.EMPTY
                && this.coordinate.getY() == 6) {

            moves.add(new Move(this, this.coordinate, new Coordinate(x, y-2)));
        }
        return moves;
    }

    private ArrayList<Move> getPieceMovesWhite() {
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
        return new Pair<>(this.coordinate.getX(), this.coordinate.getY());
    }

    @Override
    public boolean willCaptureOnCoordinate(Coordinate coordinate) {
        Occupant occupant = parentBoard.getOccupantOfSquare(coordinate.getX(), coordinate.getY());

        if (occupant == Occupant.BLACK && this.getColor() == PieceColor.WHITE) {
            return true;
        } else if (occupant == Occupant.WHITE && this.getColor() == PieceColor.BLACK) {
            return true;
        } else {
            return false;
        }
    }

    private void askForPromotion() {

        //TODO: Get User Input fot the Promotion Type
        Scanner playerInput = new Scanner(System.in);
        System.out.println("Enter Promotion Type >> ");

        String colorInput = playerInput.next();

        switch (colorInput.toLowerCase()) {
            case "queen":
                this.promotionType = PieceType.QUEEN;
                break;
            case "knight":
                this.promotionType = PieceType.KNIGHT;
                break;
            case "bishop":
                this.promotionType = PieceType.BISHOP;
                break;
            case "tower":
                this.promotionType = PieceType.TOWER;
                break;
            default:
                System.out.println("Invalid Type");
                askForPromotion();
        }

    }

    public void promote(Move move) {

        askForPromotion();

        Coordinate endCoordinate = move.getEndCoordinate();

        switch (promotionType) {
            case QUEEN:
                parentBoard.addPromotedPieceAt(endCoordinate.getX(), endCoordinate.getY(), PieceType.QUEEN, this.color); break;
            case BISHOP:
                parentBoard.addPromotedPieceAt(endCoordinate.getX(), endCoordinate.getY(), PieceType.BISHOP, this.color); break;
            case KNIGHT:
                parentBoard.addPromotedPieceAt(endCoordinate.getX(),endCoordinate.getY(), PieceType.KNIGHT, this.color); break;
            case TOWER:
                parentBoard.addPromotedPieceAt(endCoordinate.getX(), endCoordinate.getY(), PieceType.TOWER, this.color); break;
        }

        parentBoard.removePiece(this);

    }
}
