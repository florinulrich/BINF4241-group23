public class Game {

    PlayerQueue players;

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

    protected void findSquare(int squareNumber){
    // returns landing Square (object)

    }

}
