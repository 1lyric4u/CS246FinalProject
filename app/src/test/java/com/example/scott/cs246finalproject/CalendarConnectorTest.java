package com.example.scott.cs246finalproject;

import com.google.api.services.calendar.model.Event;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by scott on 11/2/16.
 */
public class CalendarConnectorTest {

    private final CalendarConnector connector = new CalendarConnector();

    private static String TEST_E_MAIL = "rutherford.scott@gmail.com";

    @Test
    public void isValidViewer() throws Exception {
        // a valid google e-mail account should return true
        assertTrue(connector.isValidViewer(TEST_E_MAIL));
    }

    @Test
    public void deleteEvent() throws Exception {
        // Event object, data irrelevent for this test
        Event event = new Event();
        // attempt deletion from google calendar
        connector.deleteEvent(event);
        // verify through call to calendar
        assertFalse(connector.getCalendarEvents().contains(event));
    }

}