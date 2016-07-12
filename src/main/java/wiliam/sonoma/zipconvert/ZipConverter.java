package wiliam.sonoma.zipconvert;

import william.sonoma.zipconvert.util.ListTransformer;
import william.sonoma.zipconvert.util.Range;
import william.sonoma.zipconvert.util.RangeSorter;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo console app that leverages a RangeSorter instance to do all the conversion.
 *
 * Created by oogie on 6/28/16.
 */
public class ZipConverter {

    public static void main(String[] args) {

        /*
        If the input = [94133,94133] [94200,94299] [94600,94699]
        Then the output should be = [94133,94133] [94200,94299] [94600,94699]

        If the input = [94133,94133] [94200,94299] [94226,94399]
        Then the output should be = [94133,94133] [94200,94399]
        */

        RangeSorter sorter = new RangeSorter();
        List<Range> inputRanges = createRanges(new Integer[]{94133, 94133}, new Integer[]{94200, 94299}, new Integer[]{94600, 94699});
        List<Range> sortedRanges = sorter.execute(inputRanges);

        log("\n\n##### Input ####", inputRanges);
        log("##### Sorted Output ####", sortedRanges);

        inputRanges = createRanges(new String[]{"94133", "94133"}, new String[]{"94200", "94299"}, new String[]{"94226", "94399"});
        sortedRanges = sorter.execute(inputRanges);

        log("\n\n##### Input ####", inputRanges);
        log("##### Sorted Output ####", sortedRanges);
    }

    private static void log(String title, List<Range> ranges) {
        System.out.println(title);
        for(Range range : ranges) {
            System.out.println("[" + range.getLower() + ", [" + range.getUpper() + "]");
        }
    }
    private static List<Range> createRanges(String[]... ranges) {
        List<String[]>  inputRanges = new ArrayList<String[]>();
        for(String[] range : ranges) {
            inputRanges.add(range);
        }
        ListTransformer transformer = new ListTransformer();
        return transformer.convertString(inputRanges);
    }

    private static List<Range> createRanges(Integer[]... ranges) {
        List<Integer[]>  inputRanges = new ArrayList<Integer[]>();
        for(Integer[] range : ranges) {
            inputRanges.add(range);
        }
        ListTransformer transformer = new ListTransformer();
        return transformer.convertInteger(inputRanges);
    }

}
