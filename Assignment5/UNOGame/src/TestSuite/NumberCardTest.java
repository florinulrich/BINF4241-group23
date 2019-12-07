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

    @Test
    void getNumber() {
        assertNotNull(testCard.getNumber());
        assertEquals(CardNumber.FOUR, testCard.getNumber());
    }

    @Test
    void getColor() {
        assertNotNull(testCard.getColor());
        assertEquals(CardColor.RED, testCard.getColor());
    }

    @Test
    void hasActions() {
        assertFalse(testCard.hasActions());
    }
}