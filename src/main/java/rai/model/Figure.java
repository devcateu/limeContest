package rai.model;

/**
 * Created by slawek on 2015-10-12.
 */
public class Figure {
    private final double xUpLeft, xDownLeft, xUpRight, xDownRight, yUp, yDown;
    private final LineFunction leftWall, rightWall;
    private final Figure childLeft, childRight;
    private double restCapacity;

    public Figure(double xUpLeft, double xDownLeft, double xUpRight, double xDownRight, double yUp, double yDown, Figure childLeft, Figure childRight) {
        leftWall = new LineFunction(xUpLeft, xDownLeft, yUp, yDown);
        rightWall = new LineFunction(xUpRight, xDownRight, yUp, yDown);
        this.xUpLeft = xUpLeft;
        this.xDownLeft = xDownLeft;
        this.xUpRight = xUpRight;
        this.xDownRight = xDownRight;
        this.yUp = yUp;
        this.yDown = yDown;
        this.childRight = childRight;
        this.childLeft = childLeft;
        countCapacity();

    }

    public static Figure buildTriangle(double xUpLeft, double xDown, double xUpRight, double yDown, double yUp) {
        return new Figure(xUpLeft, xDown, xUpRight, xDown, yUp, yDown, FigureManager.getEmptyFigure(), FigureManager.getEmptyFigure());
    }

    private void countCapacity() {
        restCapacity = ((xUpRight - xUpLeft) + (xDownRight - xDownLeft)) * (yUp - yDown) / 2;
    }

    public RainPosition rainPosition(double x) {
        if (x < xUpLeft) {
            return RainPosition.OnTheLeft;
        } else if (x >= xUpRight) {
            return RainPosition.OnTheRight;
        } else {
            return RainPosition.Over;
        }
    }

    public boolean isFull() {
        return 0.0 == restCapacity;
    }

    public double rainOver(double rainCapacity, double x) {
        if (isFull()) {
            return rainCapacity;
        }
        if (rainCapacity == 0) {
            return 0;
        }

        RainPosition leftChildRainPosition = childLeft.rainPosition(x);
        RainPosition rightChildRainPosition = childRight.rainPosition(x);

        if (leftChildRainPosition != RainPosition.OnTheRight) {
            rainCapacity = childLeft.rainOver(rainCapacity, x);
        }
        if (rightChildRainPosition != RainPosition.OnTheLeft) {
            rainCapacity = childRight.rainOver(rainCapacity, x);
        }
        if (rainCapacity == 0) {
            return 0;
        }
        rainCapacity = childLeft.rainOver(rainCapacity, x);
        rainCapacity = childRight.rainOver(rainCapacity, x);


        if (restCapacity >= rainCapacity) {
            restCapacity -= rainCapacity;
            return 0;
        } else {
            double result = rainCapacity - restCapacity;
            restCapacity = 0;
            return result;
        }
    }


}
