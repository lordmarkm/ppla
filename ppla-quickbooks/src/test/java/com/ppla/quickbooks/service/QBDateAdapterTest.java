package com.ppla.quickbooks.service;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.ppla.quickbooks.util.QBDateAdapter;

public class QBDateAdapterTest {

    QBDateAdapter dateAdapter = new QBDateAdapter();

    @Before
    public void init() {
        dateAdapter.init();
    }

    @Test
    public void test() {
        System.out.println(dateAdapter.format(DateTime.now()));
    }
}
