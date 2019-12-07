package TestSuite;

import Cards.NumberCard;
import Enumerations.CardColor;
import Enumerations.CardNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberCardTest {

    NumberCard testCard;

    @BeforeEach
    void setUp() {
        testCard = new NumberCard(CardColor.RED, CardNumber.FOUR);
    }

    @AfterEach
    void tearDown() {
        testCard = null;
    }

    /**
     * the getNumber method returns the number of the card
     */
    @Test
    void getNumber() {
        assertNotNull(testCard.getNumber());
        assertEquals(CardNumber.FOUR, testCard.getNumber());
    }

    /**
     * the getColor method returns the color of the card
     */
    @Test
    void getColor() {
        assertNotNull(testCard.getColor());
        assertEquals(CardColor.RED, testCard.getColor());
    }

    /**
     * Numbercards never have an action
     */
    @Test
    void hasActions() {
        assertFalse(testCard.hasActions());
    }
}