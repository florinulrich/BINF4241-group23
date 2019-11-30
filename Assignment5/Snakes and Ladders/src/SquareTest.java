import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class SquareTest {

    ArrayList<ISquare> testSquares;
    Game parentGame;
    Square firstSquare; //Is always of type Square

    @Before
    public void setUp() {
        parentGame = new Game(10);
        testSquares = parentGame.getSquares();
        firstSquare = (Square) testSquares.get(0);
        parentGame.addNewPlayer(new Player("Player 1", testSquares.get(0)));
        parentGame.addNewPlayer(new Player("Player 2", testSquares.get(0)));


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

        Square middleSquare;

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

        //Set a player on the square
        if (i > 2) {
            Player player3 = new Player("Player 3", middleSquare);
            parentGame.addNewPlayer(player3);
            middleSquare.leave(player3);

        } else {
            middleSquare = (Square) testSquares.get(2);
            middleSquare.leave(middleSquare.getPlayerOnSquare().get(0));
        }
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

    @Test public void testIsOccupied() {

        assertTrue("First Square is occupied at beginning of the game");firstSquare.isOccupied()

    }


    @Test public void testEnter() {




    }

    @Test public void testIsLastSquare() {

    }

    @Test public void testSetAsLastSquare() {

    }

    @Test public void testGetPosition() {

    }

    @Test public void testGetPlayerOnSquare() {

    }

    @Test public void testAddPlayer() {

    }

    @Test public void testPrintSquareString() {

    }

    @After public void tearDown() {
        //Tear Down
    }
}
