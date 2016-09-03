package com.cdk.pat.util;

import com.cdk.pat.exception.PATException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtility {
    public static Date stringToDate(String dateInString,String format) throws PATException {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat();
        try {
            date = new SimpleDateFormat(format).parse(dateInString);
            formatter.format(date);
        } catch (ParseException e) {
            throw new PATException(e.toString());
        }
        return  date;
    }
}
