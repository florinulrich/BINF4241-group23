package TestSuite;

import Game.Player;
import Game.PlayerQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerQueueTest {

    PlayerQueue testQueue;
    Player testPlayer1;

    @BeforeEach
    void setUp() {
        testQueue = new PlayerQueue();
        testPlayer1 = new Player();
        testQueue.add(new Player());
    }

    @AfterEach
    void tearDown() {
        testQueue = null;
        testPlayer1 = null;
    }

    /**
     * If the first Player is skipped it is the second players term
     */
    @Test
    void skipOne() {
        Player firstPlayer = testQueue.peek();
        Player secondPlayer = new Player();
        Player thirdPlayer = new Player();
        testQueue.add(secondPlayer);
        testQueue.add(thirdPlayer);
        assertEquals(firstPlayer, testQueue.peek());
        testQueue.skipOne();
        assertEquals(secondPlayer, testQueue.peek());
    }

    /**
     * The direction of the queue is changed
     */
    @Test
    void reverse() {
        Player secondPlayer = new Player();
        testQueue.add(secondPlayer);
        testQueue.reverse();
        assertEquals(secondPlayer, testQueue.peek());
        testQueue.reverse();
        assertEquals(testPlayer1, testQueue.peek());
    }

    /**
     * The player at the top of the line will be returned, null if empty
     */
    @Test
    void next() {
        testQueue.add(new Player());
        assertEquals(testPlayer1, testQueue.next());
        assertNotNull(testQueue.next());
        assertNull(testQueue.next());
    }

    /**
     * A given player is set as the dealer for the round
     */
    @Test
    void setDealer() {
        assertFalse(testQueue.peek().isDealer());
        testQueue.setDealer(testQueue.peek());
        assertTrue(testQueue.peek().isDealer());
    }

    /**
     * If the queue is empty, iEmpty should return false, else true
     */
    @Test
    void isEmpty() {
        assertFalse(testQueue.isEmpty());
        testQueue.next();
        assertTrue(testQueue.isEmpty());
    }

    /**
     * New players are added at the back of the queue
     */
    @Test
    void add() {
        testQueue = new PlayerQueue();
        Player testPlayer = new Player();
        testQueue.add(testPlayer);
        assertNotNull(testQueue.peek());
        assertEquals(testPlayer, testQueue.next());
        testQueue.add(new Player());
        assertEquals(testPlayer, testQueue.next());
    }
}