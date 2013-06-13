package com.ilyagubarev.projects.miscellaneous.testapp;

import com.ilyagubarev.projects.miscellaneous.diamonds.testing.DiamondsTester;
import com.ilyagubarev.projects.miscellaneous.stringtricks.testing.StringTricksTester;
import java.util.LinkedList;
import java.util.List;

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
        testStringTricks();
    }

    /**
     * Tests diamonds project.
     */
    private static void testDiamonds() {
        char[] diamondMatter = new char[] { '*', ' ', ' ' };
        DiamondsTester.test(31, diamondMatter, ' ', true, null);
    }

    /**
     * Tests string reversion.
     */
    private static void testStringTricks() {
        List<String> strings = new LinkedList<String>();
        strings.add("zalando");
        strings.add("abc");
        strings.add(null);
        strings.add("");
        strings.add("1");
        strings.add("sd");
        StringTricksTester.testReverse(strings);
    }
}