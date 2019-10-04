public class Player{

    //Variables
    private ISquare currentSquare;
    private String name;

    public Player(String playerName, ISquare startingSquare) {
        this.name = playerName;
        this.currentSquare = startingSquare;
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
