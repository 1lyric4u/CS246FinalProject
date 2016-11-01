package com.example.scott.cs246finalproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by scott on 11/1/16.
 */
public class CreditsTest {

    private Credits credit = new Credits();
    private Date inPast = new Date(1990,1,1);
    private Date good = new Date(2017,1,1);
    private Date tooFar = new Date(2017,1,23);
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