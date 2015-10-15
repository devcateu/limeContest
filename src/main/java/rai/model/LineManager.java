package rai.model;

import java.util.HashMap;

/**
 * Created by slawek on 2015-10-13.
 */
public class LineManager {

    private HashMap<String, LineFunction> map = new HashMap<String, LineFunction>();

    public LineFunction createLineFunction(double x1, double y1, double x2, double y2) {
        double a = countA(x1, y1, x2, y2);
        double b = countB(x1, y1, a);
        String.format("%1.8f _ %2.8f");
        String lookup = a + "_" + b;

        LineFunction lineFunction = map.get(lookup);
        if (lineFunction == null) {
            lineFunction = new LineFunction(a, b);
            map.put(lookup, lineFunction);
        }

        return lineFunction;
    }

    private double countA(double x1, double y1, double x2, double y2) {
        return (x1 - x2) / (y1 - y2);
    }

    private double countB(double x1, double y1, double a) {
        return y1 - a * x1;
    }
}
