import java.util.ArrayList;

public class Game {

    //Variables
    private PlayerQueue players;
    private ArrayList<ISquare> squares;

    //Initializer
    public Game(int numberOfSquares) {

        for (int i = 0; i < numberOfSquares; i++) {
            squares.add(new Square(this));
        }

        //Set up last square
        squares.get((squares.size()-1)).setAsLastSquare();
    }

    //Methods
    protected void movePlayer(int numberOfSquares){
    // moves player a number of squares on the board
       Player currentPlayer = players.remove();
       currentPlayer.moveFwd(numberOfSquares);
       players.add(currentPlayer);
       ISquare landedSquare = currentPlayer.square();
       if (landedSquare.isLastSquare()) {
           this.gameOver();
       }
    }

    protected ISquare findSquare(int squareNumber){
    // returns landing Square (object)

    }

    public ISquare firstSquare() {
        return squares.get(0);
    }

    private void gameOver() {
        //In some way finishes game
    }

}
