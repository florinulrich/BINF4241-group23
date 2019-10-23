package Classes.Pieces;

import Classes.Board;
import Classes.Coordinate;
import Classes.Move;
import Enumerations.CastleType;
import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Interfaces.IPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class King implements IPiece {

    //TODO: Implement Castle

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
    public void move(Move move) {

        this.coordinate = move.getEndCoordinate();
    }

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
        if ((x-1) >= 0 && y+1 < 8) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x-1, y + 1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y + 1)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y + 1)));
            }
        }

        //Search Down
        if ((y-1) >= 0) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x, y - 1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x, y - 1)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x, y - 1)));
            }
        }

        //Search Down Right
        if (x+1 < 8 && (y-1) >= 0) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x+1, y - 1);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y - 1)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x+1, y - 1)));
            }
        }

        //Search Down Left
        if ((x-1) >= 0 && (y-1) >= 0) {
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
        if ((x-1) >=0) {
            Occupant squareStatus = parentBoard.getOccupantOfSquare(x-1, y);
            if (squareStatus == Occupant.EMPTY) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y)));
            } else if (squareStatus == beatableOccupant) {
                moves.add(new Move(this, this.coordinate, new Coordinate(x-1, y)));
            }
        }

        // castle
        // TODO: Notation 0-0 or 0-0-0 (short and long castle)

        // TODO: Check if King and corresponding Tower numberOfMoves = 0
        //       Check if King is not in check

        // TODO: Relevant Squares f1(5,0) and g1(6,0) for 0-0 WHITE
        //       Relevant Squares b1(1,0), c1(2,0) and d1(3,0) for 0-0-0 WHITE
        //       Relevant Squares f8(5,7) and g8(6,7) for 0-0 BLACK
        //       Relevant Squares b8(1,7), c8(2,7) and d8(3,7) for 0-0-0 BLACK

        // TODO: Check if relevant Squares are EMPTY
        //       Check if relevant Squares are under attack, except b1(1,0) and b8(1,7)

        // TODO: Move King from e1(4,0) to g1(6,0) for 0-0 WHITE
        //       Move Tower form h1(7,0) to f1(5,0) for 0-0 WHITE
        // TODO: Move King from e1(4,0) to c1(2,0) for 0-0-0 WHITE
        //       Move Tower form a1(0,0) to d1(3,0) for 0-0-0 WHITE
        // TODO: Move King from e8(4,7) to g8(6,7) for 0-0 BLACK
        //       Move Tower form h8(7,7) to f8(5,7) for 0-0 BLACK
        // TODO: Move King from e8(4,7) to c8(2,7) for 0-0-0 BLACK
        //       Move Tower form a8(0,7) to d8(3,7) for 0-0-0 BLACK

        // TODO: Check if King is not in check

        // Long Castle

        if (parentBoard.kingCanCastle(this.color, CastleType.SHORT) && x == 4 && (y == 0 || y == 7)
                && parentBoard.getPieceAt(new Coordinate(7, y)) != null) {

            moves.add(new Move(this, this.coordinate, new Coordinate(x+2, y), CastleType.SHORT,
                    parentBoard.getPieceAt(new Coordinate(7, y))));

        }

        // Short Castle
        if (parentBoard.kingCanCastle(this.color, CastleType.LONG) && x == 4 && (y == 0 || y == 7)
                && parentBoard.getPieceAt(new Coordinate(0, y)) != null) {

            moves.add(new Move(this, this.coordinate, new Coordinate(x-2, y), CastleType.LONG,
                    parentBoard.getPieceAt(new Coordinate(0, y))));
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
        } else return occupant == Occupant.WHITE && this.getColor() == PieceColor.BLACK;
    }
}
