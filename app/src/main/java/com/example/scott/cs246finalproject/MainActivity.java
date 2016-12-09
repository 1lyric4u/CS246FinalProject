package com.example.scott.cs246finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.util.DateTime;

import java.util.ArrayList;
import java.util.List;


/**
 * This class is the starting point for our class final project in CS 246 of Fall 2016.
 *
 *
 * @author Scott Rutherford, Shanna-Mae Slight, David Rosevear
 */

public class MainActivity extends AppCompatActivity {


    private CalendarController controller = CalendarController.getInstance();

    private String eventSelected;

    private ListView listView;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //populate list
        //controller.calendar.listView = (ListView) findViewById(R.id.lstView_upcoming_events);
        //controller.calendar.adapter = new ArrayAdapter<>(
                //getApplicationContext(), R.layout.support_simple_spinner_dropdown_item);

        eventSelected = null;   // blank until item in list is selected

        listView = (ListView) findViewById(R.id.lstView_upcoming_events);
        adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item);
        listView.setAdapter(adapter);   // add adapter to listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // tracks the most recently selected item in the list view
                eventSelected = adapterView.getAdapter().getItem(i).toString();
            }
        });
    }

    // one entry point to handle every button the user may click
    public void buttonListener(View view){
        switch(view.getId()){
            case R.id.btn_load_appointments: {
                // displays current appointments
                loadUpcomingCalendarEvents();
                break;
            }
            case R.id.btn_cancel_time : {
                // removes currently selected appointment
                openCancelConfirm();
                break;
            }
            case R.id.btn_reschedule_time : {
                // this opens the activity where the user may select a new day
                openChooseDay();
                break;
            }
        }// end switch
    }// end method

    // retrieves teacher's calendar info
    public void loadUpcomingCalendarEvents(){
        // this doesn't work yet.. - Scott
        // controller.calendar.getResults();

        // temporary measure to test other aspects of the app
        loadFakeDates();
    }

    // send user to Choose Day page
    private void openChooseDay() {
        //Intent intent = new Intent(this, ChooseDay.class);
        // include necessary data

        //startActivity(intent);
    }

    //send user to Cancel Confirm page
    public void openCancelConfirm () {
        // if eventSelected is null, no event has been selected in the listView
        // OR a previous event was just removed; nothing should trigger in either case
        if(null != eventSelected) {
            // This generates a pop up dialog displaying the users selected appointment
            // this is much simpler than generating a new activity and returning it's result
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Appointment Removal Confirmation")
                    .setMessage("You wish to remove appointment set for " + eventSelected + ", is this correct?");

            // on YES, remove appointment through back-end and update view
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // notify user of change
                    Toast.makeText(getApplicationContext(), "Removing " + eventSelected + " now.", Toast.LENGTH_SHORT).show();

                    // notify controller of removed event   // <-- change this to work through controller
                    adapter.remove(eventSelected);
                    // update view                          // <-- change this to work through controller

                    // update number of credits available   // <-- change this to work through controller

                    // now clear eventSelected for next use,
                    // this prevents a second button click from triggering a removal
                    // until a new event date is chosen.
                    eventSelected = null;
                    // close dialog
                    dialog.dismiss();
                }
            });

            // on NO, do nothing
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Do nothing
                    dialog.dismiss();
                }
            });
            // display window
            builder.create().show();
        }// end if
    }

    // to be removed
    private void loadFakeDates(){
        List<String> dates = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            StringBuilder builder = new StringBuilder();
            builder.append("Fake-Date ").append(i + 1).append(":00 PM");
            dates.add(builder.toString());
        }// end loop
        adapter.addAll(dates);
    }
}
