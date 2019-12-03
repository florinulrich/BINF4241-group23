
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.opentest4j.AssertionFailedError;

import static org.junit.Assert.*;

public class PlayerTest {

    private Game parentGame;
    private Player testPlayer1;
    private Player testPlayer2;
    private Square firstSquare;
    private Square middleSquare;
    private int stepsToMiddleSquare;

    @Before public void setUp() {
        parentGame = new Game(10);
        firstSquare = (Square) parentGame.getSquares().get(0);
        testPlayer1 = new Player("TestPlayer1", firstSquare);
        testPlayer2 = new Player("TestPlayer2", firstSquare);

        int i = 2;
        while (true) {
            try {
                middleSquare = (Square) parentGame.getSquares().get(i);
                break;
            } catch (Exception e) {
                i++;
            }
        }

        stepsToMiddleSquare = i;

    }

    /**
     * This method checks the moveFwd method.
     * The player leaves the square, asks it for a new one and enters the new one
     */
    @Test public void testMoveFwd() {

        assertEquals("Player should be on startSquare at the beginning", firstSquare, testPlayer1.square());
        testPlayer1.moveFwd(stepsToMiddleSquare);
        assertEquals("Player should now be on middle square", middleSquare, testPlayer1.square());

    }

    /**
     * returns the square the player is currently on. this is never null!
     */
    @Test public void testSquare() {

        assertNotNull(testPlayer1.square());
        assertEquals(firstSquare, testPlayer1.square());
        assertEquals(firstSquare, testPlayer2.square());
    }

    /**
     * The method get name returns the name of the player as a string.
     */
    @Test public void testGetName() {

        assertNotNull(testPlayer1.getName());
        assertEquals("TestPlayer1", testPlayer1.getName());

    }

    /**
     * The method setCurrentSquare sets the square of the Player
     * It should not be possible to set it as null
     */
    @Test public void testSetCurrentSquare() {

        boolean exceptionCaught = false;

        try {
            testPlayer2.setCurrentSquare(null);
        } catch (Exception e) {
            exceptionCaught = true;
        }

        assertTrue("Exception was not thrown for null as Parameter", exceptionCaught);


        testPlayer1.setCurrentSquare(middleSquare);
        testPlayer2.setCurrentSquare(middleSquare);

        assertEquals(middleSquare, testPlayer1.square());
        assertEquals(middleSquare,testPlayer2.square());

    }

    @After public void tearDown() {
        parentGame = null;
        testPlayer1 = null;
        testPlayer2 = null;
        firstSquare = null;
        middleSquare = null;
        stepsToMiddleSquare = 0;

    }
}
