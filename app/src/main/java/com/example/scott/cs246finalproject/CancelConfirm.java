package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CancelConfirm extends AppCompatActivity {
    /* Needs to get date to cancel from home page and display it in TextView ID:apptToCancel*/

    /*Displays message saying "You will be given a credit on your homepage which will
    allow you to reschedule" if the lesson time is more than 24 hrs away. If the cancel happens
    withing 24 hrs of the appointment time, it should display "Please understand that because this
    lesson is less than 24 hrs away, you will not be allowed to reschedule." This message should
    be displayed in Text View ID:creditMsg
     */

    /* Button ID:buttonYes needs to alter schedule, add a credit, and return user to homepage*/

    /*Button ID:buttonNo needs to simple return user to homepage*/

    // Gain access to the controller
    private CalendarController controller = CalendarController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_confirm);
    }

    /**
     * When an action is performed, pass the information on to the controller
     * Note that is occurs in this activity when one of the two buttons are clicked
     *
     * @param view
     */
    public void actionPerformed(View view) {
        controller.actionPerformed(this, view);
    }

    /**
     * Method to return to the MainActivity (or HomepageActivity) - consider making part of an
     * interface.
     */
    public void returnToHomepage() {

        // Start the MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
