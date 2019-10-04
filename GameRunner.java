import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameRunner{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        //ask for the number of players:
        System.out.print("How many players?: ");
        int number_of_players = input.nextInt(); // must be between 2 and 4

        //ask for the names of the players:
        System.out.print("State the names of the players: \n");
        List playerNames = new LinkedList();
        for (int i = 1; i <= number_of_players; i++){
            System.out.print("Player " + i + "\n");
            String name = input.next();
            playerNames.add(name);
        }

        //ask for size of board:
        System.out.print("How large is the game board?: ");
        int board_size= input.nextInt();
    }

}
