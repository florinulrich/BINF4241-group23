

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class GameRunnerTest {

    //TODO: Implement Test

    Game testGame;


    @Before public void setUp(){

        testGame = new Game(10);

    }


    /**
     *
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

    @Test public void testAskForBoardSize() {

        String[] strings = {"3", "4"};

        for (String string : strings) {
            InputStream stdin = System.in;
            System.setIn(new ByteArrayInputStream(string.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.setIn(stdin);
            GameRunner.askForPlayerNumber(scanner);

            assertEquals(Integer.parseInt(string), GameRunner.askForBoardSize());
        }

    }

    /**
     *
     */
    @Test public void TestSetUpGame(){

    }

    /**
     *
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
