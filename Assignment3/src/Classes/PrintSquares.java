package Classes;


import Enumerations.PieceColor;
import Enumerations.PieceType;

class PrintSquares{
    private String occupant = "  ";
    private String occupantColor = "";

    void setOccupant(PieceType type, PieceColor color) {
        switch (type) {
            case KING: occupant = "K"; break;
            case PAWN: occupant = "P"; break;
            case QUEEN: occupant = "Q"; break;
            case TOWER: occupant = "T"; break;
            case BISHOP: occupant = "B"; break;
            case KNIGHT: occupant = "N"; break;
        }

        switch (color) {
            case BLACK: occupantColor = "B"; break;
            case WHITE: occupantColor = "W"; break;
        }
    }

    String getOutputString() {
        return "[" + occupantColor + occupant + "]";
    }

}
