package com.example.scott.cs246finalproject;

import android.util.Log;

import com.google.api.client.util.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by scott on 11/1/16.
 */

public class Credits {

    private final static String TAG = Credits.class.getSimpleName();

    private List<DateTime> creditList;

    public Credits(){
        creditList = new ArrayList<>();
    }

    public int getCount(){
        return creditList.size();
    }

    public void reset(){
        // if any dates are in past, delete from list
        // David - may be wise to have a constant or something that stores how long credits are good
    }

    public void addCredit(DateTime newCredit){
        //add date to list
        creditList.add(newCredit);
        Log.i(TAG, "Credit has been added");
    }

    public boolean checkCredit(Date newAppt){
        java.util.Calendar cal = java.util.Calendar.getInstance();
        Date todayDate = cal.getTime();
        DateTime today = new DateTime(todayDate);
        // search for oldest date in creditList
        // check that newAppt date is 3 weeks or less after credit date, if it is, return true
        // if newAppt date is not, search for next oldest date and rerun
        // if no credits work, return false
        Log.i(TAG, "You have a credit available to use for this reschedule date");
        return true;
    }

    public void useCredit(Date newAppt){
        if(checkCredit(newAppt)==true){
            //delete oldest credit
        }
        else{
            Log.e(TAG, "There is no credit available to use for this reschedule date");
        }
    }
}
