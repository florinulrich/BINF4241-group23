
public class Square implements ISquare {


  //Variables
  private boolean isOccupied = false;
  private Game myGame;

  //Initializer
  public Square(Game parentGame) {
    this.myGame = parentGame;
  }

  //Methods
  public void leave(Player player) {
    this.isOccupied = false;
  }

  @Override
  public ISquare moveAndLand(int numberOfSteps) {

    ISquare newSquare = myGame.findSquare(numberOfSteps);
    newSquare = newSquare.landHereOrGoHome();

    return newSquare;
  }

  @Override
  public ISquare landHereOrGoHome() {
    if (isOccupied()) {
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
  }

  @Override
  public boolean isLastSquare() {
    return false;
  }

}
