package miaopp.java8.functionalinterface;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * Created by miaoping on 16/9/30.
 * java 8 date
 */
public class DateUtils {

    public static void main(String[] args) {
        //Clock
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        Instant instant = clock.instant();
        Date date = Date.from(instant);

    }
}
