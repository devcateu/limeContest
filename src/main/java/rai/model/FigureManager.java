package rai.model;

/**
 * Created by slawek on 2015-10-13.
 */
public class FigureManager {

    private final static Figure emptyFigure = new Figure(0, 0, 0, 0, 0, 0, null, null);

    public static Figure getEmptyFigure() {
        return emptyFigure;
    }
}
