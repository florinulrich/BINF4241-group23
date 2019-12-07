package Cards.ActionCards;

import Cards.AbstractClasses.ActionCard;
import Game.DiscardPile;

public class TakeTwoCard extends ActionCard {

    @Override
    public void executeAction(DiscardPile currentGame) {
        currentGame.tellNextPlayerToDraw(2);
    }



}
