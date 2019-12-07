package Game;

import Cards.Interfaces.ICard;

import java.util.ArrayList;

/**
 * The class Deck holds all remaining cards and can be used to draw cards
 */
public class DrawPile {

    public ArrayList<ICard> cards;

    /**
     * shuffles the draw pile
     */
    public void shuffle() {

    }

    /**
     * @return the top card of the pile
     */
    public ICard draw() {
        return null;
    }

    /**
     * @param discardPile a discard pile the draw pile gets is cards back from
     */
     public void getPlayedCardsBack(DiscardPile discardPile) {

    }

    /**
     * @return card at the top of the deck without removing it
     * for testing only
     */
    public ICard peek() {

        return null;
    }


}
