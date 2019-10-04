public interface ISquare {

    public void leave(Player playerName);

    public void moveAndLand(int numberOfSteps);

    public ISquare landHereOrGoHome();

    public void enter(Player playerName);

    public boolean isLastSquare();
}