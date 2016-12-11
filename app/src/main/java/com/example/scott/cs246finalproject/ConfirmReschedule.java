package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.api.client.util.DateTime;

import java.util.Date;
import java.util.List;

public class ConfirmReschedule extends AppCompatActivity {
    // Gain access to the controller - Is this how this works?? I feel like I'm creating a new,
    // not getting from previous page
    private CalendarController controller = CalendarController.getInstance();

    private ListView listView;

    private ArrayAdapter<String> arrayAdapter;

    private String listItemSelected = "no item selected";

    /*Button ID:buttonYes needs to alter schedule and return user to homepage*/
    public void Yes (View view) {
        //get appointment to create from DisplaySchedule
        String newAppt = DisplaySchedule.APPOINTMENT;

        //create the appointment
        controller.createAppointment(newAppt);

        // use selected credit
        org.joda.time.DateTime oldAppt = DateTimeFormatter.parse(listItemSelected)[0]; // not sure how this parses
        controller.credits.useCredit(oldAppt);

        //send to homepage
        Intent intent = new Intent(this, MainActivity.class);
        //pass controller, or at least credits somehow
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_reschedule);

        /* Insert Reschedule Time and Date from DisplaySchedule.java into TextView ID:reschedTimeDate*/
        TextView appt = (TextView) findViewById(R.id.reschedTimeDate);
        appt.setText(DisplaySchedule.APPOINTMENT);

        /*Insert eligible credits into listView ID:eligibleCreditList*/
        listView = (ListView) findViewById(R.id.creditList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listItemSelected = (String)listView.getItemAtPosition(i);
            }// end override
        });
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        listView.setAdapter(arrayAdapter);  // apply adapter to listView

        // parse String appointment into DateTime
        org.joda.time.DateTime newAppt = DateTimeFormatter.parse(DisplaySchedule.APPOINTMENT)[0];//not sure how this will parse

        //add available credits to list
        arrayAdapter.addAll(controller.credits.checkCredit(new DateTime(newAppt.getMillis())).toString());
    }
}
