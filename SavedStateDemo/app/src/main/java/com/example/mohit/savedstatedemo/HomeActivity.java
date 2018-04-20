package com.example.mohit.savedstatedemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    private TextView firstName, lastName, email, contact;
    private Record mFormDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mFormDetail = new Record();

        firstName = (TextView) findViewById(R.id.firstName);
        lastName = (TextView) findViewById(R.id.lastName);
        email = (TextView) findViewById(R.id.email);
        contact = (TextView) findViewById(R.id.contact);

        ((RadioGroup) findViewById(R.id.gender)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mFormDetail.gender = checkedId;
            }
        });

        ((CheckBox) findViewById(R.id.termsAndConditions)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mFormDetail.acceptTermsAndConditions = isChecked;
            }
        });

        findViewById(R.id.fragmentView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.home).setVisibility(View.GONE);
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.flFragment, new HomeFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                manager.executePendingTransactions();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mFormDetail.firstName = firstName.getText().toString();
        mFormDetail.lastName = lastName.getText().toString();
        mFormDetail.email = email.getText().toString();
        mFormDetail.contact = contact.getText().toString();
        outState.putParcelable("FormDetail", mFormDetail);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            mFormDetail = savedInstanceState.getParcelable("FormDetail");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Comment onSaveState and restore to see the change
        Toast.makeText(this, "" + mFormDetail.firstName + "\n" + mFormDetail.lastName + "\n"
                + mFormDetail.email + "\n" + mFormDetail.contact + "\n" + mFormDetail.gender + "\n", Toast.LENGTH_LONG).show();
    }

}
