package com.tehjul.enums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchPointsTest {

    @Test
    void testToString() {
        String result = MatchPoints.FIFTEEN.toString();
        assertEquals("fifteen", result);
    }

    @Test
    void values() {
        List<String> expected = Arrays.asList("love", "fifteen", "thirty", "forty", "advantage");
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), MatchPoints.values()[i].toString());
    }

    @Test
    void valueOf() {
        assertEquals("forty", MatchPoints.valueOf("FORTY").toString());
    }
}