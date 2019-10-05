import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameRunner{

    static int numberOfPlayers;
    static List playerNames;
    static int boardSize;


    public static void main(String[] args){

        getSetupInputs();
        //System.out.println("Players: " + numberOfPlayers + " Names: " + playerNames + " BoardSize: " + boardSize);
        setUpGame();
    }

    private static void getSetupInputs() {
        Scanner input = new Scanner(System.in);
        askForPlayerNumber(input);


        //ask for the names of the players:
        System.out.print("Player names: \n");
        playerNames = new LinkedList();
        for (int i = 1; i <= numberOfPlayers; i++){
            System.out.print("Player " + i + " >>> ");
            String name = input.next();
            playerNames.add(name);
        }

        //ask for size of board:
        System.out.print("Board size >>> ");
        boardSize = input.nextInt();
    }

    private static void askForPlayerNumber(Scanner input) {
        //ask for the number of players:
        System.out.print("How many players >>> ");
        numberOfPlayers = input.nextInt();
        // must be between 2 and 4
        if ((numberOfPlayers > 4) || (numberOfPlayers < 2)) {
            askForPlayerNumber(input);
        }
    }

    private static void setUpGame() {
        Game gameBoard = new Game(boardSize);

        for (Object playerName: playerNames) {

            String playerNameString = (String) playerName;

            Player newPlayer = new Player(playerNameString, gameBoard.firstSquare());
            gameBoard.addNewPlayer(newPlayer);

        }

        //Print initial State
        gameBoard.printSquares(0);

        while (!gameBoard.gameOver()) {

            int numberToMove = Dice.roll();

            gameBoard.movePlayer(numberToMove);
            gameBoard.printSquares(numberToMove);
        }

        //Print final State and winner
        String Winner = "Default";
        System.out.println(Winner +" wins!");
    }

}
