import java.util.ArrayList;

public interface ISquare {

    public void leave(Player playerName);

    public ISquare moveAndLand(int numberOfSteps);

    public ISquare landHereOrGoHome();

    public void enter(Player playerName);

    public boolean isLastSquare();

    public void setAsLastSquare();

    public int getPosition();

    public ArrayList<Player> getPlayerOnSquare();

    public void addPlayer(Player player);

    public void printSquareString();
}
