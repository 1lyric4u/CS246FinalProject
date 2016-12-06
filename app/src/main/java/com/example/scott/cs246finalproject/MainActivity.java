package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.api.services.calendar.model.Event;

import org.w3c.dom.Text;

import java.util.List;


/**
 * This class is the starting point for our class final project in CS 246 of Fall 2016.
 *
 *
 * @author Scott Rutherford, Shanna-Mae Slight, David Rosevear
 */

public class MainActivity extends AppCompatActivity {

    private String listItemSelected;
    private CalendarController controller = CalendarController.getInstance();
    private TextView creditCount;
    public static String EVENTTOCANCEL;

    /*The button id:Resched needs to move to ChooseDay.*/
    public void toChooseDay(View view) {
        Intent intent = new Intent(this, ChooseDay.class);
        startActivity(intent);
        // Scott - just testing logging with the method call below
        //controller.createAppointment();
        //controller.update(view);
        //controller.cancelAppointment();
    }

    public void toCancelConfirm (View view) {
        Intent intent = new Intent(this, CancelConfirm.class);
        //because the listView is populated by CalendarConnector, we access that list.
        //I'm honestly not sure if this will work -Shanna
        EVENTTOCANCEL = controller.calendar.listView.getSelectedItem().toString();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //populate list
        //This is now done by CalendarConnector
        controller.calendar.listView = (ListView) findViewById(R.id.upcoming);
        controller.calendar.adapter = new ArrayAdapter<>(
                getApplicationContext(), R.layout.support_simple_spinner_dropdown_item);

        //  !!! !!! !!!
        // This will load all of the teacher's calendar, not just where student is an attendee
        // Filtering code needs to go here !!!! <3 Shanna

        /*
        List<Event> upcoming = controller.calendar.getCalendarEvents();
        listView = (ListView) findViewById(R.id.upcoming);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listItemSelected = (String)listView.getItemAtPosition(i);
            }// end override
        });
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        listView.setAdapter(arrayAdapter);  // apply adapter to listView

        arrayAdapter.addAll(upcoming.toString());
        */

        //display number of credits available.
        //creditCount = (TextView) findViewById(R.id.creditCount);
        //creditCount.setText(controller.credits.getCount());


        // !!This should be replaced, but was used for testing purposes!!
        //Intent intent = new Intent(this, CancelConfirm.class);
        //startActivity(intent);
    }
    public void click(View view){controller.calendar.getResults(view);}
}
