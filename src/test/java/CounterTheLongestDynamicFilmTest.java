import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by slawek on 2015-09-29.
 */
public class CounterTheLongestDynamicFilmTest {
    @Test
    public void whenPutOnlyDynamicReturnEachNumber() {
        String scene = "DDDDD";
        Assert.assertEquals(CounterTheLongestDynamicFilm.count(9, scene), scene.length());
    }

    @Test
    public void whenMix() {
        String scene = "DDSSDD";
        int cuts = 1;
        Assert.assertEquals(CounterTheLongestDynamicFilm.count(cuts, scene), 4);
    }

    @Test
    public void whenMix1234() {
        String scene = "DSDDSDSDSD";
        int cuts = 3;
        Assert.assertEquals(CounterTheLongestDynamicFilm.count(cuts, scene), 4);
    }

    @Test
    public void whenMix2() {
        String scene = "DSDSSDSD";
        int cuts = 1;
        Assert.assertEquals(CounterTheLongestDynamicFilm.count(cuts, scene), 2);
    }

    @Test
    public void whenMix3() {
        String scene = "SDDSSDDS";
        int cuts = 2;
        Assert.assertEquals(CounterTheLongestDynamicFilm.count(cuts, scene), 4);
    }

    @Test
    public void whenMix4() {
        String scene = "DDDSDDDDSSDSDDD";
        int cuts = 1;
        Assert.assertEquals(CounterTheLongestDynamicFilm.count(cuts, scene), 6);
    }

    @Test
    public void testSearchMaxIndex() {
        int result = CounterTheLongestDynamicFilm.searchMaxIndex(Arrays.asList(1, 2, 1));
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testSearchMaxIndexFavoriteFirst() {
        int result = CounterTheLongestDynamicFilm.searchMaxIndex(Arrays.asList(2, 2, 1));
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testSearchMaxIndexFavoriteLastMoreThanFirst() {
        int result = CounterTheLongestDynamicFilm.searchMaxIndex(Arrays.asList(2, 2, 2));
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testCreateListOfD() {
        String scene = "DDSDSDD";
        List<Integer> dList = CounterTheLongestDynamicFilm.createListOfD(scene);
        assertEquals(dList, Arrays.asList(2, 1, 2));
    }

    @Test
    public void testCreateListOfD3() {
        String scene = "SDDSDSDDS";
        List<Integer> dList = CounterTheLongestDynamicFilm.createListOfD(scene);
        assertEquals(dList, Arrays.asList(0, 2, 1, 2, 0));
    }

    @Test
    public void testCreateListOfD2() {
        String scene = "DDDDSSDDSSSDD";
        List<Integer> dList = CounterTheLongestDynamicFilm.createListOfD(scene);
        assertEquals(dList, Arrays.asList(4, 2, 2));
    }
}