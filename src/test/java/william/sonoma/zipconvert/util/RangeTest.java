package william.sonoma.zipconvert.util;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * Created by oogie on 6/27/16.
 */
public class RangeTest {

    private Range range;

    @Before
    public void init() {
        range = new Range(9, 1);
    }

    @Test
    public void inRange() throws Exception {
        assertThat(range.withinRange(5), is(true));
    }

    @Test
    public void inLowerBoundary() throws Exception {
        assertThat(range.withinRange(1), is(true));
    }

    @Test
    public void inUpperBoundary() throws Exception {
        assertThat(range.withinRange(9), is(true));
    }

    @Test
    public void outOfLowerRange() throws Exception {
        assertThat(range.withinRange(0), is(false));
    }

    @Test
    public void outOfUpperRange() throws Exception {
        assertThat(range.withinRange(10), is(false));
    }

    @Test
    public void lowerUpperRangeSameInBoundary() {
        range = new Range(7, 7);
        assertThat(range.withinRange(7), is(true));
    }

    @Test
    public void lowerUpperRangeSameOutBoundary1() {
        range = new Range(7, 7);
        assertThat(range.withinRange(8), is(false));
    }

    @Test
    public void lowerUpperRangeSameOutBoundary2() {
        range = new Range(7, 7);
        assertThat(range.withinRange(6), is(false));
    }
}