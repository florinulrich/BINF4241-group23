
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    Game testGame;

    @Before public void setUp() {
        testGame = new Game(10);
        ISquare startSquare = testGame.firstSquare();
        testGame.addNewPlayer(new Player("Player1", startSquare));
        testGame.addNewPlayer(new Player("Player2", startSquare));
    }

    @Test public void testMovePlayer() {


    }

    @Test public void testFindSquare() {


    }

    /**
     * At the beginning gameOver == false
     * After a player reaches the last square gameOver == true
     */
    @Test public void testGameOver() {

        assertTrue("GameOver returns false value", !testGame.gameOver());

        testGame.movePlayer(9);

        assertTrue("Player reached last square but game is not game Over!", testGame.gameOver());

    }

}
