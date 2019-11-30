import org.junit.Test;
import static org.junit.Assert.*;

public class DiceTest {

    /**
     * Test iteratively for correct dice values. It gives a high probability that it works reliably
     */
   @Test public void testRoll(){
       for (int i = 0; i < 10; i++) {
           int roll = Dice.roll();
           assertTrue("Dice doesn't roll in correct range", roll < 7 && roll > 0);
       }
   }
}
