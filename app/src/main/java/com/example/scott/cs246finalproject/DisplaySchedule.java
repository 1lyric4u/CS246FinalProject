package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.api.client.util.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

public class DisplaySchedule extends AppCompatActivity {

    public static final String APPOINTMENT = "Appointment";

    private static final String EMPTY_VALUE = "no selection made";

    private String listItemSelected;

    private CalendarController controller = CalendarController.getInstance();

    private ListView listView;

    private ArrayAdapter<String> arrayAdapter;

    private DateTime chosen_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_schedule);
        // view elements which shall be modified by the user
        listView = (ListView) findViewById(R.id.list_of_events);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listItemSelected = (String)listView.getItemAtPosition(i);
            }// end override
        });
        //Setting listView and adapter now done by Connector
        controller.calendar.listView = this.listView;
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        controller.calendar.adapter = this.arrayAdapter;
        /*
        listView.setAdapter(arrayAdapter);  // apply adapter to listView
        */

        /// !!! !!! !!!
        //Need to parse ChooseDay.CHOSEN_DAY from String into DateTime chosen_day
        //31556952000 milsec/year, but no set milsec/month, so may need to use Gregorian Calendar class
        // Don't forget that the DateTime needs to be 12:00 am in Mountain Time.
        // How will we deal with daylight savings? Does Gregorian Calendar handle that? -Shanna-Mae
        controller.calendar.isOneDay = true;
        controller.calendar.dateToDisplay = null;

        // populate time availability from controller
       // arrayAdapter.addAll(fakeTimes());

        // default 'selected time' = false time
        listItemSelected = EMPTY_VALUE;
    }

    // execute controller method and send data onward
    private void selectTime(View view){

    }

    /* to be removed and replaced with a call to the controller for available times
    private List<String> fakeTimes(){
        List<String> list = new ArrayList<>();
        Calendar today = GregorianCalendar.getInstance();
        today.set(HOUR_OF_DAY, 0);
        today.set(MINUTE, 0);
        today.set(SECOND, 0);

        for(int count = 0; count < 24 * 4; count++){
            Date time = today.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            list.add(sdf.format(time));
            today.add(MINUTE, 15);
        }// end loop

        return list;
    } */
    public void click(View view){controller.calendar.getResults();}
}
