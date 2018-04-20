package com.example.mohit.testdemo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by Mohit on 3/13/2018.
 */

public class MainActivityTest extends
        ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mTestActivity;
    private EditText mTestFirstName, mTestLastName, mTestContact;
    private RadioGroup mTestGender;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Starts the activity under test using
        // the default Intent with:
        // action = {@link Intent#ACTION_MAIN}
        // flags = {@link Intent#FLAG_ACTIVITY_NEW_TASK}
        // All other fields are null or empty.
        mTestActivity = getActivity();
        mTestFirstName = (EditText) mTestActivity
                .findViewById(R.id.name);
        mTestLastName = (EditText) mTestActivity
                .findViewById(R.id.lName);
        mTestGender = (RadioGroup) mTestActivity
                .findViewById(R.id.gender);
        mTestContact = (EditText) mTestActivity
                .findViewById(R.id.contact);
    }

    /**
     * Test if your test fixture has been set up correctly.
     * You should always implement a test that
     * checks the correct setup of your test fixture.
     * If this tests fails all other tests are
     * likely to fail as well.
     */
    public void testPreconditions() {
        // Try to add a message to add context to your assertions.
        // These messages will be shown if
        // a tests fails and make it easy to
        // understand why a test failed
        assertNotNull("mTestActivity is null", mTestActivity);
        assertNotNull("mTestFirstName is null", mTestFirstName);
        assertNotNull("mTestLastName is null", mTestLastName);
        assertNotNull("mTestContact is null", mTestContact);
    }

    public void testEmptyView_labelText() {
        // It is good practice to read the string
        // from your resources in order to not break
        // multiple tests when a string changes.
        String actual = mTestFirstName.getText().toString();
        assertEquals("mTestEmptyText contains wrong text",
                "Mohit", actual);
    }

}