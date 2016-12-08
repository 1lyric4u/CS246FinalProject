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

    //send user to Choose Day page
    public void toChooseDay(View view) {
        Intent intent = new Intent(this, ChooseDay.class);
        startActivity(intent);
    }

    //send user to Cancel Confirm page
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
        controller.calendar.listView = (ListView) findViewById(R.id.upcoming);
        controller.calendar.adapter = new ArrayAdapter<>(
                getApplicationContext(), R.layout.support_simple_spinner_dropdown_item);
    }

    //retrieves teacher's calendar info
    public void click(View view){controller.calendar.getResults(view);}
}
