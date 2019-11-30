public class Player{

    //Variables
    private ISquare currentSquare;
    private String name;

    public Player(String playerName, ISquare startingSquare) {
        this.name = playerName;
        this.currentSquare = startingSquare;
        currentSquare.enter(this);

        //TODO; Document the bugfix! After player is created on a square, it enters
    }

    void moveFwd(int numberOfSquares){

        currentSquare.leave(this);
        ISquare newSquare = currentSquare.moveAndLand(numberOfSquares);
        newSquare.enter(this);
    }

    ISquare square() {

        return currentSquare;
    }

    String getName() {
        return name;
    }

    void setCurrentSquare(ISquare square) {
        currentSquare = square;
    }

}
