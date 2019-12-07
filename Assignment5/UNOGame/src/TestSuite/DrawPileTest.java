package TestSuite;

import Cards.Interfaces.ICard;
import Cards.NumberCard;
import Enumerations.CardColor;
import Enumerations.CardNumber;
import Game.DiscardPile;
import Game.DrawPile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DrawPileTest {

    DrawPile testPile;

    @BeforeEach
    void setUp() {
        testPile = new DrawPile();
    }

    @AfterEach
    void tearDown() {
        testPile = null;
    }

    /**
     * Tests the top card before and after shuffeling
     * The cards should not be the same anymore
     */
    @Test
    void shuffle() {

        for (int i = 0; i < 10; i++) {
            ICard testCard = testPile.peek();
            testPile.shuffle();
            assertNotEquals(testCard, testPile.draw());
        }

    }

    /**
     * The pile should not return null and should be not shuffle in between
     */
    @Test
    void draw() {
        assertNotNull(testPile.draw());
        assertEquals(testPile.peek(), testPile.draw());
    }

    /**
     * the cards in the cards array must be the ones the discard pile gives back
     */
    @Test
    void getPlayedCardsBack() {
        DiscardPile testDiscardPile = new DiscardPile();
        testDiscardPile.setTopCard(new NumberCard(CardColor.BLUE, CardNumber.NINE));
        testDiscardPile.setTopCard(new NumberCard(CardColor.RED, CardNumber.ONE));

        testPile.cards = new ArrayList<>();
        testPile.getPlayedCardsBack(testDiscardPile);
        assertEquals(1, testPile.cards.size());
        assertEquals(testPile.cards.get(0).getColor(), CardColor.BLUE);
    }
}