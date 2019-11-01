package Interfaces.CheckMateObserverInterfaces;

import Enumerations.PieceColor;

public interface CheckMateObservable {

    void registerObserver(CheckMateObserver observer);
    void unregisterObserver(CheckMateObserver observer);
    void notifyCheckMateObservers(PieceColor playerColor);
}
