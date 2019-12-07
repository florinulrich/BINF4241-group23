package TestSuite;

import Cards.AbstractClasses.ActionCard;
import Cards.ActionCards.*;
import Enumerations.CardColor;
import Game.DiscardPile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests Action cards method that are not exclusively getters or setters
 * If method only queries another method, it is assumed that the method works.
 * Since this is all the concrete classes do, they are not tested seperately
 * Therefore only the called method is tested
 */
class ActionCardTest {

    ActionCard takeTwo, reverse, skipCard, wildCard, takeFour;
    ArrayList<ActionCard> cards;

    @BeforeEach
    void setUp() {
        takeTwo = new TakeTwoCard(CardColor.BLUE);
        reverse = new ReverseCard(CardColor.BLUE);
        skipCard = new SkipCard(CardColor.BLUE);
        wildCard = new WildCard();
        takeFour = new WildTakeFourCard();

        cards = new ArrayList<>();
        cards.add(takeTwo);
        cards.add(reverse);
        cards.add(skipCard);
        cards.add(wildCard);
        cards.add(takeFour);
    }

    @AfterEach
    void tearDown() {
        takeTwo = null;
        reverse = null;
        skipCard = null;
        wildCard = null;
        takeFour = null;
        cards = null;
    }


    /**
     * Tests if the cards are of the right color
     */
    @Test
    void getColor() {

        for (int i = 0; i < 3; i++) {
            ActionCard testCard = cards.get(i);
            assertNotNull(testCard.getColor());
            assertEquals(CardColor.BLUE, testCard.getColor());
        }
        assertNotNull(takeFour.getColor());
        assertEquals(CardColor.BLACK, takeFour.getColor());
        assertNotNull(wildCard.getColor());
        assertEquals(CardColor.BLACK, wildCard.getColor());
    }

    /**
     * Tests if all action cards have an action
     */
    @Test
    void hasActions() {
        for (ActionCard testCard: cards) {
            assertTrue(testCard.hasActions());
        }
    }
}