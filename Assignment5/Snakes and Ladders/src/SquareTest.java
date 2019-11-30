import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class SquareTest {

    ArrayList<ISquare> testSquares;
    Game parentGame;

    @Before public void setUp() {
        parentGame = new Game(10);
        testSquares = parentGame.getSquares();
        parentGame.addNewPlayer(new Player("Player 1", testSquares.get(0)));
        parentGame.addNewPlayer(new Player("Player 2", testSquares.get(0)));

    }

    @Test public void testLeave() {

        ISquare firstSquare = testSquares.get(0);

        assertTrue("First Square should not be empty at beginning of the Game",
                !firstSquare.getPlayerOnSquare().isEmpty() && !(firstSquare.getPlayerOnSquare() == null));
        assertTrue("Is occupied should be true", firstSquare.);

        parentGame.movePlayer(1); //Move first player
        parentGame.movePlayer(2); //Move second player

        assertTrue("First square should be empty!", firstSquare.getPlayerOnSquare().isEmpty());

        ISquare middleSquare
    }

    @Test public void testMoveAndLand() {

    }

    @Test public void testLandHereOrGoHome() {

    }

    @Test public void testIsOccupied() {

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
