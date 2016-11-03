package com.example.scott.cs246finalproject;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David Rosevear on 11/2/2016.
 */
public class CalendarControllerTest {

    private final CalendarController controller = new CalendarController();

    @Test
    public void performAction() throws Exception {
        controller.performAction(1);
        controller.performAction(3);
    }

    @Test
    public void update() throws Exception {
        controller.update((TextView) new Object());
    }

}