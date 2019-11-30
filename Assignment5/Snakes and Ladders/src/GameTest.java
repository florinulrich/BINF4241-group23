
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    static Game testGame;

    @Before  static void setUp() {
        testGame = new Game(10);
    }

    @Test static void testMovePlayer() {


    }

    @Test static void testFindSquare() {


    }

    @Test static void testGameOver() {

        assertTrue("GameOver returns false value", !testGame.gameOver());

        testGame.movePlayer(9);

        assertTrue("Player reached last square but game is not game Over!", testGame.gameOver());

    }

}
