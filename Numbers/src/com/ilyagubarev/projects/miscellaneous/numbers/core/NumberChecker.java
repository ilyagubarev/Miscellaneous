package com.ilyagubarev.projects.miscellaneous.numbers.core;

/**
 *
 */
public class NumberChecker {

    /**
     * Creates a new instance of NumberChecker.
     */
    public NumberChecker() {

    }

    /**
     *
     *
     * @param number
     * @return
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Recursive method for checking if a specified positive number is even.
     * Results can be unpredictable for non-positive integers.
     *
     * @param number a positive number.
     * @return true if number is even.
     */
    public boolean isPositiveEvenRecursive(int number) {
        if (number <= 0) {
            return number == 0;
        }
        return isPositiveEvenRecursive(number - 2);
    }

    /**
     *
     *
     * @param number
     * @return
     */
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int divider = 2; divider < number; ++divider) {
            if (number % divider == 0) {
                return false;
            }
        }
        return true;
    }
}