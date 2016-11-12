package com.example.scott.cs246finalproject;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by shanna on 11/1/16.
 */
public class CreditsTest {

    private Credits credit = new Credits();
    private Date inPast = new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime();
    private Date good = new GregorianCalendar(2017, Calendar.JANUARY, 1).getTime();
    private Date tooFar = new GregorianCalendar(2017,Calendar.JANUARY,23).getTime();
    private Calendar cal = Calendar.getInstance();
    private Date today = cal.getTime();

    @Test
    public void reset() throws Exception {

    }

    @Test
    public void addCredit() throws Exception {
        //check that you can't add a credit for a past lesson
        credit.addCredit(inPast);
        assert( credit.getCount() == 0);
        // check that you cannot add a lesson for today (less than 24 hrs notice)
        cal.add(Calendar.DATE, 1);
        Date tomorrow = cal.getTime();
        credit.addCredit(tomorrow);
        assert(credit.getCount() == 0);
        cal.add(Calendar.DATE, -1); //reset calendar
        // check that you can add a credit for a valid date
        credit.addCredit(good);
        assert(credit.getCount() == 1);
    }

    @Test
    public void useCredit() throws Exception {
        credit.addCredit(good);
        int count = credit.getCount();
        //check that Credit cannot be used for today
        credit.useCredit(today);
        assert (credit.getCount() == count);
        //check that credit cannot be used more than three weeks ahead of date
        credit.useCredit(tooFar);
        assert (credit.getCount() == count);
        //check that credit can be used for valid date
        cal.add(Calendar.DATE, 1);
        Date tomorrow = cal.getTime();
        credit.useCredit(tomorrow);
        assert (credit.getCount() < count);
    }

}