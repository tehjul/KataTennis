package com.tehjul.helpers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathHelpersTest {

    @Test
    void testGetRandomShouldBeTrueIf1Or2() {
        List<Integer> list = Arrays.asList(1,2);
        assertTrue(list.contains(MathHelpers.getRandom()));
    }

    @Test
    void testGetRandomShouldBeFalseIf3Or4() {
        List<Integer> list = Arrays.asList(3,4);
        assertFalse(list.contains(MathHelpers.getRandom()));
    }

    @Test
    void testHasDifferenceOfTwoShouldReturnTrueIf3And5() {
        int numberOne = 3;
        int numberTwo = 5;
        assertTrue(MathHelpers.hasDifferenceOfTwo(numberOne, numberTwo));
    }

    @Test
    void testHasDifferenceOfTwoShouldReturnFalseIf1And2() {
        int numberOne = 1;
        int numberTwo = 2;
        assertFalse(MathHelpers.hasDifferenceOfTwo(numberOne, numberTwo));
    }
}