package Classes.Observers;

import Enumerations.PieceColor;
import Interfaces.CheckMateObserverInterfaces.CheckMateObserver;

public class CheckMate implements CheckMateObserver {

    private static  CheckMate uniqueInstance = new CheckMate();

    private CheckMate(){}

    public static CheckMate getInstance(){
        return uniqueInstance;
    }

    private boolean isCheckmate = false;

    @Override
    public void update() {
        isCheckmate = true;

    }

    @Override
    public boolean isCheckmate() {
        return isCheckmate;
    }
}
