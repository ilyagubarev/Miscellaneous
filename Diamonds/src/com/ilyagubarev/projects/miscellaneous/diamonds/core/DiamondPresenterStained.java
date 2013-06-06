package com.ilyagubarev.projects.miscellaneous.diamonds.core;

import java.io.IOException;
import java.io.Writer;
import java.util.Stack;

/**
 * Implementation of stained diamond presenter.
 *
 * @version 1.01, 05 June 2013
 * @since 05 June 2013
 * @author Ilya Gubarev
 */

public class DiamondPresenterStained extends DiamondPresenterEnhanced {

    private char[] _contentSymbols;

    /**
     * Creates a new instance of DiamondPresenterStained.
     */
    public DiamondPresenterStained() {
        super();
    }

    /**
     * Creates a new instance of DiamondPresenterStained.
     *
     * @param contentSymbol content drawing symbol.
     * @param canvasSymbol canvas drawing symbol.
     */
    public DiamondPresenterStained(char contentSymbol, char canvasSymbol) {
        super(contentSymbol, canvasSymbol);
    }

    /**
     * Creates a new instance of DiamondPresenterStained.
     *
     * @param contentSymbol content drawing symbol.
     * @param canvasSymbol canvas drawing symbol.
     * @param rectangularCanvas using of rectangular canvas.
     */
    public DiamondPresenterStained(char contentSymbol, char canvasSymbol,
            boolean rectangularCanvas) {
        super(contentSymbol, canvasSymbol, rectangularCanvas);
    }

    /**
     * Gets a set of symbols for content drawing (default if null or empty).
     *
     * @return characters array.
     */
    public char[] getContentSymbols() {
        if ((_contentSymbols == null) || (_contentSymbols.length == 0)) {
            _contentSymbols = createSymbols(getContentSymbol());
        }
        return _contentSymbols;
    }

    @Override
    public void setContentSymbol(char contentSymbol) {
        super.setContentSymbol(contentSymbol);
        setContentSymbols(null);
    }

    /**
     * Sets a new set of symbols for content drawing.
     *
     * @param contentSymbols characters array.
     */
    public void setContentSymbols(char[] contentSymbols) {
        _contentSymbols = contentSymbols;
    }

    @Override
    protected void writeViewLine(int length, int contentLength, Writer writer)
            throws IOException {
        int indent = (length - contentLength) / 2;
        char canvasSymbol = getCanvasSymbol();
        char[] contentSymbols = getContentSymbols();
        writeSymbolSet(canvasSymbol, indent, writer);
        writeSymbolSet(contentSymbols, contentLength, writer);
        if (isRectangularCanvas()) {
            writeSymbolSet(canvasSymbol, indent, writer);
        }
    }

    /**
     * Creates and writes a set of characters with specified length.
     *
     * @param symbols characters array.
     * @param length set length.
     * @param writer character output stream.
     * @throws IOException if streaming error occurs.
     */
    protected void writeSymbolSet(char[] symbols, int length, Writer writer)
            throws IOException {
        int symbolPointer = 0;
        Stack<Character> symbolsStack = new Stack<Character>();
        for (int i = 1; i <= length; ++i) {
            if (i <= length / 2 + 1) {
                char symbol = symbols[symbolPointer++];
                if (symbolPointer == symbols.length) {
                    symbolPointer = 0;
                }
                writer.write(symbol);
                if (i < length / 2 + 1) {
                    symbolsStack.push(symbol);
                }
            } else {
                writer.write(symbolsStack.pop());
            }
        }
    }

    /**
     * Creates a new array of specified character.
     * 
     * @param symbol a character.
     * @return characters array.
     */
    protected char[] createSymbols(char symbol) {
        return new char[] { symbol };
    }
}