package Cards;

import Cards.Interfaces.ICard;
import Enumerations.CardColor;
import Enumerations.CardNumber;
import Game.DiscardPile;

/**
 * Only ActionCards can be decorated with additional functionality
 * ActionCards do never have a number, only a Color
 */
public class ActionCard implements ICard {

    CardColor color;


    /**
     * @param currentGame the Discard Pile of the current game
     */
    void executeAction(DiscardPile currentGame) {

    }

    @Override
    public CardColor getColor() {
        return null;
    }

    @Override
    public boolean hasActions() {
        return false;
    }
}
