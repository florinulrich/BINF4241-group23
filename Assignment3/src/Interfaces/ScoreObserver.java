package Interfaces;

public interface ScoreObserver {

    void update(IPiece lastBeatenPiece);
    int getScoreWhite();
    int getScoreBlack();
}
