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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // !!This should be replaced, but was used for testing purposes!!
        Intent intent = new Intent(this, CancelConfirm.class);
        startActivity(intent);
    }
}
