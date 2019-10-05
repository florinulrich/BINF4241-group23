import java.util.ArrayList;

public class SnakeOrLadder implements ISquare {

    //Variables
    private Game myGame;
    private int position;
    private boolean isLastSquare;
    private SquareType squareType;

    private ISquare finalSquare;

    public enum SquareType {
        LADDER,
        SNAKE
    }

    //Initializer
    SnakeOrLadder(Game parentGame, int position, SquareType setSquareType, ISquare targetSquare) {
        this.myGame = parentGame;
        this.position = position;
        this.squareType = setSquareType;
        this.finalSquare = targetSquare;
    }

    //Methods
    @Override
    public void leave(Player playerName) {
        finalSquare.leave(playerName);

    }

    @Override
    public ISquare moveAndLand(int numberOfSteps) {
        return finalSquare.moveAndLand(numberOfSteps);
    }

    @Override
    public ISquare landHereOrGoHome() {
        return finalSquare.landHereOrGoHome();
    }

    @Override
    public void enter(Player playerName) {
        finalSquare.enter(playerName);
    }

    @Override
    public boolean isLastSquare() {
        return finalSquare.isLastSquare();
    }

    @Override
    public void setAsLastSquare() {
        finalSquare.setAsLastSquare();
    }

    @Override
    public int getPosition() {
        return finalSquare.getPosition();
    }

    @Override
    public ArrayList<Player> getPlayerOnSquare() {
        return finalSquare.getPlayerOnSquare();
    }

    @Override
    public void addPlayer(Player player) {
        finalSquare.addPlayer(player);
    }

    @Override
    public String printSquareString() {

        switch (this.squareType) {
            case LADDER: return "[" + this.position + "->" + this.finalSquare.getPosition() + "]";

            case SNAKE: return "[" + this.finalSquare.getPosition() + "<-" + this.position + "]";
        }
        return "ERROR IN SWITCH STATEMENT: squareType undefined!";
    }
}
