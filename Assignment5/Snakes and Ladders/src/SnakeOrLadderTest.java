import org.junit.Test;
import static org.junit.Assert.*;

public class SnakeOrLadderTest {

    @Test
    public void SnakeOrLadder(){

        Game testGame = new Game(10);
        boolean throwsException = false;
        try {
            new SnakeOrLadder(testGame, 1, SnakeOrLadder.SquareType.LADDER, null);
        }
        catch (Exception e){
            throwsException = true;
        }

        assertTrue("target square must not be null", throwsException);
    }
}
