package com.example.mohit.customviewsdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mohit.customviewsdemo.R;
import com.example.mohit.customviewsdemo.customviews.DateView;
import com.example.mohit.customviewsdemo.customviews.StyleButton;

public class MainActivity extends AppCompatActivity {

    DateView dateView;
    StyleButton styleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Textview
        dateView = findViewById(R.id.dateView);

        Spinner delimiterSpinner = (Spinner) findViewById(R.id.delimiterSpinner);
        ArrayAdapter delimiterAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"-", "/"});
        delimiterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        delimiterSpinner.setAdapter(delimiterAdapter);
        delimiterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    dateView.setDelimiter("-");
                } else {
                    dateView.setDelimiter("/");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner fancyTextSpinner = (Spinner) findViewById(R.id.fancyTextSpinner);
        ArrayAdapter fancyTextAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"true", "false"});
        fancyTextAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fancyTextSpinner.setAdapter(fancyTextAdapter);

        fancyTextSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    dateView.setFancyText(true);
                } else {
                    dateView.setFancyText(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Button
        styleButton = findViewById(R.id.styleButton);
        Spinner headingSpinner = (Spinner) findViewById(R.id.headingSpinner);
        final ArrayAdapter headingAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"Morning", "Afternoon", "Evening"});
        headingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        headingSpinner.setAdapter(headingAdapter);
        headingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                styleButton.setHeading(headingAdapter.getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner subHeadingSpinner = (Spinner) findViewById(R.id.subHeadingSpinner);
        final ArrayAdapter subHeadingAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"Mohit", "Nagori"});
        subHeadingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subHeadingSpinner.setAdapter(subHeadingAdapter);

        subHeadingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                styleButton.setSubheading(subHeadingAdapter.getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}