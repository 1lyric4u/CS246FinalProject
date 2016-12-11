package com.example.scott.cs246finalproject;

import org.joda.time.DateTime;

/**
 * Created by scott on 12/10/16.
 */

public class DateTimeFormatter {

    private static String formatDate(DateTime dateTime){
        return String.format("%s/%s/%s",
                dateTime.getYear(),dateTime.getMonthOfYear(), dateTime.getDayOfMonth());
    }

    private static String formatTime(DateTime dateTime){
        return String.format("%s:%s", dateTime.getHourOfDay(), dateTime.getMinuteOfHour());
    }

    /**
     * Returns a string from a DateTime object in the format of "year/month/day hour:minute"
     * @param dateTime
     * @return
     */
    public static String format(DateTime dateTime){
        return formatDate(dateTime) + " " + formatTime(dateTime);
    }

    /**
     * Returns a string from a DateTime object in the format of "year/month/day hour:minute-hour:minute"
     * @param start
     * @param end
     * @return
     */
    public static String format(com.google.api.client.util.DateTime start, com.google.api.client.util.DateTime end){
        DateTime startGood = new DateTime(start.getValue());
        DateTime endGood = new DateTime(end.getValue());
        return format(startGood) + "-" + formatTime(endGood);
    }

    /**
     * Returns one dateTime if an all day event, and two the string contains an end time
     * @param dateTime
     * @return
     */
    public static DateTime[] parse(String dateTime){
        boolean containsEndTime = dateTime.contains("-");
        DateTime [] values = null;

        String split [] = dateTime.split(" ");
        String date [] = split[0].split("/");

        // send back two times if an end time is given
        if(containsEndTime){
            values = new DateTime[2];

            String timeRange [] = split[1].split("-");
            String timeStart [] = timeRange[0].split(":");
            String timeStop [] = timeRange[1].split(":");

            DateTime start = new DateTime();
            start.withYear(Integer.parseInt(date[0]));
            start.withMonthOfYear(Integer.parseInt(date[1]));
            start.withDayOfMonth(Integer.parseInt(date[2]));
            start.withHourOfDay(Integer.parseInt(timeStart[0]));
            start.withMinuteOfHour(Integer.parseInt(timeStart[1]));
            start.withSecondOfMinute(0);
            start.withMillisOfSecond(0);

            DateTime end = new DateTime(start);
            end.withHourOfDay(Integer.parseInt(timeStop[0]));
            end.withMinuteOfHour(Integer.parseInt(timeStop[1]));

            values[0] = start;
            values[1] = end;

        }else{
            // one time if no end date is given
            values = new DateTime[1];

            String time[] = split[1].split(":");

            DateTime allDay = new DateTime();
            allDay.withYear(Integer.parseInt(date[0]));
            allDay.withMonthOfYear(Integer.parseInt(date[1]));
            allDay.withDayOfMonth(Integer.parseInt(date[2]));
            allDay.withHourOfDay(Integer.parseInt(time[0]));
            allDay.withMinuteOfHour(Integer.parseInt(time[1]));
            allDay.withSecondOfMinute(0);
            allDay.withMillisOfSecond(0);

            values[0] = allDay;
        }// end if

        return values;
    }
}
