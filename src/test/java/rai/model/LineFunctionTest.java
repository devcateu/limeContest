package rai.model;

import org.junit.Assert;
import org.junit.Test;
import rai.Main;

/**
 * Created by slawek on 2015-10-13.
 */
public class LineFunctionTest {


    @Test
    public void testGettersAandB_sample1_countX() throws Exception {
        LineFunction lineFunction = new LineFunction(2, 4, 2, 4);
        Assert.assertEquals(lineFunction.getA(), 1, Main.PRECISION);
        Assert.assertEquals(lineFunction.getB(), 0, Main.PRECISION);

        Assert.assertEquals(lineFunction.countX(4), 4, Main.PRECISION);
        Assert.assertEquals(lineFunction.countX(6), 6, Main.PRECISION);
    }


    @Test
    public void testGettersAandB_sample2_countY() throws Exception {
        LineFunction lineFunction = new LineFunction(2, 4, 4, 2);
        Assert.assertEquals(lineFunction.getA(), -1, Main.PRECISION);
        Assert.assertEquals(lineFunction.getB(), 6, Main.PRECISION);

        Assert.assertEquals(lineFunction.countY(4), 2, Main.PRECISION);
        Assert.assertEquals(lineFunction.countY(6), 0, Main.PRECISION);
        Assert.assertEquals(lineFunction.countY(9), -3, Main.PRECISION);

    }
}