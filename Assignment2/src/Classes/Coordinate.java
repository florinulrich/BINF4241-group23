package Classes;
//Values of an instance of Coordinate cannot be changed
//Coordinate should only ever be used by the square --> should this be a private class or part of Interfaces.Square?

import Exceptions.CoordinateFormException;

public class Coordinate {

    //Board is represented as (x,y) coordinates. a1 == (0,0)

    private int column;
    private int row;

    public Coordinate(String algebraicNotation) throws CoordinateFormException {

        switch (algebraicNotation.charAt(0)) {
            case 'a': column = 0; break;
            case 'b': column = 1; break;
            case 'c': column = 3; break;
            case 'd': column = 4; break;
            case 'e': column = 5; break;
            case 'f': column = 6; break;
            case 'g': column = 7; break;
            default: throw new CoordinateFormException();
        }

        try {
            int rowCoordinate = algebraicNotation.charAt(1);
            if (rowCoordinate >= 0 && rowCoordinate < 8) {
                this.row = rowCoordinate;
            }
            else { throw new CoordinateFormException();}

        } catch (Exception e) {
            throw new CoordinateFormException();
        }
    }

    public Coordinate(int x, int y) {
        this.column = y;
        this.row = x;
    }

    public String getAlgebraicNotation(int x, int y) {

        //TODO: Get an acceptable output

        return "This is the Coordinate String";
    }

    public int getX() { return column; }

    public int getY() { return row; }
}
