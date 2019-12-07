package TestSuite;

import Cards.AbstractClasses.ActionCard;
import Cards.ActionCards.TakeTwoCard;
import Cards.ActionCards.WildCard;
import Cards.Interfaces.ICard;
import Cards.NumberCard;
import Enumerations.CardColor;
import Enumerations.CardNumber;
import Game.DiscardPile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests DiscardPile method that are not exclusively getters or setters
 * If method only queries another method, it is assumed that the method works.
 * Therefore only the called method is tested
 */
class DiscardPileTest {

    DiscardPile testPile;

    @BeforeEach
    void setUp() {
        testPile = new DiscardPile();
    }

    @AfterEach
    void tearDown() {
        testPile = null;
    }

    /**
     * Testing the islegalnextcard method with true and false examples
     */
    @Test
    void isLegalNextCard() {
        testPile.setTopCard(new NumberCard(CardColor.BLUE, CardNumber.NINE));

        assertTrue(testPile.isLegalNextCard(new NumberCard(CardColor.BLUE, CardNumber.ONE)));
        assertTrue(testPile.isLegalNextCard(new NumberCard(CardColor.RED, CardNumber.NINE)));
        assertTrue(testPile.isLegalNextCard(new WildCard()));
        assertTrue(testPile.isLegalNextCard(new TakeTwoCard(CardColor.BLUE)));
        assertTrue(testPile.isLegalNextCard(null));

        assertFalse(testPile.isLegalNextCard(new NumberCard(CardColor.RED, CardNumber.ONE)));
        assertFalse(testPile.isLegalNextCard(new TakeTwoCard(CardColor.RED)));

    }

    /**
     * Test the used cards array that holds all added cards except the top card
     */
    @Test
    void getUsedCards() {
        testPile.setTopCard(new NumberCard(CardColor.BLUE, CardNumber.NINE));
        assertTrue(testPile.getUsedCards().isEmpty());
        testPile.setTopCard(new NumberCard(CardColor.BLUE, CardNumber.ONE));
        assertEquals(1, testPile.getUsedCards().size());
        NumberCard expectedCard = (NumberCard) testPile.getUsedCards().get(0);
        assertEquals(CardColor.BLUE, expectedCard.getColor());
        assertEquals(CardNumber.NINE, expectedCard.getNumber());
    }
}