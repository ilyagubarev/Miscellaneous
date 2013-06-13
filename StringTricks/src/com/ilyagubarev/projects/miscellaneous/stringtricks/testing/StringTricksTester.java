package com.ilyagubarev.projects.miscellaneous.stringtricks.testing;

import java.util.List;

import com.ilyagubarev.projects.miscellaneous.stringtricks.StringReverser;

/**
 *
 */
public abstract class StringTricksTester {

    /**
     * 
     * 
     * @param string
     * @return
     */
    public static void testReverse(List<String> strings) {
        if (strings == null) {
            return;
        }
        StringReverser reverser = new StringReverser();
        for (String string : strings) {
            String reversed = reverser.recursionReverse(string);
            System.out.println(String.format("%s -> %s", string, reversed));
        }
    }
}