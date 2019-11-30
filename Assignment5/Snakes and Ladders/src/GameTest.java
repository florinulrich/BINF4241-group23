
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    Game testGame;

    @Before public void setUp() {
        testGame = new Game(10);
    }

    @Test public void testMovePlayer() {


    }

    @Test public void testFindSquare() {


    }

    @Test public void testGameOver() {

        assertTrue("GameOver returns false value", !testGame.gameOver());

        testGame.movePlayer(9);

        assertTrue("Player reached last square but game is not game Over!", testGame.gameOver());

    }

}
