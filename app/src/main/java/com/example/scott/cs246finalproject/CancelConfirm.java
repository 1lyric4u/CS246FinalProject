package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

import java.util.Date;


public class CancelConfirm extends AppCompatActivity {

    private String eventToCancel;
    private java.util.Calendar cal = java.util.Calendar.getInstance();
    private Date todayDate = cal.getTime();
    private DateTime today = new DateTime(todayDate);
    private static final long ONEDAY = 86400000;
    private DateTime toCancel;


    // David - May be cleaner to, rather than have each button 'call' a different method, have
    //      them 'call' the same method, which then checks which button was pressed and acts
    //      accordingly.
    // Shanna- That's more confusing to me, but if you want to change that, feel free


    /*Button ID:buttonNo needs to simply return user to homepage*/
    public void returnToMain() {
        finish();
    }

    // Gain access to the controller
    private CalendarController controller = CalendarController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_cancel_confirm);

        /* Needs to get date to cancel from home page and display it in TextView ID:apptToCancel*/
        TextView apptToCancel = (TextView) findViewById(R.id.apptToCancel);
        if (extras != null) {
            eventToCancel = MainActivity.EVENTTOCANCEL; //eventToSend needs to come from main
            apptToCancel.setText(eventToCancel);
        }

        //Displays message saying displayed in Text View ID:creditMsg
        TextView creditMsg = (TextView) findViewById(R.id.creditMsg);
        toCancel = new DateTime(eventToCancel); // not sure how this parses
        if(toCancel.getValue()-today.getValue()< ONEDAY){
             creditMsg.setText("Please understand that because this lesson is less than 24 hrs away, " +
                     "you will not be allowed to reschedule.");
        }
        else
        {
            creditMsg.setText("You will be given a credit on your homepage which will allow you to reschedule");
        }

        /* Button ID:buttonYes needs to alter schedule, add a credit, and return user to homepage*/
        final Button button = (Button) findViewById(R.id.buttonYes);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                controller.cancelAppointment(eventToCancel);
                finish();
            }
        });

    }
}
