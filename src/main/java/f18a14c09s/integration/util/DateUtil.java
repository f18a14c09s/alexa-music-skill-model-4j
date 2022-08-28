package f18a14c09s.integration.util;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateUtil {
    public static String formatAsIso8601UtcSeconds(Calendar date) {
        return newIso8601UtcDateFormatSeconds().format(date.getTime());
    }

    public static String formatAsIso8601Utc(Calendar date) {
        return newIso8601UtcDateFormat().format(date.getTime());
    }

    public static String formatAsIso8601Utc(ZonedDateTime date) {
        return newIso8601UtcDateFormatter().format(date);
    }

    public static String parseAsIso8601Utc(Calendar date) {
        return newIso8601UtcDateFormat().format(date.getTime());
    }

    private static SimpleDateFormat newIso8601UtcDateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat;
    }

    private static DateTimeFormatter newIso8601UtcDateFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX").withZone(
                TimeZone.getTimeZone("UTC").toZoneId()
        );
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//        return dateFormat;
    }

    private static SimpleDateFormat newIso8601UtcDateFormatSeconds() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat;
    }
}
