package com.example.mohit.customdialogdemo.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mohit.customdialogdemo.R;
import com.example.mohit.customdialogdemo.customdialog.ContactConfirmDialog;
import com.example.mohit.customdialogdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bindings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindings = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bindings.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(ContactConfirmDialog.CUSTOMDIALOG_NAME, bindings.name.getText().toString());
                bundle.putString(ContactConfirmDialog.CUSTOMDIALOG_NUMBER, bindings.number.getText().toString());
                new ContactConfirmDialog(MainActivity.this, bundle).show();
            }
        });

    }
}
