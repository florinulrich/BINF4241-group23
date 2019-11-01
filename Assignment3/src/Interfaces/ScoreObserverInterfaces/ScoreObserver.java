package Interfaces.ScoreObserverInterfaces;

import Interfaces.IPiece;

public interface ScoreObserver {

    void update(IPiece lastBeatenPiece);
    int getScoreWhite();
    int getScoreBlack();
}
