# ANSWERS

## Part 1

1) All test cases are in a separate class that correspond to the one tested and contain the testcases for each method, for this at some places the access of the methods needed to be changed from private to package-private. We always considered the methods called within the tested one as working, since they were tested separately. We checked for nullpointers where possible and necessary, and covered the edge cases and the functionality in general.
2) since the test methods do not receive input nor return anything we decided to omit @param and @return for all test cases, for further test description we refer you to the javadoc above the individual methods
3) During the testing we found some bugs, and in a few cases had to slightly change the code to enable testing. The following is a list of all alterations of the original code:

 * Game
   * addNewPlayer the Player now enters the First square when being initialized
   * setSquares was deleted (and therefore did not need to be tested) because it was never used in the original code
 * GameRunner
   * To be able to test the GameRunnerClass, we broke down the getSetupInputs into the testable methods getPlayerNames, askForBoardSize and askForPlayerNumber (The last was a seperate method from the start but served as a model for the other two).

   * boardSize now can not be smaller than 3, because it being 1 broke the game
 * Player
   * After the player is created on a Square, it immediately enters this square
   * setCurrentSquare now throws an Exception if the input is null.
 * SnakeOrLadder
   Since the SnakeOrLadderClass Calls the exact same methods as the Square Class (it only redirects the calls) the only thing to make sure is that the finalSquare can never be null.

## Part 2

1) We succesfully copied the source code to our repository
2) (and 3.) The following list shows each bug we found and how we fixed it:
* (GameBoard, line 41) change Javadoc "board" to "other" to match the parameter
* (GameBoard, line 76 - 92) change return statements (switch true and false) so true is returned when a field in the game is still available (and vice versa)
* (GameBoard, line 115 - 126) fixed the for loop to start with 0 instead of 1, so the method considers all columns
* (TicTacToeGameState, line 74 - 80) remove the randomPlayer variable so the method retunrs the true current player
* (TicTacToeGameState, line 101- 109) change return value from false to true so the method returns true when a player completes a colum or row
* (TicTacToeGameState, line 161 - 167) changed to consider the mark (2,2) instead of (1,2) so that the method can check the diagonals correctly

## Part 3

1)  a. the system should only accept strings and no other inputs
    b. the string inputs should state the following: 
    * (Setup) age, number of players 
    * (GamePlay) played card (e.g. "blue, 8"), draw (if available), say "UNO", challange a player that he/she illegaly played a wild four card, choose color if wild card is played
    the system should check/store the inputs and ask for new input, if it was enterd in the wrong form (e.g. illegal syntax, or a player does not have a card that he/she states to play)
    c. the system should only display the top card of the pile, which player is next, the cards of the current player, status updates (e.g. "player 2 has to draw 2 cards") and if a move has to be repeated (because of illegal input).
2) the class diagram of the system:
