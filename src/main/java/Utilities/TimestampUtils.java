package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampUtils {
    private TimestampUtils() {
    }

    public static String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    }
}
