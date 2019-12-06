
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class GameRunnerTest {

    Game testGame;

    @Before public void setUp(){

        testGame = new Game(10);

    }

    /**
     * Test checks for the three possible player counts, weather it works to set them.
     */
    @Test public void TestAskForPlayerNumber(){

        String[] strings = {"2", "3", "4"};

        for (String string : strings) {
            InputStream stdin = System.in;
            System.setIn(new ByteArrayInputStream(string.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.setIn(stdin);
            GameRunner.askForPlayerNumber(scanner);

            assertEquals(Integer.parseInt(string), GameRunner.numberOfPlayers);
        }

    }

    /**
     * Tests if the askforboardsize method checks the board size is at least 3
     */
    @Test public void testAskForBoardSize() {

        String[] strings = {"3", "4"};

        for (String string : strings) {

            String input = "2\n" + string;

            InputStream stdin = System.in;
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.setIn(stdin);
            GameRunner.askForBoardSize(scanner);

            assertEquals(Integer.parseInt(string), GameRunner.boardSize);
        }

    }

    /**
     * Tests if the names of the players are added correctly
     */
    @Test public void testGetPlayerNames() {

        String[] strings = {"George" + "\n" + "Paul"};
        LinkedList names = new LinkedList();
        names.add("George");
        names.add("Paul");
        GameRunner.numberOfPlayers = 2;
        GameRunner.playerNames = new LinkedList();

        for (String string : strings) {

            InputStream stdin = System.in;
            System.setIn(new ByteArrayInputStream(string.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.setIn(stdin);
            GameRunner.getPlayerNames(scanner);

            assertEquals(names, GameRunner.playerNames);
        }

    }

    /**
     *Tests that after adding the snakes and ladders, the first and last square are still normal squares
     */
    @Test public void TestAddSnakesAndLadders(){
        GameRunner.addSnakesAndLadders(testGame);

        assertTrue("First Square cannot be snake or ladder", testGame.getSquares().get(0) instanceof Square);
        assertTrue("Last Square cannot be snake or ladder", testGame.getSquares().get(9) instanceof Square);

    }

    @After public void tearDown(){

        testGame = null;

    }
}
