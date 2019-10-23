package Classes;

import Exceptions.CoordinateFormException;

public class Coordinate {

    //Board is represented as (x,y) coordinates. a1 == (0,0)

    private int column;
    private int row;
    private String algebraicNotation;

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
            if (rowCoordinate < 8) {
                this.row = rowCoordinate;
            }
            else { throw new CoordinateFormException();}

        } catch (Exception e) {
            throw new CoordinateFormException();
        }

        this.algebraicNotation = algebraicNotation;
    }

    public Coordinate(int x, int y){
        this.column = x;
        this.row = y;
        try {
            this.algebraicNotation = calculateAlgebraicNotation(x,y);
        } catch (Exception ignored) {
        }
    }

    private static String calculateAlgebraicNotation(int x, int y) throws CoordinateFormException {

        String algebraic = "";

        switch (x) {
            case 0: algebraic += "a"; break;
            case 1: algebraic += "b"; break;
            case 2: algebraic += "c"; break;
            case 3: algebraic += "d"; break;
            case 4: algebraic += "e"; break;
            case 5: algebraic += "f"; break;
            case 6: algebraic += "g"; break;
            case 7: algebraic += "h"; break;
            default: throw new CoordinateFormException();
        }

        if (y >= 0 && y < 8) {
            algebraic += (y + 1);
        }
        else { throw new CoordinateFormException(); }


        return algebraic;
    }

    String getAlgebraicNotation() {
        return algebraicNotation;
    }

    public int getX() { return column; }

    public int getY() { return row; }

    boolean equals(Coordinate coordinate) {
        return coordinate.getX() == this.getX() && coordinate.getY() == this.getY();
    }
}
