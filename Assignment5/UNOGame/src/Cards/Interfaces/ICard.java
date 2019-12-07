package Cards.Interfaces;

import Enumerations.CardColor;

/**
 * This interface defines what all cards must be able to do
 */
public interface ICard {

    CardColor getColor();
    boolean hasActions();
}
