package com.ilyagubarev.projects.miscellaneous.diamonds.core;

import java.io.IOException;
import java.io.Writer;

import com.ilyagubarev.projects.miscellaneous.diamonds.resources.Defaults;

/**
 * Enhanced implementation of diamond presenter.
 *
 * @version 1.02, 03 June 2013
 * @since 02 June 2013
 * @author Ilya Gubarev
 */
public class DiamondPresenterEnhanced extends DiamondPresenterBasic {

    /**
     * Content drawing symbol by default.
     */
    public static final char DEFAULT_CONTENT_SYMBOL = Defaults.CONTENT_SYMBOL;
    
    /**
     * Canvas drawing symbol by default.
     */
    public static final char DEFAULT_CANVAS_SYMBOL = Defaults.CANVAS_SYMBOL;
    
    /**
     * Using of rectangular canvas by default.
     */
    public static final boolean DEFAULT_RECTANGULAR_CANVAS = false;

    private char _contentSymbol;
    private char _canvasSymbol;
    private boolean _rectangularCanvas;

    /**
     * Creates a new instance of DiamondPresenterEnhanced.
     */
    public DiamondPresenterEnhanced() {
        this(DEFAULT_CONTENT_SYMBOL, DEFAULT_CANVAS_SYMBOL);
    }

    /**
     * Creates a new instance of DiamondPresenterEnhanced.
     *
     * @param contentSymbol content drawing symbol.
     * @param canvasSymbol canvas drawing symbol.
     */
    public DiamondPresenterEnhanced(char contentSymbol, char canvasSymbol) {
        this(contentSymbol, canvasSymbol, DEFAULT_RECTANGULAR_CANVAS);
    }

    /**
     * Creates a new instance of DiamondPresenterEnhanced.
     *
     * @param contentSymbol content drawing symbol.
     * @param canvasSymbol canvas drawing symbol.
     * @param rectangularCanvas using of rectangular canvas.
     */
    public DiamondPresenterEnhanced(char contentSymbol,
            char canvasSymbol, boolean rectangularCanvas) {
        super();
        _contentSymbol = contentSymbol;
        _canvasSymbol = canvasSymbol;
        _rectangularCanvas = rectangularCanvas;
    }

    @Override
    public char getContentSymbol() {
        return _contentSymbol;
    }

    @Override
    public char getCanvasSymbol() {
        return _canvasSymbol;
    }

    /**
     * Checks if using rectangular canvas.
     *
     * @return true if using rectangular canvas.
     */
    public boolean isRectangularCanvas() {
        return _rectangularCanvas;
    }

    /**
     * Sets a content drawing symbol.
     *
     * @param contentSymbol content drawing symbol.
     */
    public void setContentSymbol(char contentSymbol) {
        _contentSymbol = contentSymbol;
    }

    /**
     * Sets a canvas drawing symbol.
     *
     * @param canvasSymbol canvas drawing symbol.
     */
    public void setCanvasSymbol(char canvasSymbol) {
        _canvasSymbol = canvasSymbol;
    }

    /**
     * Sets using of rectangular canvas.
     * 
     * @param rectangularCanvas true if using rectangular canvas.
     */
    public void setRectangularCanvas(boolean rectangularCanvas) {
        _rectangularCanvas = rectangularCanvas;
    }

    @Override
    protected void writeViewLine(int length, int contentLength, Writer writer)
            throws IOException {
        super.writeViewLine(length, contentLength, writer);
        int indent = (length - contentLength) / 2;
        char canvasSymbol = getCanvasSymbol();
        if (isRectangularCanvas()) {
            writeSymbolSet(canvasSymbol, indent, writer);
        }
    }
}