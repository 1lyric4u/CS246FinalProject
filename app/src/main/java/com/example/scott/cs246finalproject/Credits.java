package com.example.scott.cs246finalproject;

import com.google.api.client.util.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by scott on 11/1/16.
 */

public class Credits {

    private List<Date> creditList;

    public Credits(){
        creditList = new ArrayList<>();
    }

    public int getCount(){
        return creditList.size();
    }

    public void reset(){
        // if any dates are in past, delete from list
    }

    public void addCredit(Date newCredit){
        //add date to list
        creditList.add(newCredit);
    }

    public boolean checkCredit(Date newAppt){
        java.util.Calendar cal = java.util.Calendar.getInstance();
        Date todayDate = cal.getTime();
        DateTime today = new DateTime(todayDate);
        // search for oldest date in creditList
        // check that newAppt date is 3 weeks or less after credit date, if it is, return true
        // if newAppt date is not, search for next oldest date and rerun
        // if no credits work, return false
        return false;
    }

    public void useCredit(Date newAppt){
        if(checkCredit(newAppt)==true){
            //delete oldest credit
        }
        else{
        assert(true);}
    }
}
