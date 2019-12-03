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

       //TODO: what happens for 1, 2, 3, 4, 5, or 6
   }
}
