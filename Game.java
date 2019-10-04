import java.util.ArrayList;

public class Game {

    //Variables
    private PlayerQueue players = new PlayerQueue();
    private ArrayList<ISquare> squares = new ArrayList<>();

    //Initializer
    public Game(int numberOfSquares) {

        for (int i = 0; i < numberOfSquares; i++) {
            squares.add(new Square(this, i));
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

    ISquare findSquare(int numberOfSteps, int squarePosition){

        return squares.get(squarePosition+numberOfSteps);
    }

    ISquare firstSquare() {
        return squares.get(0);
    }

    private void gameOver() {
        //In some way finishes game
    }

}
