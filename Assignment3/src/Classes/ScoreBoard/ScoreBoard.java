package Classes.ScoreBoard;

import Enumerations.PieceColor;
import Enumerations.PieceType;
import Interfaces.IPiece;
import Interfaces.ScoreObserver;

public class ScoreBoard implements ScoreObserver {

    private int scoreWhite = 0;
    private int scoreBlack = 0;

    public void update(IPiece lastBeatenPiece) {

        int scoreToBeAdded = 1;

        if (lastBeatenPiece.getType() == PieceType.QUEEN) {
            scoreToBeAdded = 5;
        }

        if (lastBeatenPiece.getColor() == PieceColor.WHITE) {
            scoreBlack += scoreToBeAdded;
        } else {
            scoreWhite += scoreToBeAdded;
        }
    }

    public int getScoreWhite() {
        return scoreWhite;
    }

    public int getScoreBlack() {
        return scoreBlack;
    }
}
