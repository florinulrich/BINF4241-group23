import java.util.Scanner;

public class startGame {
    //Klasse, die aufgerufen wird, wenn das Spiel gestartet wird und User Input fragt
//oder braucht das keine eigene Klasse?

    public class start_Game{

        public void main(String[] args){

            Scanner input = new Scanner(System.in);

            //ask for the number of players:
            System.out.print("How many players?: ");
            int number_of_players = input.nextInt();

            //hier müssten man noch prüfen, ob die Zahl zwischen zwei und vier liegt und ev. eine Fehlermeldung geben!

            //ask for size of board:
            System.out.print("How large is the game board?: ");
            int board_size = input.nextInt();
        }

    }
}
