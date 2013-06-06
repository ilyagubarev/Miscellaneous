package com.ilyagubarev.projects.miscellaneous.diamonds.testing;

import java.util.Date;
import java.io.FileWriter;
import java.io.Writer;

import com.ilyagubarev.projects.miscellaneous.diamonds.core.DiamondPresenterEnhanced;

/**
 *
 * @author gubarev
 */
public abstract class DiamondsTester {

    /**
     *
     *
     * @param height
     * @param contentSymbol
     * @param canvasSymbol
     * @param useRectangleCanvas
     * @param outputFilename
     */
    public static void test(int height, char contentSymbol, char canvasSymbol,
            boolean useRectangleCanvas, String outputFilename) {
        try {
            DiamondPresenterEnhanced presenter = new DiamondPresenterEnhanced();
            presenter.setContentSymbol(contentSymbol);
            presenter.setCanvasSymbol(canvasSymbol);
            presenter.setRectangularCanvas(useRectangleCanvas);
            System.out.print("> creating a new diamond with height of ");
            System.out.print(height);
            System.out.println("...");
            long startTime = new Date().getTime();
            if (outputFilename == null) {
                String view = presenter.getView(height);
                System.out.println("view: ");
                System.out.println(view);
            } else {
                System.out.print("> writing view to file ");
                System.out.println(outputFilename);
                Writer writer = new FileWriter(outputFilename);
                presenter.writeView(height, writer);
                writer.close();
            }
            long elapsedTime = new Date().getTime() - startTime;
            System.out.println("> done...");
            System.out.print("max width: ");
            System.out.println(presenter.getMaxWidth(height));
            System.out.print("sharpen: ");
            System.out.println(presenter.isFaceted(height));
            System.out.print("elapsed time: ");
            System.out.print(elapsedTime);
            System.out.println(" milliseconds...");
        } catch (Exception e) {
            System.out.print("> a following error occured: ");
            System.out.println(e.getLocalizedMessage());
        }
    }
}