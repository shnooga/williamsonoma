package william.sonoma.zipconvert.util;


import java.util.ArrayList;
import java.util.List;

/**
 * This class only exists to facilitate comparsion of 2 Range instance.
 *
 * Created by oogie on 6/27/16.
 */
public class RangeCompare {

    /**
     * This will return a list with one Range element if there is overlap;
     * Otherwise it will return a list with 2 Range Elements
     * @param range1
     * @param range2
     * @return
     */
    public List<Range> convertOverLap(Range range1, Range range2) {
        List<Range> ranges = new ArrayList<Range>();

        if (range1.withinRange(range2.getLower()) && range2.withinRange(range1.getUpper())) {
            ranges.add(new Range(range1.getLower(), range2.getUpper()));
        } else if (range2.withinRange(range1.getLower()) && range1.withinRange(range2.getUpper())) {
            ranges.add(new Range(range2.getLower(), range1.getUpper()));
        } else if (hasDoubleOverLap(range1, range2)) {
            ranges.add( range1.getLower() >= range2.getLower() ? range2 : range1);
        } else {
            ranges.add(range1);
            ranges.add(range2);
        }
        return ranges;
    }

    private boolean hasDoubleOverLap(Range range1, Range range2) {
        return
                (range2.getLower() <= range1.getLower() && range2.getUpper() >= range1.getUpper()) ||

                        (range1.getLower() <= range2.getLower() && range1.getUpper() >= range2.getUpper());
    }
}


