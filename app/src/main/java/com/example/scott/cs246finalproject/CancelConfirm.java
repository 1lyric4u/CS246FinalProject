package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;


public class CancelConfirm extends AppCompatActivity implements MVC_View_Interface {

    public Event eventToCancel;

    /* Button ID:buttonYes needs to alter schedule, add a credit, and return user to homepage*/
    public void cancelAppt(View view) {

    }

    /*Button ID:buttonNo needs to simply return user to homepage*/
    public void returnToMain() {
        finish();
    }

    // Gain access to the controller
    private CalendarController controller = CalendarController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_cancel_confirm);

        /* Needs to get date to cancel from home page and display it in TextView ID:apptToCancel*/
        TextView apptToCancel = (TextView) findViewById(R.id.apptToCancel);
        if (extras != null) {
            eventToCancel = extras.get(eventToSend); //eventToSend needs to come from main
            apptToCancel.setText(eventToCancel.getStart().toString());
        }

        /*Displays message saying "You will be given a credit on your homepage which will
    allow you to reschedule" if the lesson time is more than 24 hrs away. If the cancel happens
    withing 24 hrs of the appointment time, it should display "Please understand that because this
    lesson is less than 24 hrs away, you will not be allowed to reschedule." This message should
    be displayed in Text View ID:creditMsg
     */
    }
}
