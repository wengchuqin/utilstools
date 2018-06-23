package top.chuqin.utils.tools.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 *
 */
public class TimeTest {
    @Test
    public void localDateTest() {
        //当前时间
        LocalDate today = LocalDate.now();
        System.out.println("current Date is " + today);

        LocalDate birthday = LocalDate.of(1995, Month.JULY, 20);
        System.out.println("my birthday is " + birthday);
    }

    @Test
    public void localTimeTest() {
        LocalTime time = LocalTime.now();
        System.out.println("current time is " + time);

        LocalTime specificTime = LocalTime.of(12, 20, 44);
        System.out.println("specificTime is " + specificTime);
    }

    @Test
    public void localDataTimeTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("curren is " + localDateTime);  //curren is 2018-06-23T17:45:45.349

        LocalDateTime time = LocalDateTime.of(1995, 7, 20, 12, 13, 14);
        System.out.println("time is " + time);  // time is 1995-07-20T12:13:14
    }

    @Test
    public void instantTest() {
        //Current timestamp
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = " + timestamp); //Current Timestamp = 2018-06-23T09:48:15.865Z

        //Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli()); //Specific Time = 2018-06-23T09:48:15.865Z
        System.out.println("Specific Time = " + specificTime);

        //Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);  //PT720H
    }

    @Test
    public void dataApiTest() {
        LocalDate today = LocalDate.now();

        //Get the Year, check if it's leap year
        System.out.println("Year " + today.getYear() + " is Leap Year? " + today.isLeapYear());

        //Compare two LocalDate for before and after
        System.out.println("Today is before 01/01/2015? " + today.isBefore(LocalDate.of(2015, 1, 1)));

        //Create LocalDateTime from LocalDate
        System.out.println("Current Time=" + today.atTime(LocalTime.now()));

        //plus and minus operations
        System.out.println("10 days after today will be " + today.plusDays(10));
        System.out.println("3 weeks after today will be " + today.plusWeeks(3));
        System.out.println("20 months after today will be " + today.plusMonths(20));

        System.out.println("10 days before today will be " + today.minusDays(10));
        System.out.println("3 weeks before today will be " + today.minusWeeks(3));
        System.out.println("20 months before today will be " + today.minusMonths(20));

        //Temporal adjusters for adjusting the dates
        System.out.println("First date of this month= " + today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year= " + lastDayOfYear);

        Period period = today.until(lastDayOfYear);
        System.out.println("Period Format= " + period);
        System.out.println("Months remaining in the year= " + period.getMonths());

    }

    @Test
    public void dateFormatTest() {
        //Format examples
        LocalDate date = LocalDate.now();
        //default format
        System.out.println("Default format of LocalDate=" + date);
        //specific format
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

        LocalDateTime dateTime = LocalDateTime.now();
        //default format
        System.out.println("Default format of LocalDateTime=" + dateTime);
        //specific format
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp = Instant.now();
        //default format
        System.out.println("Default format of Instant=" + timestamp);

        //Parse examples
        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
                DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
        System.out.println("Default format after parsing = " + dt);
    }

}
