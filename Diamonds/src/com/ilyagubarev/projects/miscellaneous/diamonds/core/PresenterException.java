package com.ilyagubarev.projects.miscellaneous.diamonds.core;

import com.ilyagubarev.projects.miscellaneous.diamonds.resources.Errors;

/**
 * Diamond presenters inner exception.
 *
 * @version 1.01, 02 June 2013
 * @since 02 June 2013
 * @author Ilya Gubarev
 */
public class PresenterException extends Exception {

    /**
     * Creates a new instance of PresenterException.
     */
    public PresenterException() {
        this(Errors.UNKNOWN);
    }

    /**
     * Creates a new instance of PresenterException.
     *
     * @param message custom error message.
     */
    public PresenterException(String message) {
        super(message);
    }

    /**
     * Creates a new instance of PresenterException.
     * 
     * @param cause initial cause exception.
     */
    public PresenterException(Throwable cause) {
       super(cause);
    }
}