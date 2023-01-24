package com.tehjul.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MatchScoreTest {

    private MatchScore matchScore;
    private Player player1;
    private Player player2;
    private ByteArrayOutputStream outContent;

    @BeforeAll
    public void setUp() {
        player1 = new Player("Julien", new PlayerScore());
        for (int i = 0; i < 2; i++) player1.score().incrementGameScore();
        player2 = new Player("Tester", new PlayerScore());
        for (int i = 0; i < 3; i++) player2.score().incrementGameScore();
        matchScore = new MatchScore(player1, player2);
    }

    @BeforeEach
    public void setUpEach() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testClearGameScoresShoudlSetPlayersScoresToZero() {
        assertEquals(2, player1.score().getGameScore());
        assertEquals(3, player2.score().getGameScore());

        matchScore.clearGameScores();

        assertEquals(0, player1.score().getGameScore());
        assertEquals(0, player2.score().getGameScore());
    }

    @Test
    void testPrintGameScore() {
        matchScore.printGameScore();
        String expected = "Game n°1, Julien: thirty - Tester: forty";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testPrintMatchScore() {
        matchScore.printMatchScore();
        String expected = "Match score : Julien: 0 Tester: 0";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testPrintWinner() {
        matchScore.printWinner();
        String expected = "Game, Set and Match Tester !";
        assertEquals(expected, outContent.toString().trim());
    }
}