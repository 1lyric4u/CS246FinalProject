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

    private final static long THREEWEEKS = 1814400000; // 3 weeks in milliseconds

    private final static long ONEDAY = 86400000; // 1 day in milliseconds

    private List<Credit> creditList;

    public Credits(){
        creditList = new ArrayList<>();
    }

    public int getCount(){
        return creditList.size();
    }

    public void reset(){
        //get access to today
        java.util.Calendar cal = java.util.Calendar.getInstance();
        Date todayDate = cal.getTime();
        DateTime today = new DateTime(todayDate);

        // if any dates are in past, delete from list
        for (int i = 0; i <= creditList.size(); i++){
            if(creditList.get(i).dateTime.getValue()- today.getValue()<= 0){
                creditList.remove(i);
            }
        }
    }

    public void addCredit(DateTime startTime, DateTime endTime ){
        //create the credit
        Credit newCredit = new Credit();
        newCredit.duration = endTime.getValue()-startTime.getValue();
        newCredit.dateTime = startTime;
        //add credit to list
        creditList.add(newCredit);
        Log.i(TAG, "Credit has been added");
    }

    public void addCredit(org.joda.time.DateTime startTime, org.joda.time.DateTime endTime){
        Credit newCredit = new Credit();
        newCredit.duration = endTime.getMillis()-startTime.getMillis();
        newCredit.dateTime = new DateTime(startTime.getMillis());
        //add credit to list
        creditList.add(newCredit);
        Log.i(TAG, "Credit has been added");
    }

    public List<Credit> checkCredit(DateTime newAppt) {
        //get access to today
        java.util.Calendar cal = java.util.Calendar.getInstance();
        Date todayDate = cal.getTime();
        DateTime today = new DateTime(todayDate);

        //set up list to return
        List<Credit> returnList = new ArrayList<Credit>();

        //check for appropriate credit
        for (int i = 0; i <= creditList.size(); i++){
            // check that newAppt date is 3 weeks (1814400000 ms) or less  before or after credit date,
            if (newAppt.getValue() - creditList.get(i).dateTime.getValue() <= THREEWEEKS ||
                    creditList.get(i).dateTime.getValue() - newAppt.getValue() <= THREEWEEKS) {
                //check that newAppt is not in 24 hrs (86400000 ms) from today
                if(newAppt.getValue()- today.getValue()<= ONEDAY){
                    Log.i(TAG,"There is an appropriate credit");
                    returnList.add(creditList.get(i));
                }
            }
        }
        return returnList;
    }


    public void useCredit(DateTime oldApptStart){
        Credit old = new Credit();
        old.dateTime = oldApptStart;
        if(creditList.contains(old)){
            creditList.remove(old);
        }
        else{
            Log.e(TAG, "There is no canceled appointment with that start time");
        }
    }
    public void useCredit(org.joda.time.DateTime oldApptStart){
        Credit old = new Credit();
        old.dateTime = new DateTime(oldApptStart.getMillis());
        if(creditList.contains(old)){
            creditList.remove(old);
        }
        else{
            Log.e(TAG, "There is no canceled appointment with that start time");
        }
    }
}
