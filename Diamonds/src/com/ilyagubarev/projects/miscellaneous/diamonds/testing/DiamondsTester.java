package com.ilyagubarev.projects.miscellaneous.diamonds.testing;

import java.util.Date;
import java.io.FileWriter;
import java.io.Writer;

import com.ilyagubarev.projects.miscellaneous.diamonds.core.DiamondPresenterEnhanced;

/**
 * Diamonds project tester.
 *
 * @version 1.01, 04 June 2013
 * @since 04 June 2013
 * @author Ilya Gubarev
 */
public abstract class DiamondsTester {

    /**
     * Tests diamonds presenters.
     *
     * @param height diamond height.
     * @param contentSymbol custom symbol for diamond drawing.
     * @param canvasSymbol custom symbol for canvas drawing.
     * @param useRectangleCanvas true for rectangular canvas.
     * @param outputFilename file for output (null for console).
     */
    public static void test(int height, char contentSymbol, char canvasSymbol,
            boolean useRectangleCanvas, String outputFilename) {
        try {
            DiamondPresenterEnhanced presenter = new DiamondPresenterEnhanced();
            presenter.setContentSymbol(contentSymbol);
            presenter.setCanvasSymbol(canvasSymbol);
            presenter.setRectangularCanvas(useRectangleCanvas);
            System.out.println(String.format("> creating a new diamond with height of %d...", height));
            long startTime = new Date().getTime();
            if (outputFilename == null) {
                String view = presenter.getView(height);
                System.out.println("view: ");
                System.out.println(view);
            } else {
                System.out.println(String.format("> writing view to file %s", outputFilename));
                Writer writer = new FileWriter(outputFilename);
                presenter.writeView(height, writer);
                writer.close();
            }
            long elapsedTime = new Date().getTime() - startTime;
            System.out.println("> done...");
            System.out.println("> report:");
            System.out.println(String.format("\tmax width: %d", presenter.getMaxWidth(height)));
            System.out.println(String.format("\tfaceted: %b", presenter.isFaceted(height)));
            System.out.println(String.format("\telapsed time: %d milliseconds", elapsedTime));
        } catch (Exception e) {
            System.out.println(String.format("> a following error occured: %s", e.getLocalizedMessage()));
        }
    }
}