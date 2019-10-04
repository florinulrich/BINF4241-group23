public class Game {

    //Variables
    private PlayerQueue players;
    private ISquare[] squares;

    //Initializer
    public Game(int numberOfSquares) {

        squares =
    }

    //Methods
    protected void movePlayer(int numberOfSquares){
    // moves player a number of squares on the board
       Player currentPlayer = players.remove();
       currentPlayer.moveFwd(numberOfSquares);
       players.add(currentPlayer);
       ISquare landedSquare = currentPlayer.square();
       if (landedSquare.isLastSquare()) {
           return; // Game stops, shows winning player
       }
    }

    protected ISquare findSquare(int squareNumber){
    // returns landing Square (object)

    }

    public ISquare firstSquare() {
        return squares[0];
    }

}
