package Cards.ActionCards;

import Cards.AbstractClasses.ActionCard;
import Enumerations.CardColor;
import Game.DiscardPile;

public class TakeTwoCard extends ActionCard {

    public TakeTwoCard(CardColor color) {

    }

    @Override
    public void executeAction(DiscardPile currentGame) {
        currentGame.tellNextPlayerToDraw(2);
    }

}
