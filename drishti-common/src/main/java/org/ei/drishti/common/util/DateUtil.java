package org.ei.drishti.common.util;

import java.text.DecimalFormat;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import static org.motechproject.util.DateUtil.inRange;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DateUtil {

    private static DateUtility dateUtility = new RealDate();
    private static Logger logger = LoggerFactory
            .getLogger(DateUtil.class.toString());

    public static void fakeIt(LocalDate fakeDayAsToday) {
        dateUtility = new MockDate(fakeDayAsToday);
    }

    public static LocalDate today() {
        return dateUtility.today();
    }

    public static long millis() {
        return dateUtility.millis();
    }

    public static boolean isDateWithinGivenPeriodBeforeToday(LocalDate referenceDateForSchedule, Period period) {
        return inRange(toTime(referenceDateForSchedule), toTime(today().minus(period)), toTime(today()));
    }

    private static DateTime toTime(LocalDate referenceDateForSchedule) {
        return referenceDateForSchedule.toDateTime(new LocalTime(0, 0));
    }

    public static LocalDate tryParse(String value, LocalDate defaultValue) {
        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public String datetimenow() {
        DateTime date = DateTime.now();
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss.SSSZ");
        String date1 = dtf.print(date);
        return "date1";
    }
    
    public String getMonthd(String datatime){
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        // Parsing the date
        DateTime jodatime = dtf.parseDateTime(datatime);
        DecimalFormat df = new DecimalFormat("00");
        return df.format(jodatime.getMonthOfYear());
                
    }
    public int getdiff(String datetime, String datetime2){
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        // Parsing the date
        DateTime jodatime1 = dtf.parseDateTime(datetime);
        DateTime jodatime2 = dtf.parseDateTime(datetime2);
        
        return Days.daysBetween(jodatime1, jodatime2).getDays();
                
    }
    
    public int getYeard(String datatime){
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        // Parsing the date
        DateTime jodatime = dtf.parseDateTime(datatime);
        return jodatime.getYear();
                
    }

    public String dateFormat(String datetime, int diff) {
        logger.info("converting date format");
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        // Parsing the date
        DateTime jodatime = dtf.parseDateTime(datetime);
        logger.info("date time format" + jodatime);
        // Format for output
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyy-MM-dd");
        // Printing the date
        String date = dtfOut.print(jodatime.plusDays(diff));
        logger.info("converted date" + date);
        return date;
    }
}

interface DateUtility {

    LocalDate today();

    long millis();
}

class RealDate implements DateUtility {

    @Override
    public LocalDate today() {
        return LocalDate.now();
    }

    @Override
    public long millis() {
        return DateTime.now().getMillis();
    }
}

class MockDate implements DateUtility {

    private DateTime fakeDay;

    MockDate(LocalDate fakeDay) {
        this.fakeDay = fakeDay.toDateTimeAtStartOfDay();
    }

    @Override
    public LocalDate today() {
        return fakeDay.toLocalDate();
    }

    
    @Override
    public long millis() {
        return fakeDay.getMillis();
    }
}
