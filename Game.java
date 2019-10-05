import java.util.ArrayList;


public class Game {

    //Variables
    PlayerQueue players = new PlayerQueue();
    private ArrayList<ISquare> squares = new ArrayList<>();
    private boolean gameOver = false;
    private Player currentPlayer;

    //Initializer
    Game(int numberOfSquares) {

        for (int i = 0; i < numberOfSquares; i++) {
            squares.add(new Square(this, i));
        }

        //Set up last square
        squares.get((squares.size()-1)).setAsLastSquare();
    }

    //Methods
    void movePlayer(int numberOfSquares){
    // moves player a number of squares on the board
        currentPlayer = players.remove();
       currentPlayer.moveFwd(numberOfSquares);
       players.add(currentPlayer);
       ISquare landedSquare = currentPlayer.square();
       if (landedSquare.isLastSquare()) {
           gameOver = true;
       }
    }

    ISquare findSquare(int numberOfSteps, int squarePosition) {

        int newPosition = squarePosition + numberOfSteps;

        if (newPosition > squares.size()-1) {
            int stepsBack = newPosition % (squares.size()-1);
            newPosition = squares.size()-1-stepsBack;
        }

        return squares.get(newPosition);
    }

    ISquare firstSquare() {
        return squares.get(0);
    }

    boolean gameOver() {
        return this.gameOver;
    }

    void printSquares(int numberToMove) {

        String outputLine = "";

        for (ISquare square: squares) {

            String squareOutput = square.printSquareString();

            outputLine = outputLine + squareOutput;
        }
        String DiceRoll = "";
        if (numberToMove == 0)
        {
            DiceRoll = "Initial state: \t\t\t";
        } else if (numberToMove == 7) {
            DiceRoll = "Final state: \t\t\t";
        } else {
            DiceRoll = players.peek().getName() + " \trolls: " + numberToMove + "\t\t";
        }
        System.out.println(DiceRoll + outputLine);
    }

    void addNewPlayer(Player newPlayer) {
        squares.get(0).addPlayer(newPlayer);
        players.add(newPlayer);
    }

    Player getLastSquaresPlayer() {
        return squares.get(squares.size()-1).getPlayerOnSquare().get(0);
    }

    public ArrayList<ISquare> getSquares() {
        return squares;
    }

    public void setSquares(ArrayList<ISquare> squares) {
        this.squares = squares;
    }
}
