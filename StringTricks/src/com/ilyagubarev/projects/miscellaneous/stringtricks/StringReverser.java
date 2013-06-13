package com.ilyagubarev.projects.miscellaneous.stringtricks;

/**
 *
 */
public class StringReverser {

    /**
     * 
     */
    public StringReverser() {

    }

    /**
     *
     * 
     * @param string
     * @return
     */
    public String recursionReverse(String string) {
        if (string == null) {
            return null;
        }
        if (string.length() < 2) {
            return string;
        }
        return recursionReverse(string.substring(1)) + string.charAt(0);
    }
}