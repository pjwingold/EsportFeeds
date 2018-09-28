package au.com.pjwin.esportfeeds.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static final DateFormat PARSE_FEED_DATE = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());

    public static String formatFeedDate(Date feedDate) {
        return format(PARSE_FEED_DATE, feedDate);
    }

    private static String format(DateFormat dateFormat, Date date) {
        return date != null ? dateFormat.format(date) : null;
    }
}
