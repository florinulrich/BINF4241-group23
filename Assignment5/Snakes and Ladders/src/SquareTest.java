import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

import java.util.ArrayList;

public class SquareTest {

    ArrayList<ISquare> testSquares;
    Game parentGame;
    Square firstSquare; //Is always of type Square
    Square middleSquare;
    Player testPlayer;

    @Before
    public void setUp() {
        parentGame = new Game(10);
        testSquares = parentGame.getSquares();
        firstSquare = (Square) testSquares.get(0);
        testPlayer = new Player("Player 1", testSquares.get(0));
        parentGame.addNewPlayer(testPlayer);
        parentGame.addNewPlayer(new Player("Player 2", testSquares.get(0)));

        //Make sure the middle square is not a snake or ladder
        int i = 2;
        while (true) {
            try {
                middleSquare = (Square) testSquares.get(i);
                break;
            } catch (Exception e) {
                i +=1;
            }
        }


    }

    /**
     * the method Leave sets the state of the Square to not occupied.
     * Also the player is removed from the squares occupant array.
     * This is tested for the first square and a middle square that is neither snake nor ladder
     */
    @Test public void testLeave() {

        ISquare firstSquare = testSquares.get(0);

        assertTrue("First Square should not be empty at beginning of the Game",
                !firstSquare.getPlayerOnSquare().isEmpty() && !(firstSquare.getPlayerOnSquare() == null));

        parentGame.movePlayer(1); //Move first player
        parentGame.movePlayer(2); //Move second player

        assertTrue("First square should be empty!", firstSquare.getPlayerOnSquare().isEmpty());

        //Set a player on the square
        if (!middleSquare.isOccupied()) {
            Player player3 = new Player("Player 3", middleSquare);
            parentGame.addNewPlayer(player3);
        }
            middleSquare.leave(middleSquare.getPlayerOnSquare().get(0));

        assertTrue("Player did not set the isOccupied state to false", !middleSquare.isOccupied());

    }

    /**
     * The method move and land returns the square to go to next.
     * This is either the square itself or the first if it is occupied but can never be null
     */
    @Test public void testMoveAndLand() {

        assertNotNull(firstSquare.moveAndLand(1)); //Smallest step
        assertNotNull(firstSquare.moveAndLand(6)); //Largest step

    }

    /**
     * The method landHereOrGoHome returns a square and never null.
     * The method returns itself or, if occupied, the first square.
     * The first square always returns itself.
     * The last square returns itself, because it it were occupied the game would be over.
     */
    @Test public void testLandHereOrGoHome() {

        assertNotNull(firstSquare.landHereOrGoHome());
        assertEquals(firstSquare, firstSquare.landHereOrGoHome()); //First square always returns itself
        assertEquals(testSquares.get(testSquares.size()-1).landHereOrGoHome(),
                testSquares.get(testSquares.size()-1)); //Last square can always be landed on

    }

    /**
     * The method isOccupied returns a boolean value, indicating if a player is on a square.
     * At the beginning of the game, the first square is always occupied, whereas the last square is not.
     */
    @Test public void testIsOccupied() {

        assertTrue("First Square is occupied at beginning of the game", firstSquare.isOccupied());

        Square lastSquare = (Square) testSquares.get(testSquares.size()-1);
        assertFalse("Last Square should not be occupied", lastSquare.isOccupied());
    }

    /**
     * This method adds a player on a square and sets the status of the square (i.e. occupied)
     */
    @Test public void testEnter() {

        assertTrue("the middle square should not be occupied before a player enters", !middleSquare.isOccupied());
        middleSquare.enter(testPlayer);
        assertTrue("after a player enters the square, it should be occupied",middleSquare.isOccupied());

    }

    /**
     * This method checks if a square is the last square of the board.
     */
    @Test public void testIsLastSquare() {

        assertTrue(testSquares.get(testSquares.size()-1).isLastSquare());
        assertFalse(middleSquare.isLastSquare());
        assertFalse(firstSquare.isLastSquare());

    }

    /**
     * This method sets a square as the last square of the board. IsLastSquare should
     * therefore return true.
     */
    @Test public void testSetAsLastSquare() {

        middleSquare.setAsLastSquare();
        assertTrue(middleSquare.isLastSquare());
    }

    /**
     * This method gets the position of a square,
     * i.e. the integer indicating the index in the corresponding square array in the board
     */
    @Test public void testGetPosition() {

        assertEquals(0, firstSquare.getPosition());
        assertEquals(testSquares.size() - 1, testSquares.get(testSquares.size() - 1).getPosition());

    }

    /**
     * This method returns an array of players.
     * It should never return null.
     */
    @Test public void testGetPlayerOnSquare() {

        assertNotNull(firstSquare.getPlayerOnSquare());
        assertNotNull(middleSquare.getPlayerOnSquare());
        assertTrue(middleSquare.getPlayerOnSquare().isEmpty());
    }

    /**
     * This method adds a player to a square, therefore the player on
     * square array must be initialized already.
     */
    @Test public void testAddPlayer() {

        assertNotNull(middleSquare.getPlayerOnSquare());
        middleSquare.addPlayer(testPlayer);
        assertFalse(middleSquare.getPlayerOnSquare().isEmpty());

    }

    /**
     * This
     */
    @Test public void testPrintSquareString() {

        assertEquals('[', middleSquare.printSquareString().charAt(0));
        assertEquals('1', firstSquare.printSquareString().charAt(1));

    }

    @After public void tearDown() {

        parentGame = null;
        testSquares = null;
        firstSquare = null;
        testPlayer = null;
        middleSquare = null;

    }
}
