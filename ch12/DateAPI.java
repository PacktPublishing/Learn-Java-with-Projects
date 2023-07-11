package ch12;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DateAPI {
    public static void main(String[] args) {
//        datesTimes();
//        zonedExamples();
//        periodDuration();
//        predefinedFormats();
        customFormats();
    }
    public static void datesTimes(){
        LocalDate nowDate = LocalDate.now(); // get current date from system clock
        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDateTime2 = LocalDateTime.now();   // one way
        LocalDateTime nowDateTime = LocalDateTime.of(nowDate, nowTime);// another way
        System.out.println(nowDateTime);// 2023-07-09T13:28:00.322907600

        // Setting St. Patricks Day, 2025
        LocalDate ld1 = LocalDate.of(2025, 3, 17);// one way
        LocalDate ld2 = LocalDate.parse("2025-03-17");// another way
        System.out.println(ld2.getDayOfWeek());// MONDAY
        LocalDate ld3 = ld2.withMonth(5);
        System.out.println(ld3);// 2025-05-17
        LocalDate ld4 = ld3.plusYears(1);
        System.out.println(ld4);// 2026-05-17
        LocalDate ld5 = ld4.minusDays(5);
        System.out.println(ld5);// 2026-05-12
        LocalDateTime ldt1 = ld5.atTime(13, 45, 10);
        System.out.println(ldt1);// 2026-05-12T13:45:10

    }
    public static void zonedExamples(){
        LocalDateTime flightDepTime  = LocalDateTime.of(2023,
                                                        Month.NOVEMBER,
                                                        24,
                                                        13,
                                                        00);
        ZonedDateTime flightDepTimeZ = flightDepTime.atZone(ZoneId.of("Europe/Dublin"));
        System.out.println(flightDepTimeZ);// 2023-11-24T13:00Z[Europe/Dublin]

        ZonedDateTime arrivalTimeZ  =
                flightDepTimeZ.withZoneSameInstant(ZoneId.of("Europe/Paris"))
                        .plusHours(1)
                        .plusMinutes(45);

        System.out.println(arrivalTimeZ); // 2023-11-24T15:45+01:00[Europe/Paris]
        System.out.println(arrivalTimeZ.getHour()+":"+arrivalTimeZ.getMinute()); // 15:45


    }
    public static void periodDuration(){
        // Period
        LocalDate startDate = LocalDate.of(1861, 4, 12);
        LocalDate endDate   = LocalDate.of(1865, 4, 9);
        Period howLongP     = Period.between(startDate,endDate);
        System.out.println(howLongP);            // P3Y11M28D, weeks not represented
        System.out.println(howLongP.getYears()); // 3
        System.out.println(howLongP.getMonths());// 11
        System.out.println(howLongP.getDays());  // 28

        // Duration
        LocalTime lt1 = LocalTime.of(12,0, 20);
        LocalTime lt2 = LocalTime.of(14,45, 40);
        Duration howLongD2 = Duration.between(lt1, lt2);
        System.out.println(howLongD2);// PT2H45M20S
    }
    
    public static void predefinedFormats(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        System.out.println(date.format(isoDate));       // 2023-07-10
        DateTimeFormatter fullDateStyle =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(date.format(fullDateStyle));  // Monday 10 July 2023

        LocalTime time = LocalTime.now();
        DateTimeFormatter isoTime = DateTimeFormatter.ISO_TIME;
        System.out.println(time.format(isoTime));           // 15:47:13.3961956
        DateTimeFormatter shortTimeStyle =
                DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(time.format(shortTimeStyle));    // 15:47
    }

    public static void customFormats(){
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);      // 2023-07-11T09:05:50.792542600+01:00[Europe/Dublin]
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yy-MMM-dd E D");
        System.out.println(zdt.format(dateFormatter));// 23-Jul-11 Tue 192

        DateTimeFormatter timeFormatter1 = DateTimeFormatter.ofPattern("hh:mm:ss a z G");
        System.out.println(zdt.format(timeFormatter1));// 09:05:50 a.m. IST AD

        // how to insert text
        DateTimeFormatter dateFormatter2 =
                DateTimeFormatter.ofPattern("'Year: 'yyyy'. Month: 'MMMM'. Day: 'dd'.'");
        System.out.println(zdt.format(dateFormatter2));// Year: 2023. Month: July. Day: 11.

        // parse
        String dateTimeString = "2023-07-10 22:10"; // last night
        DateTimeFormatter timeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime ldt = LocalDateTime.parse(dateTimeString, timeFormatter2);
        System.out.println(ldt);    // 2023-07-10T22:10

    }
    public static void dtf(){
        // Creating a date and time in a string and then telling LocalDateTime
        // how to parse the string using a DateTimeFormatter
        String stPatricksDayTimeStr = "2022-03-17 20:13";
        DateTimeFormatter formatter = // MM = month; HH = hours in 24hr clock; mm = minutes
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime stPatricksDayTime = LocalDateTime.parse(stPatricksDayTimeStr, formatter);
        // Output:  St. Patricks Day: 2022-03-17T20:13
        System.out.println("St. Patricks Day: "+stPatricksDayTime);
    }
}
/* Save
        System.out.println(ld2.getDayOfMonth());// 17
        System.out.println(ld2.isLeapYear());// false
        LocalDate ld3 = ld2.withDayOfMonth(25);
        System.out.println(ld3);// 2025-03-25
        LocalDate ld4 = ld3.plusDays(2);
        System.out.println(ld4);// 2025-03-27
        LocalDate ld5 = ld4.minusMonths(2);
        System.out.println(ld5);// 2025-01-27
        LocalDateTime ldt1 = ld5.atTime(13, 45, 10);
        System.out.println(ldt1);// 2025-01-27T13:45:10

        LocalDate weddingAnniversary  = LocalDate.of(2025, 12, 27);
        Period warning1         = Period.ofDays(30);
        Period warning2         = Period.ofWeeks(1);
        LocalDate reminder1     = weddingAnniversary.minus(warning1);
        LocalDate reminder2     = weddingAnniversary.minus(warning2);
        System.out.println(warning1);  // Period = P30D
        System.out.println(warning2);  // Period = P7D
        System.out.println(reminder1);// Reminder = 2025-11-27
        System.out.println(reminder2);// Reminder = 2025-12-20

        Duration oneHour = Duration.of(1, ChronoUnit.HOURS);
        System.out.println(oneHour); // PT1H
        System.out.println(oneHour.getSeconds()); // 3600
        LocalDateTime ldt1 = LocalDateTime.of(startDate, LocalTime.of(4, 30));
        LocalDateTime ldt2 = LocalDateTime.of(endDate, LocalTime.of(12, 0));
        Duration howLongD = Duration.between(ldt1, ldt2);
        System.out.println(howLongD);// PT34999H30M
        System.out.println(howLongD.get(ChronoUnit.SECONDS));// 125998200
//        System.out.println(howLongD.get(ChronoUnit.DAYS));// Exception!


        // Date
//        LocalDate date = LocalDate.of(2022, Month.AUGUST, 10);
//        System.out.println(date);// 2022-08-10
    //  DateTimeFormatter format =
    //      DateTimeFormatter.ofPattern("yyyy-MMM-dd");// 2022-Aug-10
    //  DateTimeFormatter format =
    //      DateTimeFormatter.ofPattern("yyyy-MM-dd E D");// 2022-08-10 Wed 222
    //    DateTimeFormatter format = // needed 4 E's to get full day i.e. Wednesday
    //        DateTimeFormatter.ofPattern("yy-MMM-dd EEEE d");// 22-Aug-10 Wednesday 10
    //    System.out.println(date.format(format));

        // Time
//        LocalTime time = LocalTime.of(14, 40);
//        System.out.println(time);// 14:40
        //        DateTimeFormatter format =
        //            DateTimeFormatter.ofPattern("hh:mm:ss");// 02:40:00
        //        DateTimeFormatter format =
        //            DateTimeFormatter.ofPattern("HH:mm");// 14:40

        // DateTimeFormatter format = // IllegalArgumentException: Unknown pattern letter: P
        //     DateTimeFormatter.ofPattern("Phone call at h:mm a");
//        DateTimeFormatter format = // Phone call at 2:40 pm
//            DateTimeFormatter.ofPattern("'Phone call at' h:mm a");


//        System.out.println(time.format(format));


*/