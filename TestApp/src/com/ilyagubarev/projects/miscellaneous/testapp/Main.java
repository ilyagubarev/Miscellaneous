package com.ilyagubarev.projects.miscellaneous.testapp;

import com.ilyagubarev.projects.miscellaneous.diamonds.testing.DiamondsTester;

/**
 * Test application main class.
 *
 * @version 1.01, 04 June 2013
 * @since 04 June 2013
 * @author Ilya Gubarev
 */
public abstract class Main {

    /**
     * Application entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        testDiamonds();
    }

    /**
     * Tests diamonds project.
     */
    private static void testDiamonds() {
        DiamondsTester.test(91, '*', ' ', true, "c:\\test.log");
    }
}