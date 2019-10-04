
public class Square implements ISquare {


  //Variables
  private boolean isOccupied = false;
  private Game myGame;
  private boolean isLastSquare = false;
  int position;

  //Initializer
  Square(Game parentGame, int position) {
    this.myGame = parentGame;
    this.position = position;
  }

  //Methods
  public void leave(Player player) {
    this.isOccupied = false;
  }

  @Override
  public ISquare moveAndLand(int numberOfSteps) {

    ISquare newSquare = myGame.findSquare(numberOfSteps, position);
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
    return isLastSquare;
  }

  @Override
  public void setAsLastSquare() {
    this.isLastSquare = true;
  }

}
