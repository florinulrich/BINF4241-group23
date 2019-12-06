#ANSWERS

##Part 1

1) All test cases are in a separate class that correspond to the one tested and contain the testcases for each method, for this at some places the access of the methods needed to be changed from private to package-private. We always considered the methods called within the tested one as working, since they were tested separately. We checked for nullpointers where possible and necessary, and covered the edge cases and the functionality in general.
2) since the test methods do not receive input nor return anything we decided to omit @param and @return for all test cases, for further test description we refer you to the javadoc above the individual methods
3) During the testing we found some bugs, and in a few cases had to slightly change the code to enable testing. The following is a list of all alterations of the original code:

 * Game
   * addNewPlayer the Player now enters the First square when being initialized
   * setSquares was deleted (and therefore did not need to be tested) because it was never used in the original code
 * GameRunner
   * To be able to test the GameRunnerClass, we broke down the getSetupInputs into the testable methods getPlayerNames, askForBoardSize and askForPlayerNumber (The last was a seperate method from the start but served as a model for the other two).

   *boardSize now can not be smaller than 3, because it being 1 broke the game
 * Player
   * After the player is created on a Square, it immediately enters this square
   * setCurrentSquare now throws an Exception if the input is null.
 * SnakeOrLadder
   Since the SnakeOrLadderClass Calls the exact same methods as the Square Class (it only redirects the calls) the only thing to make sure is that the finalSquare can never be null.

##Part 2

##Part 3
