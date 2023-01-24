package com.tehjul.helpers;

public class MathHelpers {

    /**
     * Generate a random number between 1 and 2
     *
     * @return int: 1 or 2
     */
    public static int getRandom() {
        return (Math.random() <= 0.5) ? 1 : 2;
    }

    /**
     * Check if there is a difference of two or more between two numbers
     * @param a the first number
     * @param b the second number
     * @return true if there is a difference of two or more, false otherwise
     */
    public static boolean hasDifferenceOfTwo(int a, int b) {
        return Math.abs(a - b) >= 2;
    }
}
