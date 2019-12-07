package Game;

import java.util.ArrayList;

/**
 * This is the class that runs the game
 */
public class Main {

    public static ArrayList<Player> players;
    public static DrawPile drawPile;
    public static DiscardPile discardPile;
    public static boolean gameOver;


    /**
     * Run the game
     * This method stops, when the game is over, that is if a player reaches 500
     * calls on the discard pile to get the next card
     */
    public static void run() {

    }

    /**
     * sets the scene for a new beginning
     */
    static void setUp() {

    }

    public static void main(String[] args) {
        setUp();
        run();
    }
}
