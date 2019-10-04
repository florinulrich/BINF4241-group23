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
    }

    private static void getSetupInputs() {
        Scanner input = new Scanner(System.in);

        //ask for the number of players:
        System.out.print("How many players?: ");
        numberOfPlayers = input.nextInt(); // must be between 2 and 4

        //ask for the names of the players:
        System.out.print("State the names of the players: \n");
        playerNames = new LinkedList();
        for (int i = 1; i <= numberOfPlayers; i++){
            System.out.print("Player " + i + "\n");
            String name = input.next();
            playerNames.add(name);
        }

        //ask for size of board:
        System.out.print("How large is the game board?: ");
        boardSize = input.nextInt();
    }

}
