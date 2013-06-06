package com.ilyagubarev.projects.miscellaneous.diamonds.core;

import java.io.Writer;
import java.io.CharArrayWriter;
import java.io.IOException;

import com.ilyagubarev.projects.miscellaneous.diamonds.resources.Defaults;
import com.ilyagubarev.projects.miscellaneous.diamonds.resources.Errors;
import com.ilyagubarev.projects.miscellaneous.diamonds.resources.Misc;

/**
 * Basic implementation of diamond presenter.
 *
 * @version 1.03, 03 June 2013
 * @since 01 June 2013
 * @author Ilya Gubarev
 */
public class DiamondPresenterBasic implements DiamondPresenter {

    /**
     * Creates a new instance of DiamondPresenterBasic.
     */
    public DiamondPresenterBasic() {

    }

    /**
     * Checks if a diamond with specified height would be faceted. That
     * means it would have a sharp angle at its thickest layer
     * and an explicit symmetry axis.
     *
     * @param height diamond height, must be positive.
     * @return true if the diamond would be faceted.
     * @throws IllegalArgumentException if specified height value is illegal.
     */
    public boolean isFaceted(int height) throws IllegalArgumentException {
        validateHeight(height);
        return height % 2 != 0;
    }

    /**
     * Gets a width of the thickest layer(s) of a diamond with specified height.
     *
     * @param height diamond height, must be positive..
     * @return a maximal width of the diamond.
     * @throws IllegalArgumentException if specified height value is illegal.
     */
    public int getMaxWidth(int height) throws IllegalArgumentException {
        validateHeight(height);
        return isFaceted(height) ? height : height - 1;
    }

    /**
     * Creates a string representation of a diamond with specified height.
     * Maximal size of the view is limited by an available RAM.
     *
     * @param height diamond height, must be positive.
     * @return string representation of the diamond.
     * @throws IllegalArgumentException if specified height value is illegal.
     * @throws PresenterException if some inner error occurs.
     */
    public String getView(int height)
            throws IllegalArgumentException, PresenterException {
        validateHeight(height);
        String result = null;
        try {
            CharArrayWriter writer = new CharArrayWriter();
            writeView(height, writer);
            result = writer.toString();
            writer.close();
        } catch (IOException e) {
            throw new PresenterException(Errors.INNER_STREAMING);
        } catch (OutOfMemoryError e) {
            throw new PresenterException(Errors.NO_MEMORY);
        }
        return result;
    }

    /**
     * Creates a string representation of a diamond with specified height
     * and writes it to specified character output stream. Can be used
     * for saving representation to a hard disk. In this case maximal size
     * of the view would not be limited by an available RAM.
     *
     * @param height diamond height, must be positive.
     * @param writer character output stream.
     * @throws IllegalArgumentException if specified height value is illegal.
     * @throws IOException if streaming error occurs.
     * @throws PresenterException if some inner error occurs.
     */
    public void writeView(int height, Writer writer)
            throws IllegalArgumentException, IOException, PresenterException {
        validateHeight(height);
        int width = -1;
        int maxWidth = getMaxWidth(height);
        boolean symmetric = false;
        for (int layer = 1; layer <= height; ++layer) {
            if (!symmetric) {
                width += 2;
                if (width > maxWidth) {
                    width = isFaceted(height) ? width - 2 : width;
                    symmetric = true;
                }
            }
            if (symmetric) {
                width -= 2;
            }
            writeViewLine(maxWidth, width, writer);
            if (layer < height) {
                writer.write(Misc.LINE_BREAK);
            }
        }
    }

    /**
     * Gets a symbol for content drawing.
     * 
     * @return content drawing symbol.
     */
    protected char getContentSymbol() {
        return Defaults.CONTENT_SYMBOL;
    }

    /**
     * Gets a symbol for canvas drawing.
     *
     * @return canvas drawing symbol.
     */
    protected char getCanvasSymbol() {
        return Defaults.CANVAS_SYMBOL;
    }

    /**
     * Creates and writes a single line of string representation of a diamond.
     *
     * @param length line length.
     * @param contentLength length of a content.
     * @param writer character output stream.
     * @throws IOException if streaming error occurs.
     */
    protected void writeViewLine(int length, int contentLength, Writer writer)
            throws IOException {
        int indent = (length - contentLength) / 2;
        char contentSymbol = getContentSymbol();
        char canvasSymbol = getCanvasSymbol();
        writeSymbolSet(canvasSymbol, indent, writer);
        writeSymbolSet(contentSymbol, contentLength, writer);
    }

    /**
     * Creates and writes a set of characters with specified length.
     *
     * @param symbol base character.
     * @param length set length.
     * @param writer character output stream.
     * @throws IOException if streaming error occurs.
     */
    protected void writeSymbolSet(char symbol, int length, Writer writer)
            throws IOException {
        for (int i = 0; i < length; ++i) {
            writer.write(symbol);
        }
    }

    /**
     * Validates diamond height value.
     *
     * @param value diamond height.
     * @throws IllegalArgumentException if diamond is not valid.
     */
    protected void validateHeight(int value) throws IllegalArgumentException {
        if (value < 1) {
            throw new IllegalArgumentException(Errors.ILLEGAL_HEIGHT);
        }
    }
}