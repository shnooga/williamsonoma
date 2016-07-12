package william.sonoma.zipconvert.util;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class that house the sort algorithm
 *
 * Created by oogie on 6/28/16.
 */
public class RangeSorter {
    private final RangeCompare rangeCompare = new RangeCompare();

    /**
     * Recursive method that will merged overlap ranges.
     *
     * @param ranges
     * @return
     */
    public List<Range> execute(List<Range> ranges) {
        List<Range> nuRanges = sort(ranges);

        if(nuRanges.size() < ranges.size())
            nuRanges = execute(nuRanges);
        return nuRanges;
    }

    private List<Range> sort(List<Range> ranges) {
        for(int i=0; i < ranges.size(); i++) {
            List<Range> nuRanges = new ArrayList<Range>();

            for(int j=0; j < ranges.size(); j++) {

                if (i == j)
                    continue;
                List<Range> comparedRanges = convertOverLap(ranges.get(i), ranges.get(j));
                if (comparedRanges.size() == 1) {
                    nuRanges.add(comparedRanges.get(0));
                    nuRanges.addAll(ranges.subList(j+1, ranges.size()));
                    return nuRanges;
                }
                nuRanges.add(ranges.get(j));
            }
            nuRanges.add(ranges.get(i));
        }
        return ranges;
    }

    private List<Range> convertOverLap(Range range1, Range range2) {
        return rangeCompare.convertOverLap(range1, range2);
    }
}
