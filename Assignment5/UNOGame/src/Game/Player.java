package Game;

import Cards.Interfaces.ICard;

import java.util.ArrayList;

/**
 * The Player has cards in its "hand" and asks for action to take from the real life counterpart
 */
public class Player {

    public ArrayList<ICard> hand;
    public int score;
    DiscardPile currentDiscardPile;
    public boolean forgotUno;
    public boolean wildCardIllegal;

    /**
     * @return the card the player wants to play, can be null if player cannot play
     *
     * The player is asked to make its move
     */
    public ICard yourTurn() {
        return null;
    }


    /**
     * The player challenges that the last player did not say UNO
     */
    public void challengeUNO(Player player) {

    }

    /**
     * The player challenges the legality of the last wildcard
     */
    public void challengeWildCard(Player player) {

    }

    /**
     * @param cardsToTake number of cards the player will draw
     *
     * This method can be called on the player if he needs to draw extra cards
     */
    public void takeCards(int cardsToTake) {

    }

    /**
     * Called if the player can choose the next legal color
     */
    public void chooseColor() {

    }

    /**
     * @return tells if the player is dealer in current round
     */
    public boolean isDealer() {
        return false;
    }
}
