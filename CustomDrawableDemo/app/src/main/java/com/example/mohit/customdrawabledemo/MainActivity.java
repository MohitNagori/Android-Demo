package com.example.mohit.customdrawabledemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ExpandingCircleAnimationDrawable mCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView iv = (ImageView) findViewById(R.id.image);
        mCircle = new ExpandingCircleAnimationDrawable(200);
        iv.setImageDrawable(mCircle);


        findViewById(R.id.btnCodeDrawable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCircle.isRunning()) {
                    mCircle.stop();
                } else {
                    mCircle.start();
                }
            }
        });

    }
}
