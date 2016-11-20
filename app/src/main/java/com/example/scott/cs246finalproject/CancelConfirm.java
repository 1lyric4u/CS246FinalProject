package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

//import CalendarController;
//import Credits;

import java.util.Date;


public class CancelConfirm extends AppCompatActivity {

    private String eventToCancel;
    private DateTime toCancel;


    // David - May be cleaner to, rather than have each button 'call' a different method, have
    //      them 'call' the same method, which then checks which button was pressed and acts
    //      accordingly.
    // Shanna- That's more confusing to me, but if you want to change that, feel free

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
            eventToCancel = extras.getString("cancel me"); //eventToSend needs to come from main
            apptToCancel.setText(eventToCancel);
        } else {
            finish(); // No event passed, so get outta here!
        }

        //Displays message saying displayed in Text View ID:creditMsg
        TextView creditMsg = (TextView) findViewById(R.id.creditMsg);
        toCancel = new DateTime(eventToCancel); // not sure how this parses
        // David - the above parses as string as if it's in RFC 3339 format
        //      See https://tools.ietf.org/html/rfc3339#section-5.8 for documentation on the format
        //      particularly the 5.8 Examples section to see what these strings can look like
        if(Credit.isTodayWithinOneDay(toCancel)){
             creditMsg.setText(R.string.activity_cancel_confirm_creditMsg_reschedule_not_allowed);
        }
        else
        {
            creditMsg.setText(R.string.activity_cancel_confirm_creditMsg_reschedule_allowed);
        }

    }

    public void actionPerformed(View view) {
        switch (view.getId()) {

            // If 'Yes' button clicked, then alter schedule, add a credit, and return user to homepage
            case R.id.buttonYes:

                // Let the controller know to cancel the appointment, and tell it which one
                controller.cancelAppointment(eventToCancel);

                // Return to the main page
                finish();

            // If 'No' button clicked, just return to main page
            case R.id.buttonNo:

                // Return to the main page
                finish();

        }
    }
}
