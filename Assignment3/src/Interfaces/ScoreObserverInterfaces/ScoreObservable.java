package Interfaces.ScoreObserverInterfaces;

import Interfaces.IPiece;

public interface ScoreObservable {

    void registerObserver(ScoreObserver observer);
    void unregisterObserver(ScoreObserver observer);
    void notifyScoreObservers(IPiece lastBeatenPiece);
}
