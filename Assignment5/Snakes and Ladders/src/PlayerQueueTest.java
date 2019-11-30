
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerQueueTest {

    PlayerQueue testQueue;
    Player testPlayer1;
    Player testPlayer2;

    @Before public void setUp() {

        Game parentGame = new Game(10);
        Square startSquare = (Square) parentGame.firstSquare();

        testQueue = new PlayerQueue();
        testPlayer1 = new Player("TestPlayer1", startSquare);
        testPlayer2 = new Player("TestPlayer2", startSquare);


    }

    /**
     * This method tests the remove method. After adding an element to the queue and removing it, the queue is empty again
     * it removes the element that was inserted first
     */
    @Test public void testRemove() {

        testQueue.add(testPlayer1);
        assertNotNull("There is no Player to remove in the next Test step", testQueue.peek());
        testQueue.remove();
        assertNull("The Queue should be empty",testQueue.peek());

        testQueue.add(testPlayer1);
        testQueue.add(testPlayer2);
        assertEquals(testPlayer1, testQueue.remove());

    }

    /**
     * After adding an element to the empty queue, peek() should be able to return an element that is not null;
     */
    @Test public void testAdd() {

        testQueue.add(testPlayer1);
        assertSame("Adding to the queue failed", testQueue.peek(), testPlayer1);

    }

    /**
     * Peeking into an empty list returns null, a non empty list returns the element to be removed next
     */
    @Test public void testPeek() {

        assertNull(testQueue.peek());
        testQueue.add(testPlayer1);
        assertEquals(testPlayer1, testQueue.peek());
        testQueue.add(testPlayer2);
        assertEquals(testPlayer1, testQueue.peek());

    }

    @After public void tearDown() {

        testQueue = null;
        testPlayer1 = null;
        testPlayer2 = null;
    }
}
