
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {


    private Game testGame;
    private Player testPlayer1;
    private Player testPlayer2;
    private Square middleSquare;
    private ArrayList<ISquare> testSquares;
    private Square startSquare;
    private int stepsToMiddleSquare;


    @Before public void setUp() {
        testGame = new Game(10);
        testSquares = testGame.getSquares();
        startSquare = (Square) testGame.firstSquare();
        testPlayer1 = new Player("Player1", startSquare);
        testPlayer2 = new Player("Player2", startSquare);
        testGame.addNewPlayer(testPlayer1);
        testGame.addNewPlayer(testPlayer2);

        //Make sure the middle square is not a snake or ladder
        int i = 2;
        while (true) {
            try {
                middleSquare = (Square) testSquares.get(i);
                break;
            } catch (Exception e) {
                i +=1;
            }
        }

        stepsToMiddleSquare = i;
    }

    /**
     * After the player moved, it should be on a new square and the square in turn the new player on it
     * The old square should no longer have the player on it
     * If the square is occupied the player lands on start
     * If player reaches last square gameOver == true
     */
    @Test public void testMovePlayer() {

        Player movingPlayer = testGame.players.peek(); //The player about to move
        testGame.movePlayer(stepsToMiddleSquare);
        assertEquals(middleSquare, movingPlayer.square());

        //There now should only be one player on start
        assertEquals(1, startSquare.getPlayerOnSquare().size());

        //Second player moves to last square which leads to game over
        testGame.movePlayer(testSquares.size()-1);

        assertTrue("The game should be game over", testGame.gameOver());


        //For each possible dice roll
        for (int i = 1; i < 7; i++) {
            tearDown();
            setUp();
            boolean worked = false;
            try {
                testGame.movePlayer(i);
                worked = true;
            } catch (Exception ignored) {

            }
            assertTrue("The program doesn't work for a dice roll of " + i, worked);

        }

    }

    /**
     * This method tests the findSquare method, which returns the square the player has to go to next
     * If the player wants to move to far, he has to move back the remaining steps
     */
    @Test public void testFindSquare() {

        //Should return the middle square
        assertEquals(middleSquare, testGame.findSquare(stepsToMiddleSquare, 0));
        testGame.movePlayer(stepsToMiddleSquare); //Player1 is on middle square
        assertEquals(middleSquare, testPlayer1.square());

        //Player will end on middle square because of stepping back
        int totalStepsToMove = 2*(testSquares.size()-1) - stepsToMiddleSquare;
        assertEquals(middleSquare, testGame.findSquare(totalStepsToMove, 0));

    }

    /**
     * At the beginning gameOver == false
     * After a player reaches the last square gameOver == true
     */
    @Test public void testGameOver() {

        assertFalse("GameOver returns false value", testGame.gameOver());

        testGame.movePlayer(9);

        assertTrue("Player reached last square but game is not game Over!", testGame.gameOver());

    }

    /**
     * Tests if there is a new player that was added to the playerqueue
     */
    @Test public void testAddNewPlayer() {
         testGame.players = new PlayerQueue();
         testGame.players.add(testPlayer1);

         //Test fails if the queue is empty after adding a Player
         assertNotNull("Player Queue should not be empty", testGame.players.remove());

    }

    /**
     * Tests if the method returns the player from the last square,
     * and also what happens if the array is empty
     */
    @Test public void testGetLastSquaresPlayer() {

        boolean exceptionCaught;

        try {
            testGame.getLastSquaresPlayer();
            exceptionCaught = false;
        } catch (Exception e) {
            exceptionCaught = true;
        }

        assertTrue("The method should throw an exception if it is called before a player" +
                " is on the last square,i.e. the game is over", exceptionCaught);

        ISquare lastSquare = testGame.getSquares().get(testGame.getSquares().size()-1);
        lastSquare.addPlayer(testPlayer1);

        assertEquals(testPlayer1, testGame.getLastSquaresPlayer());

    }

    @After public void tearDown() {
        testGame = null;
        testSquares = null;
        startSquare = null;
        testPlayer1 = null;
        testPlayer2 = null;

    }

}
