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
    private ArrayAdapter<String> arrayAdapter;
    private ListView listView;
    private CalendarController controller = CalendarController.getInstance();
    private TextView creditCount;

    /*The button id:Resched needs to move to ChooseDay.*/
    public void toChooseDay(View view) {
        Intent intent = new Intent(this, ChooseDay.class);
        startActivity(intent);
        // Scott - just testing logging with the method call below
        //controller.createAppointment();
        //controller.update(view);
        //controller.cancelAppointment();
    }

    //this is commented out because it references mylist, which if initialized prevents app from loading
    public void toCancelConfirm (View view) {
        Intent intent = new Intent(this, CancelConfirm.class);
        String eventToSend = listView.getSelectedItem().toString();
        intent.putExtra("cancel me", eventToSend);
        // David - Don't need to pass controller, as it's a Singleton and each activity can access
        //intent.putExtra("controller", controller) // not sure how to pass controller, sorry
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        //populate list
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

        //display number of credits available.
        creditCount = (TextView) findViewById(R.id.creditCount);
        creditCount.setText(controller.credits.getCount());
        */


        // !!This should be replaced, but was used for testing purposes!!
        Intent intent = new Intent(this, CancelConfirm.class);
        // The string used here is taken from https://tools.ietf.org/html/rfc3339#section-5.8
        intent.putExtra("cancel me", "1985-04-12T23:20:50.52Z");
        startActivity(intent);
    }
}
