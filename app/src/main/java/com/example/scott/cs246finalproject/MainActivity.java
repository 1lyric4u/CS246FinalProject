package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


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

    /* Needs to display number of credits available. This should be saved as a Shared Reference.
    * The id is creditCount*/

    /*The button id:Resched needs to move to the view:ChooseDay. No information needs to be passed*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // !!This should be replaced, but was used for testing purposes!!
        Intent intent = new Intent(this, CancelConfirm.class);
        startActivity(intent);
    }
}
