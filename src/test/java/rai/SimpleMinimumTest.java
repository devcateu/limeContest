package rai;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by slawek on 2015-10-08.
 */
public class SimpleMinimumTest {

    @Test
    public void testIsDownElement() {
        BooleanReturnInt down = new SimpleMinimum.DownElementChecker();
        assertEquals(down.check(4, 3, 5), true);
        assertEquals(down.check(4, 5, 6), false);
        assertEquals(down.check(6, 5, 4), false);
        assertEquals(down.check(4, 5, 4), false);
    }


    @Test
    public void testIsUpElement() {
        BooleanReturnInt up = new SimpleMinimum.UpElementChecker();
        assertEquals(up.check(4, 3, 5), false);
        assertEquals(up.check(4, 5, 6), false);
        assertEquals(up.check(6, 5, 4), false);
        assertEquals(up.check(4, 5, 4), true);
    }

    @Test
    public void testSearchMinimums_1() {
        List<Point> pointList = Arrays.asList(new Point(0, 0), new Point(3, 4), new Point(7, -1), new Point(10, 5), new Point(11, 4));
        List<Integer> results = SimpleMinimum.searchChecker(pointList, new SimpleMinimum.DownElementChecker());

        assertEquals(results, Arrays.asList(2));
    }

    @Test
    public void testSearchMinimums_PaulinaCase() {
        List<Point> pointList = Arrays.asList(new Point(0, 0), new Point(7, -1), new Point(10, 5), new Point(11, 4));
        List<Integer> results = SimpleMinimum.searchChecker(pointList, new SimpleMinimum.DownElementChecker());

        assertEquals(results, Arrays.asList(1));
    }

    @Test
    public void testSearchChecker_testUp() {
        List<Point> pointList = Arrays.asList(new Point(0, 0), new Point(3, 4), new Point(7, -1), new Point(10, 5), new Point(11, 4));
        List<Integer> results = SimpleMinimum.searchChecker(pointList, new SimpleMinimum.UpElementChecker());

        assertEquals(results, Arrays.asList(1, 3));
    }

    @Test
    public void testListSmallerUp() {
        List<Point> pointList = Arrays.asList(new Point(0, 0), new Point(3, 4), new Point(7, -1), new Point(10, 5), new Point(11, 4));
        //List<Integer> results = SimpleMinimum.listSmallerUp(pointList);

        //  assertEquals(results, Arrays.asList(1, 3));
    }
}
