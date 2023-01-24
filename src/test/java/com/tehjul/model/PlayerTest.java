package com.tehjul.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayerTest {

    private Player player;

    @BeforeAll
    public void setUp() {
        PlayerScore playerScore = Mockito.mock(PlayerScore.class);
        player = new Player("Julien", playerScore);
    }

    @Test
    void testNameShouldReturnName() {
        String expected = "Julien";
        String result = player.name();
        assertEquals(expected, result);
    }

    @Test
    void testScoreShouldReturnPlayerScoreInstance() {
        PlayerScore result = player.score();
        assertInstanceOf(PlayerScore.class, result);
    }
}