package au.com.pjwin.esportfeeds;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import au.com.pjwin.commonlib.Common;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


public class TestDateFormat extends BaseTest {

    @Test
    public void testFormatDate() {
        String dtStr = "2018-09-22T23:52:16.290+00:00";
        SimpleDateFormat df = new SimpleDateFormat(Common.getConfig().sourceDateFormat(), Locale.getDefault());

        Date result = null;
        try {
            result = df.parse(dtStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertNotNull(result);
        assertThat("time ", result.getTime(), greaterThan(0L));
    }
}
