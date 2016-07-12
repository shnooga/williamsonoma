package william.sonoma.zipconvert.util;

import java.util.ArrayList;
import java.util.List;

/**
 * This class facilitates the conversion of various input ranges (String, Integer) to a Range object
 *
 * Created by oogie on 6/27/16.
 */
public class ListTransformer {


    public List<Range> convertString(List<String[]> zipRanges) {
        List<Range>  ranges = new ArrayList<Range>();


        for(String[] zips : zipRanges) {
            try {
                ranges.add(new Range(Integer.valueOf(zips[0]), Integer.valueOf(zips[1])));
            } catch (Exception e) {
                e.printStackTrace();
                // continue on.
            }
        }
        return ranges;
    }

    public List<Range> convertInteger(List<Integer[]> zipRanges) {
        List<Range>  ranges = new ArrayList<Range>();


        for(Integer[] zips : zipRanges) {
            try {
                ranges.add(new Range(zips[0], zips[1]));
            } catch (Exception e) {
                e.printStackTrace();
                // continue on.
            }
        }
        return ranges;
    }


}
