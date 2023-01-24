package com.tehjul.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerScoreTest {

    private PlayerScore playerScore;

    @BeforeEach
    public void setUp() {
        playerScore = new PlayerScore();
    }

    @Test
    void testGetGameScoreShouldReturnGameScore() {
        playerScore.incrementGameScore();
        int expected = 1;
        int result = playerScore.getGameScore();
        assertEquals(expected, result);
    }

    @Test
    void testIncrementGameScoreShouldIncrementBy1() {
        int result = playerScore.getGameScore();
        assertEquals(0, result);

        playerScore.incrementGameScore();

        result = playerScore.getGameScore();
        assertEquals(1, result);
    }

    @Test
    void testDecrementGameScoreShouldDecrementBy1() throws IllegalAccessException {
        playerScore.incrementGameScore();
        playerScore.incrementGameScore();

        int result = playerScore.getGameScore();
        assertEquals(2, result);

        playerScore.decrementGameScore();

        result = playerScore.getGameScore();
        assertEquals(1, result);
    }

    @Test
    void testDecrementGameScoreShouldThrowAnException() {
        IllegalAccessException thrown = assertThrows(IllegalAccessException.class, () -> playerScore.decrementGameScore());
        String expected = "can't decrement below zero.";
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    void testClearGameScoreShouldSetGameScoreToZero() {
        playerScore.incrementGameScore();
        playerScore.incrementGameScore();

        int result = playerScore.getGameScore();
        assertEquals(2, result);

        playerScore.clearGameScore();

        result = playerScore.getGameScore();
        assertEquals(0, result);
    }

    @Test
    void testGetMatchScoreShouldReturnMatchScore() {
        playerScore.incrementMatchScore();
        int result = playerScore.getMatchScore();
        assertEquals(1, result);
    }

    @Test
    void testIncrementMatchScoreShouldIncrementBy1() {
        int result = playerScore.getMatchScore();
        assertEquals(0, result);

        playerScore.incrementMatchScore();

        result = playerScore.getMatchScore();
        assertEquals(1, result);
    }
}