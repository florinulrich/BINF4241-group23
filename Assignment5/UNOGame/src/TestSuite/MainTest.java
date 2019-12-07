package TestSuite;


import Game.DiscardPile;
import Game.DrawPile;
import Game.Main;
import Game.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
        Main.players = new ArrayList<>();
        Main.players.add(new Player());
        Main.discardPile = new DiscardPile();
        Main.drawPile = new DrawPile();
    }

    @AfterEach
    void tearDown() {
        Main.players = null;
        Main.drawPile = null;
        Main.discardPile = null;
    }

    /**
     * The game is over as soon as a score is at least 500
     */
    @Test
    void run() {
        Main.players.get(0).score = 500;
        Main.run();
        assertTrue(Main.gameOver);
    }

    /**
     * At the beginning of the game, each player has 7 cards
     */
    @Test
    void testSetUp() {
        setUp();
        for (Player player: Main.players) {
            assertEquals(7, player.hand.size());
        }
    }
}