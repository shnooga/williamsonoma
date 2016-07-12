package william.sonoma.zipconvert.util;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by oogie on 6/27/16.
 */
public class RangeCompareTest {
    private RangeCompare analyzer;

    @Before
    public void init() {
        analyzer = new RangeCompare();
    }

    @Test
    public void oneSidedOverLap() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(1, 7), new Range(6, 9));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(1));
        assertThat(ranges.get(0).getUpper(), is(9));
    }

    @Test
    public void oneSidedOverLap_swapped() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(6, 9), new Range(1, 7));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(1));
        assertThat(ranges.get(0).getUpper(), is(9));
    }

    @Test
    public void oneSidedOverLap2() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(1, 7), new Range(0, 5));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(0));
        assertThat(ranges.get(0).getUpper(), is(7));
    }

    @Test
    public void oneSidedOverLap2_swapped() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(0, 5), new Range(1, 7));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(0));
        assertThat(ranges.get(0).getUpper(), is(7));
    }

    @Test
    public void bothSideOverLap1() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(1, 7), new Range(0, 10));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(0));
        assertThat(ranges.get(0).getUpper(), is(10));
    }

    @Test
    public void bothSideOverLap1_swapped() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(0, 10), new Range(1, 7));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(0));
        assertThat(ranges.get(0).getUpper(), is(10));
    }

    @Test
    public void lowerEqualBothSideOverLap() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(0, 7), new Range(0, 10));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(0));
        assertThat(ranges.get(0).getUpper(), is(10));
    }

    @Test
    public void lowerEqualBothSideOverLap_swapped() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(0, 10), new Range(0, 7));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(0));
        assertThat(ranges.get(0).getUpper(), is(10));
    }

    @Test
    public void upperEqualBothSideOverLap() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(0, 10), new Range(1, 10));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(0));
        assertThat(ranges.get(0).getUpper(), is(10));
    }

    @Test
    public void upperEqualBothSideOverLap_swapped() throws Exception {
        List<Range> ranges = analyzer.convertOverLap(new Range(1, 10), new Range(0, 10));

        assertThat(ranges, hasSize(1));
        assertThat(ranges.get(0).getLower(), is(0));
        assertThat(ranges.get(0).getUpper(), is(10));
    }
}