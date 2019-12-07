package TestSuite;

import Game.Player;
import Game.PlayerQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerQueueTest {

    PlayerQueue testQueue;

    @BeforeEach
    void setUp() {
        testQueue = new PlayerQueue();
        testQueue.add(new Player());
    }

    @AfterEach
    void tearDown() {
    }

    /**
     *
     */
    @Test
    void skipOne() {

    }

    @Test
    void reverse() {
    }

    @Test
    void next() {
    }

    @Test
    void setDealer() {

    }

    @Test
    void isEmpty() {
        assertFalse(testQueue.isEmpty());
        testQueue.next();
        assertTrue(testQueue.isEmpty());
    }

    @Test
    void add() {
        testQueue = new PlayerQueue();
        Player testPlayer = new Player();
        testQueue.add(testPlayer);
        assertNotNull(testQueue.peek());
        assertEquals(testPlayer, testQueue.next());
    }
}