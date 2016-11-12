package com.example.scott.cs246finalproject;

import android.app.Activity;
import android.content.Context;
import android.test.mock.MockContext;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;


/**
 * Created by David Rosevear on 11/2/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalendarControllerTest {

    private final CalendarController controller = CalendarController.getInstance();

    @Mock
    Context mockContext;

    @Mock
    Button mockButtonCancelYes;

    @Test
    public void performAction() throws Exception {

        when(mockButtonCancelYes.getId())
                .thenReturn(R.id.buttonYes);

        controller.performAction(mockButtonCancelYes);
    }

    @Test
    public void update() throws Exception {
        Context context = new MockContext();
        controller.update(new TextView(context));
    }

}