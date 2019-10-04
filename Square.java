import java.util.ArrayList;
import java.util.List;

public class Square implements ISquare {


  //Variables
  private boolean isOccupied = false;
  private Game myGame;
  private boolean isLastSquare = false;
  private int position;
  private ArrayList<Player> playerOnSquare = new ArrayList<>();

  //Initializer
  Square(Game parentGame, int position) {
    this.myGame = parentGame;
    this.position = position;
  }

  //Methods
  public void leave(Player player) {
    playerOnSquare.remove(player);
    if (playerOnSquare.isEmpty()) {
      isOccupied = false;
    }
  }

  @Override
  public ISquare moveAndLand(int numberOfSteps) {

    ISquare newSquare = myGame.findSquare(numberOfSteps, position);
    newSquare = newSquare.landHereOrGoHome();

    return newSquare;
  }

  @Override
  public ISquare landHereOrGoHome() {
    if (this.isOccupied() && this.position != 0) {
      //return Game start square
      return myGame.firstSquare();

    }
    else {
      return this;
    }

  }

  private boolean isOccupied() {

    return isOccupied;

  }

  @Override
  public void enter(Player playerName) {

    this.isOccupied = true;
    playerOnSquare.add(playerName);
    playerName.setCurrentSquare(this);
  }

  @Override
  public boolean isLastSquare() {
    return isLastSquare;
  }

  @Override
  public void setAsLastSquare() {
    this.isLastSquare = true;
  }

  @Override
  public int getPosition() {
    return this.position;
  }
  @Override
  public ArrayList<Player> getPlayerOnSquare() {
    return playerOnSquare;
  }

  @Override
  public void addPlayer(Player player) {
    playerOnSquare.add(player);
  }
}
