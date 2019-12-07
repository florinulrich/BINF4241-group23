package Cards;

import Cards.Interfaces.ICard;
import Enumerations.CardColor;
import Enumerations.CardNumber;

/**
 * A number card has a fixed Color and Number which determine on what other cards they can be placed.
 * They can never have the Color "BLACK"
 */
public class NumberCard implements ICard {

    public NumberCard(CardColor cardColor, CardNumber number) {

    }

    CardColor color;
    CardNumber number;

    public CardNumber getNumber() {
        return null;
    }

    @Override
    public CardColor getColor() {
        return null;
    }

    @Override
    public boolean hasActions() {
        return true;
    }
}
