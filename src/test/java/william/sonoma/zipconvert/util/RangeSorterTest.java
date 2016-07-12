package william.sonoma.zipconvert.util;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by oogie on 6/28/16.
 */
public class RangeSorterTest {
    private RangeSorter rangeSorter;

    @Before
    public void init() {
        rangeSorter = new RangeSorter();
    }

    @Test
    public void doubleSidedOverlap1() throws Exception {
        List<Range> ranges = createRanges(new Range(1, 7), new Range(0,10), new Range(22, 25), new Range(44, 45));
        List<Range> sortedRanges = rangeSorter.execute(ranges);

        assertThat(sortedRanges, hasSize(3));
        assertThat(sortedRanges.get(0).getLower(), is(0));
        assertThat(sortedRanges.get(0).getUpper(), is(10));
        assertThat(sortedRanges.get(1).getLower(), is(22));
        assertThat(sortedRanges.get(1).getUpper(), is(25));
    }

    @Test
    public void doubleSidedOverlap2() throws Exception {
        List<Range> ranges = createRanges(new Range(0,10), new Range(22, 25), new Range(44, 45), new Range(1, 7));
        List<Range> sortedRanges = rangeSorter.execute(ranges);

        assertThat(sortedRanges, hasSize(3));
        assertThat(sortedRanges.get(0).getLower(), is(22));
        assertThat(sortedRanges.get(0).getUpper(), is(25));
        assertThat(sortedRanges.get(2).getLower(), is(0));
        assertThat(sortedRanges.get(2).getUpper(), is(10));
    }
    
    @Test
    public void doubleSidedOverlapTwice() throws Exception {
        List<Range> ranges = createRanges(new Range(0,10), new Range(22, 47), new Range(44, 45), new Range(1, 7));
        List<Range> sortedRanges = rangeSorter.execute(ranges);

        assertThat(sortedRanges, hasSize(2));
        assertThat(sortedRanges.get(0).getLower(), is(22));
        assertThat(sortedRanges.get(0).getUpper(), is(47));
        assertThat(sortedRanges.get(1).getLower(), is(0));
        assertThat(sortedRanges.get(1).getUpper(), is(10));
    }

    @Test
    public void entireOverlap() throws Exception {
        List<Range> ranges = createRanges(new Range(1, 7), new Range(6, 9), new Range(0, 100), new Range(44, 45));
        List<Range> sortedRanges = rangeSorter.execute(ranges);

        assertThat(sortedRanges, hasSize(1));
        assertThat(sortedRanges.get(0).getLower(), is(0));
        assertThat(sortedRanges.get(0).getUpper(), is(100));
    }

    @Test
    public void oneSidedOverLap1() throws Exception {
        List<Range> ranges = createRanges(new Range(1, 7), new Range(6, 9), new Range(22, 25), new Range(44, 45));
        List<Range> sortedRanges = rangeSorter.execute(ranges);

        assertThat(sortedRanges, hasSize(3));
        assertThat(sortedRanges.get(0).getLower(), is(1));
        assertThat(sortedRanges.get(0).getUpper(), is(9));
        assertThat(sortedRanges.get(1).getLower(), is(22));
        assertThat(sortedRanges.get(1).getUpper(), is(25));
    }

    @Test
    public void oneSidedOverLap1_swapped() throws Exception {
        List<Range> ranges = createRanges(new Range(6, 9), new Range(1, 7), new Range(22, 25), new Range(44, 45));
        List<Range> sortedRanges = rangeSorter.execute(ranges);

        assertThat(sortedRanges, hasSize(3));
        assertThat(sortedRanges.get(0).getLower(), is(1));
        assertThat(sortedRanges.get(0).getUpper(), is(9));
        assertThat(sortedRanges.get(1).getLower(), is(22));
        assertThat(sortedRanges.get(1).getUpper(), is(25));
    }

    @Test
    public void oneSidedOverLap2() throws Exception {
        List<Range> ranges = createRanges(new Range(22, 25), new Range(1, 7), new Range(6, 9), new Range(44, 45));
        List<Range> sortedRanges = rangeSorter.execute(ranges);

        assertThat(sortedRanges, hasSize(3));
        assertThat(sortedRanges.get(0).getLower(), is(22));
        assertThat(sortedRanges.get(0).getUpper(), is(25));
        assertThat(sortedRanges.get(1).getLower(), is(1));
        assertThat(sortedRanges.get(1).getUpper(), is(9));
    }


    @Test
    public void oneSidedOverLapTwice() throws Exception {
        List<Range> ranges = createRanges(new Range(22, 46), new Range(1, 7), new Range(6, 9), new Range(44, 45));
        List<Range> sortedRanges = rangeSorter.execute(ranges);

        assertThat(sortedRanges, hasSize(2));
        assertThat(sortedRanges.get(0).getLower(), is(1));
        assertThat(sortedRanges.get(0).getUpper(), is(9));
        assertThat(sortedRanges.get(1).getLower(), is(22));
        assertThat(sortedRanges.get(1).getUpper(), is(46));
    }

    private List<Range> createRanges(Range... ranges) {
        List<Range> rangeList = new ArrayList<Range>();
        for(Range range : ranges) {
            rangeList.add(range);
        }
        return rangeList;
    }
}