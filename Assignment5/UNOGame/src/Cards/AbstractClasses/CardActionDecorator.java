package Cards.AbstractClasses;

import Cards.ActionCard;

/**
 * This is the Decorator for the Action Cards. It encapsulates the functionality.
 */
public abstract class CardActionDecorator extends ActionCard {

    private ActionCard nestedCard;

}
