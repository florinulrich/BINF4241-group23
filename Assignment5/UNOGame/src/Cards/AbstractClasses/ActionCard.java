package Cards.AbstractClasses;

import Cards.Interfaces.ICard;
import Enumerations.CardColor;
import Enumerations.CardNumber;
import Game.DiscardPile;

/**
 * Only ActionCards can have additional functionality
 * ActionCards do never have a number, only a Color
 * The Action Card Class encapsulates all base functionality, which the different decorators can extend
 */
public abstract class ActionCard implements ICard {

    CardColor color;


    /**
     * @param currentGame the Discard Pile of the current game
     */
    public void executeAction(DiscardPile currentGame) {

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
