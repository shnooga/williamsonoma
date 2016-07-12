package william.sonoma.zipconvert.util;

/**
 *
 * Data storage class that represent a comparison object.
 *
 * Created by oogie on 6/27/16.
 */
public class Range {
    private int upper = 0;
    private int lower = 0;

    public Range(int val1, int val2) {
        upper = (val1 >= val2) ? val1 : val2;
        lower = (val1 >= val2) ? val2 : val1;
    }

    public Range() {
    }

    public int getUpper() {
        return upper;
    }

    public int getLower() {
        return lower;
    }

    public boolean withinRange(int value) {
        return (value <= upper) && (value >= lower);
    }
}
