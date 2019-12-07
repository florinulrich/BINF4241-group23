package TestSuite;

import Cards.Interfaces.ICard;
import Enumerations.CardColor;
import Game.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player testPlayer;

    @BeforeEach
    void setUp() {
        testPlayer = new Player();
    }

    @AfterEach
    void tearDown() {
        testPlayer = null;
    }

    /**
     * your turn must return a Icard or null
     */
    @Test
    void yourTurn() {

        assertTrue(testPlayer.yourTurn() == null || testPlayer.yourTurn() instanceof ICard);

    }

    /**
     * Check if the player forgot to say uno, if so he gets more cards,
     * else the challenging player gets more
     */
    @Test
    void challengeUNO() {

        Player forgotUNO = new Player();
        forgotUNO.forgotUno = true;
        int forgotHandSize = forgotUNO.hand.size();
        testPlayer.challengeUNO(forgotUNO);
        assertNotEquals(forgotHandSize, forgotUNO.hand.size());
        forgotUNO.forgotUno = true;
        testPlayer.challengeUNO(forgotUNO);
        assertEquals(forgotHandSize, forgotUNO.hand.size());
    }

    /**
     * If wildcard is illegal, the accused takes cards, else the accuser
     */
    @Test
    void challengeWildCard() {
        Player accused = new Player();
        int accusedHandSize = accused.hand.size();
        accused.wildCardIllegal = true;
        testPlayer.challengeWildCard(accused);
        assertNotEquals(accusedHandSize, accused.hand.size());
        int testPlayerHandSize = testPlayer.hand.size();
        accused.wildCardIllegal = false;
        testPlayer.challengeWildCard(accused);
        assertNotEquals(testPlayerHandSize, testPlayer.hand.size());
    }

    /**
     * Tests if the player hand is indeed larger after taking cards is called
     */
    @Test
    void takeCards() {
        int size = testPlayer.hand.size();
        testPlayer.takeCards(5);
        assertEquals((size+5), testPlayer.hand.size());
    }

    /**
     * Can be any Color, excluding Black and Null
     */
    @Test
    void chooseColor() {
        CardColor color = testPlayer.chooseColor();
        assertNotNull(color);
        assertNotEquals(CardColor.BLACK, color);
    }
}