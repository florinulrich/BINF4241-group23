package TestSuite;

import Cards.AbstractClasses.ActionCard;
import Cards.ActionCards.TakeTwoCard;
import Enumerations.CardColor;
import Game.DiscardPile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionCardTest {

    ActionCard testCard;

    @BeforeEach
    void setUp() {
        testCard = new ActionCard(CardColor.BLUE);
    }

    @AfterEach
    void tearDown() {
        testCard = null;
    }

    @Test
    void executeAction() {
        DiscardPile testPile = new DiscardPile();
        testCard.executeAction(testPile);

    }

    @Test
    void getColor() {
        assertNotNull(testCard.getColor());
        assertEquals(CardColor.BLUE, testCard.getColor());
    }

    @Test
    void hasActions() {
        assertFalse(testCard.hasActions());
        ActionCard decoratedCard = new TakeTwoCard();
        assertTrue(decoratedCard.hasActions());
    }
}