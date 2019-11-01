package Classes.Observers;

import Enumerations.PieceColor;
import Interfaces.CheckMateObserverInterfaces.CheckMateObserver;

public class CheckMate implements CheckMateObserver {

    private boolean isCheckmate = false;

    @Override
    public void update(PieceColor playerColor) {
        System.out.println("Checkmate! Player " + playerColor + " wins!");

        isCheckmate = true;

    }

    @Override
    public boolean isCheckmate() {
        return isCheckmate;
    }
}
