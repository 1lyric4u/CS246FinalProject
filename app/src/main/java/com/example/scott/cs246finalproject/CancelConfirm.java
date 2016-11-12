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

//import CalendarController;

import java.util.Date;


public class CancelConfirm extends AppCompatActivity {

    public Event eventToCancel;
    protected int credits;
    private java.util.Calendar cal = java.util.Calendar.getInstance();
    private Date todayDate = cal.getTime();
    private DateTime today = new DateTime(todayDate);
    public SharedPreferences creditCount = getSharedPreferences("creditEditor",0); // !!!
    public SharedPreferences.Editor creditEditor;

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
            //eventToCancel = extras.get(eventToSend); //eventToSend needs to come from main
            apptToCancel.setText(eventToCancel.getStart().toString());
        }

        /*Displays message saying "You will be given a credit on your homepage which will
    allow you to reschedule" if the lesson time is more than 24 hrs away. If the cancel happens
    withing 24 hrs of the appointment time, it should display "Please understand that because this
    lesson is less than 24 hrs away, you will not be allowed to reschedule." This message should
    be displayed in Text View ID:creditMsg
     */
        TextView creditMsg = (TextView) findViewById(R.id.creditMsg);
        if(eventToCancel.getStart().getDate().getValue()-today.getValue()<86400000){
            creditMsg.setText("Please understand that because this lesson is less than 24 hrs away, you will not be allowed to reschedule.");
        }
        else{
            creditMsg.setText("You will be given a credit on your homepage which will allow you to reschedule");
        }

        /* Button ID:buttonYes needs to alter schedule, add a credit, and return user to homepage*/
        final Button button = (Button) findViewById(R.id.buttonYes);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //cancel appointment via CalendarController
                //eventToCancel.cancelAppointment;
                //increment credits
                credits = creditCount.getInt("get credits", credits); // !!!
                credits++;
                creditEditor = creditCount.edit();
                creditEditor.putInt("change credits",credits); // !!!
                // Commit the edits
                creditEditor.commit();
                //return to homepage
                finish();
            }
        });

    }
}
