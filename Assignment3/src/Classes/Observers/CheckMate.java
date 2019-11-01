package Classes.Observers;

import Enumerations.PieceColor;
import Interfaces.CheckMateObserverInterfaces.CheckMateObserver;

public class CheckMate implements CheckMateObserver {
    @Override
    public void update(PieceColor playerColor) {
        System.out.println("Checkmate! Player " + playerColor + " wins!");

    }
}
