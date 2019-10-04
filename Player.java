public class Player{

    //Variables
    ISquare currentSquare;

    protected void moveFwd(int numberOfSquares){

        currentSquare.leave(this);
        ISquare newSquare = currentSquare.moveAndLand(numberOfSquares);
        newSquare.enter(this);
    }

    protected ISquare square() {

        return currentSquare;
    }


}
