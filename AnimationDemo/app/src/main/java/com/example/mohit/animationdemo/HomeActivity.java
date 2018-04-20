package com.example.mohit.animationdemo;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.flFragments, new FirstFragment());
        ft.commit();
        getFragmentManager().executePendingTransactions();

    }
}
