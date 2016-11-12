package com.example.scott.cs246finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class EventView extends AppCompatActivity {

    private ListView listView;

    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);
        // view elements which shall be modified by the user
        listView = (ListView) findViewById(R.id.list_of_events);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        listView.setAdapter(arrayAdapter);  // apply adapter to listView
    }

    private void removeEvent(View view){
        // execute controller method and update UI

    }

    private void updateListView(List<String> list){
        arrayAdapter.clear();       // empty, in prep for new data
        arrayAdapter.addAll(list);  // update UI
    }

}
