package com.example.scott.cs246finalproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by scott on 11/1/16.
 */
public class CreditsTest {

    private Credits credit = new Credits();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void reset() throws Exception {
        credit.addCredit(new Date());
        assert( credit.getCount() > 0);
    }

    @Test
    public void addCredit() throws Exception {

    }

    @Test
    public void useCredit() throws Exception {

    }

}