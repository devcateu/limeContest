package rai;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by slawek on 2015-10-08.
 */
public class SimpleMinimum {

    public static List<Integer> searchChecker(List<Point> pointList, BooleanReturnInt checker) {
        int yDm1, yD, yDd1;
        yD = pointList.get(0).getY();
        yDd1 = pointList.get(1).getY();
        int size = pointList.size();

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 2; i < size; i++) {
            yDm1 = yD;
            yD = yDd1;
            yDd1 = pointList.get(i).getY();

            if (checker.check(yDm1, yD, yDd1)) {
                result.add(i - 1);
            }
        }
        return result;
    }

    public static boolean isSecondIsSmaller(int y1, int y2) {
        return y2 < y1;
    }

    public static List<Integer> listSmallerUp(List<Integer> maximums, List<Point> points) {
        List<Integer> result = new ArrayList<Integer>();

        int size = maximums.size();
        int first, second;
        first = points.get(maximums.get(0)).getY();
        for (int i = 1; i < size; i++) {
            second = first;
            first = points.get(maximums.get(i)).getY();
            if (isSecondIsSmaller(first, second)) {
                result.add(second);
            } else {
                result.add(first);
            }
        }
        return result;
    }

    public static class DownElementChecker implements BooleanReturnInt {

        public boolean check(int y1, int y2, int y3) {
            return (y2 < y1) && (y2 < y3);
        }
    }

    public static class UpElementChecker implements BooleanReturnInt {

        public boolean check(int y1, int y2, int y3) {
            return (y2 > y1) && (y2 > y3);
        }
    }

}
