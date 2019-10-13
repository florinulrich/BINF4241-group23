package Interfaces;

public interface ISquare {

    public boolean isOccupied();

    public IPiece getOccupant();

    public void setOccupant(IPiece newOccupant);

    //Coordinate must never be changed
    public Coordinate getCoordinate();

}
