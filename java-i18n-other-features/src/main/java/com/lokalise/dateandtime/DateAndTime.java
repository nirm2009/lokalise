/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokalise.dateandtime;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Dasun Nirmitha
 */
public class DateAndTime {
    public String getCurrentDateAndTime(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,
                                                               DateFormat.SHORT, 
                                                               locale);
        return dateFormat.format(new Date());
    }
}
