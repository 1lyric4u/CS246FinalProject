package com.example.scott.cs246finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CancelConfirm extends AppCompatActivity {
    /* Needs to get date to cancel from home page and display it in TextView ID:apptToCancel*/

    /*Displays message saying "You will be given a credit on your homepage which will
    allow you to reschedule" if the lesson time is more than 24 hrs away. If the cancel happens
    withing 24 hrs of the appointment time, it should display "Pleas understand that because this
    lesson is less than 24 hrs away, you will not be allowed to reschedule." This message should
    be displayed in Text View ID:creditMsg
     */

    /* Button ID:buttonYes needs to alter schedule, add a credit, and return user to homepage*/

    /*Button ID:buttonNo needs to simple return user to homepage*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_confirm);
    }
}
