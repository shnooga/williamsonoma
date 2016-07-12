package william.sonoma.zipconvert.util;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


/**
 * Created by oogie on 6/27/16.
 */
public class ListTransformerTest {

    private ListTransformer listTransformer;

    @Before
    public void init() {
        listTransformer = new ListTransformer();
    }

    @Test
    public void convert() throws Exception {
        List<String[]> zipRanges = new ArrayList<String[]>();

        zipRanges.add(new String[]{"1", "2"});
        zipRanges.add(new String[]{"3", "4"});
        zipRanges.add(new String[]{"5", "6"});

        List<Range> nuZipRanges = listTransformer.convertString(zipRanges);

        assertThat(nuZipRanges, hasSize(3));
        assertThat(nuZipRanges.get(0).getLower(), is(1));
        assertThat(nuZipRanges.get(0).getUpper(), is(2));
        assertThat(nuZipRanges.get(2).getLower(), is(5));
        assertThat(nuZipRanges.get(2).getUpper(), is(6));
    }
    @Test
    public void convertInteger() throws Exception {
        List<Integer[]> zipRanges = new ArrayList<Integer[]>();

        zipRanges.add(new Integer[]{1, 2});
        zipRanges.add(new Integer[]{3, 4});
        zipRanges.add(new Integer[]{5, 6});

        List<Range> nuZipRanges = listTransformer.convertInteger(zipRanges);

        assertThat(nuZipRanges, hasSize(3));
        assertThat(nuZipRanges.get(0).getLower(), is(1));
        assertThat(nuZipRanges.get(0).getUpper(), is(2));
        assertThat(nuZipRanges.get(2).getLower(), is(5));
        assertThat(nuZipRanges.get(2).getUpper(), is(6));
    }

    @Test
    public void convertBadString() throws Exception {
        List<String[]> zipRanges = new ArrayList<String[]>();

        zipRanges.add(new String[]{"X", "2"});
        zipRanges.add(new String[]{"9", "8"});
        zipRanges.add(new String[]{"5", "Y"});

        List<Range> nuZipRanges = listTransformer.convertString(zipRanges);

        assertThat(nuZipRanges, hasSize(1));
        assertThat(nuZipRanges.get(0).getLower(), is(8));
        assertThat(nuZipRanges.get(0).getUpper(), is(9));
    }

    @Test
    public void convertLargeArray() throws Exception {
        List<String[]> zipRanges = new ArrayList<String[]>();

        zipRanges.add(new String[]{"3", "4", "5"});
        zipRanges.add(new String[]{"6", "7", "9"});

        List<Range> nuZipRanges = listTransformer.convertString(zipRanges);

        assertThat(nuZipRanges, hasSize(2));
        assertThat(nuZipRanges.get(0).getLower(), equalTo(3));
        assertThat(nuZipRanges.get(0).getUpper(), equalTo(4));
        assertThat(nuZipRanges.get(1).getLower(), equalTo(6));
        assertThat(nuZipRanges.get(1).getUpper(), equalTo(7));
    }

}