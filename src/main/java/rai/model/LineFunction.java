package rai.model;

/**
 * Created by slawek on 2015-10-12.
 */
public class LineFunction {
  private double a, b;

  public LineFunction(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double countY(double x) {
    return a * x + b;
  }

  public double countX(double y) {
    return (y - b) / a;
  }

  public double getA() {
    return a;
  }

  public double getB() {
    return b;
  }
}
