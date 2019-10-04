
public class Square implements ISquare {


  //Variables
  private boolean isOccupied = false;

  //Methods
  public void leave(Player player) {
    this.isOccupied = false;
  }

  @Override
  public void moveAndLand(int numberOfSteps) {

    //findSquare(numberOfSteps)
  }

  @Override
  public ISquare landHereOrGoHome() {
    if (isOccupied()) {
      //return Game start square
      return
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
