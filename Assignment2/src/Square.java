public interface Square {

    public boolean isOccupied();

    // Is move valid regarding *only* the properties of the piece
    public boolean technicalValid(int coordinate);

    // Is move valid regarding the current setup of the board
    public boolean practicalValid(int coordinate);

    public void leave();

    public void enter(Object Piece);


}
