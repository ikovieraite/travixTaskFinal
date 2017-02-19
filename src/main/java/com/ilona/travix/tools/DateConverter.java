package com.ilona.travix.tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ilonaK on 19/02/2017.
 */
public class DateConverter {

    public String getDate(String date, String datePattern, String requiredPattern){
        LocalDateTime datetime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(datePattern));
        return  datetime.format(DateTimeFormatter.ofPattern(requiredPattern));
    }

    public String getDateFromThreeElements(int day, int month, int year){
        return month+"-"+day+"-"+year;
    }



}
