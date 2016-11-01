package com.example.scott.cs246finalproject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by scott on 11/1/16.
 */

public class Credits {

    private ArrayList<Date> creditList;

    public Credits(){    }

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

    public boolean useCredit(Date newAppt){
        // search for oldest date in creditList
        // check that newAppt date is 3 weeks or less after credit date, if it is, return true and
        // delete from list
        // if newAppt date is not, search for next oldest date and rerun
        // if no credits work, return false
        return false;
    }

}
