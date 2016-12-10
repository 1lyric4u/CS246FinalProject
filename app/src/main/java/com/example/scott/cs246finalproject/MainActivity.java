package com.example.scott.cs246finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

    private TextView creditCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        creditCount = (TextView) findViewById(R.id.txt_credit_count);
    }

    /**
     * The entry point for all button clicks.
     * They will be filtered and passed along to responsible methods.
     * @param view
     */
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

    /**
     * Loads current calendar events into the listView
     */
    public void loadUpcomingCalendarEvents(){
        controller.getResults(MainActivity.this, listView, adapter);
    }

    // send user to Choose Day page
    private void openChooseDay() {
        Intent intent = new Intent(this, ChooseDay.class);
        // include necessary data

        startActivity(intent);
    }

    /**
     * Provides a pop up dialog to confirm the users selection.
     */
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
                    // notify controller of removed event
                    controller.cancelAppointment(eventSelected, adapter);
                    // update credits
                    creditCount.setText("" + controller.getNumCredits());
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


}
