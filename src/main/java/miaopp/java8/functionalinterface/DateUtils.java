package miaopp.java8.functionalinterface;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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
        System.out.println(date);
        //Timezones(时区)
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());//ZoneRules[currentStandardOffset=+01:00]
        System.out.println(zone2.getRules());//ZoneRules[currentStandardOffset=-03:00]
        //LocalTime(本地时间)
        LocalTime time1 = LocalTime.now(zone1);
        LocalTime time2 = LocalTime.now(zone2);
        System.out.println(time1.isBefore(time2));
        long hoursBetween = ChronoUnit.HOURS.between(time1, time2);
        long minutesBetween = ChronoUnit.MINUTES.between(time1, time2);
        System.out.println(hoursBetween);
        System.out.println(minutesBetween);
    }
}
