package Interfaces.CheckMateObserverInterfaces;

import Enumerations.PieceColor;

public interface CheckMateObserver {

    void update(PieceColor playerColor);

    boolean isCheckmate();
}
