package com.example.scott.cs246finalproject;


import com.google.api.services.calendar.model.Event;

import java.util.List;

/**
 * Created by scott on 11/1/16.
 */

public class CalendarConnector {

    // until this project has proper google-api imports available,
    // Event references are replaced with Object references.
    // This will change.
    public boolean isValidViewer(String id){
        return false;
    }

    public List<Event> getCalendarEvents(){
        return null;
    }

    public void deleteEvent(Event e){

    }

    public void createEvent(Event e){

    }

    public boolean moveEvent(Event e){
        return false;
    }

}