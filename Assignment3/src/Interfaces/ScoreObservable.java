package Interfaces;

public interface ScoreObservable {

    void registerObserver(ScoreObserver observer);
    void unregisterObserver(ScoreObserver observer);
    void notifyObservers(IPiece lastBeatenPiece);
}
