package com.ilyagubarev.projects.miscellaneous.diamonds.core;

import java.io.IOException;
import java.io.Writer;

/**
 * Describes a common interface for all the diamond presenters.
 *
 * @version 1.02, 02 June 2013
 * @since 01 June 2013
 * @author Ilya Gubarev
 */
public interface DiamondPresenter {

    /**
     * Checks if a diamond with specified height would be faceted. That
     * means it would have a sharp angle at its thickest layer
     * and an explicit symmetry axis.
     *
     * @param height diamond height.
     * @return true if the diamond would be faceted.
     * @throws IllegalArgumentException if specified height value is illegal.
     */
    boolean isFaceted(int height) throws IllegalArgumentException;

    /**
     * Gets a width of the thickest layer(s) of a diamond with specified height.
     *
     * @param height diamond height.
     * @return a maximal width of the diamond.
     * @throws IllegalArgumentException if specified height value is illegal.
     */
    int getMaxWidth(int height) throws IllegalArgumentException;

    /**
     * Creates a string representation of a diamond with specified height.
     * Maximal size of the view is limited by an available RAM.
     *
     * @param height diamond height.
     * @return string representation of the diamond.
     * @throws IllegalArgumentException if specified height value is illegal.
     * @throws PresenterException if some inner error occurs.
     */
    String getView(int height)
            throws IllegalArgumentException, PresenterException;

    /**
     * Creates a string representation of a diamond with specified height
     * and writes it to specified character output stream. Can be used
     * for saving representation to a hard disk. In this case maximal size
     * of the view would not be limited by an available RAM.
     * 
     * @param height diamond height.
     * @param writer character output stream.
     * @throws IllegalArgumentException if specified height value is illegal.
     * @throws IOException if streaming error occurs.
     * @throws PresenterException if some inner error occurs.
     */
    void writeView(int height, Writer writer)
            throws IllegalArgumentException, IOException, PresenterException;
}