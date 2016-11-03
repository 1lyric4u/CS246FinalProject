package com.example.scott.cs246finalproject;

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

    // instance should be an Event object but
    // i need to find a way to get google-api imports
    // to properly resolve first.
    // Object type will change below, but otherwise the
    // test is valid.
    @Test
    public void deleteEvent() throws Exception {
        // change object type here
        Object event = new Object();
        // attempt deletion from google calendar
        connector.deleteEvent(event);
        // verify through call to calendar
        assertFalse(connector.getCalendarEvents().contains(event));
    }

}