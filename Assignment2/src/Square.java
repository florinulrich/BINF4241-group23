public interface Square {

    public boolean isOccupied();

    public Piece getOccupant();

    public void setOccupant(Piece newOccupant);

    //Coordinate must never be changed
    public Coordinate getCoordinate();

}
