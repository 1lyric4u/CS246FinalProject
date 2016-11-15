package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * This class is the starting point for our class final project in CS 246 of Fall 2016.
 *
 *
 * @author Scott Rutherford, Shanna-Mae Slight, David Rosevear
 */

public class MainActivity extends AppCompatActivity {
    /* Needs to display appointments in list view. You may consider creating a list that stores the
    * event.getStart() which returns a datetime data type. The list view needs to be clickable and
    * when clicked, needs to send the event as "eventToSend" to CancelConfirm as an extra.
    * CancelConfirm is already prepared to handle it*/

    //For some reason, the following line of code causes a crash, maybe because it is empty
    //ListView mylist = (ListView) findViewById(R.id.upcoming);
    //populate list

    // Gain access to the controller
    //private CalendarController controller = CalendarController.getInstance();

    /* Needs to display number of credits available. This should be saved in
    * CalendarController.credits.getCount()
    * The id for the text view is creditCount*/


    /*The button id:Resched needs to move to ChooseDay. calendarcontroller needs to be passed */
    public void toChooseDay (View view) {
        Intent intent = new Intent(this, ChooseDay.class);
        //pass controller, or at least credits somehow
        // David - each activity can get the instance of the single controller object by calling
        // CalendarController.getInstance();
        startActivity(intent);
    }

    //this is commented out because it references mylist, which if initialized prevents app from loading
    /*public void toCancelConfirm (View view) {
        Intent intent = new Intent(this, CancelConfirm.class);
        String eventToSend = mylist.getSelectedItem().toString();
        intent.putExtra("cancel me", eventToSend);
        //intent.putExtra("controller", controller) // not sure how to pass controller, sorry
        startActivity(intent);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // !!This should be replaced, but was used for testing purposes!!
        //Intent intent = new Intent(this, CancelConfirm.class);
        //startActivity(intent);
    }
}
