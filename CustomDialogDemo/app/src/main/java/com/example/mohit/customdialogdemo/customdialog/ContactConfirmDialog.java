package com.example.mohit.customdialogdemo.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mohit.customdialogdemo.R;
import com.example.mohit.customdialogdemo.databinding.ChangeRequestDialogBinding;


/**
 * Created by Mohit.
 */

public class ContactConfirmDialog extends Dialog implements
        View.OnClickListener {

    public static String CUSTOMDIALOG_NAME = "customdialog_name";
    public static String CUSTOMDIALOG_NUMBER = "customdialog_number";

    private ChangeRequestDialogBinding bindings;
    private Bundle bundle;

    private Activity activity;
    
    public ContactConfirmDialog(Activity a, Bundle bundle) {
        super(a);
        this.activity = a;
        this.bundle = bundle;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCancelable(false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        bindings = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.change_request_dialog, null, false);
        setContentView(bindings.getRoot());

        bindings.close.setOnClickListener(this);
        bindings.confirm.setOnClickListener(this);

        bindings.name.setText(bundle.getString(CUSTOMDIALOG_NAME, ""));
        bindings.number.setText(bundle.getString(CUSTOMDIALOG_NUMBER, ""));

        LinearLayout root = bindings.root;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthLcl = (int) (displayMetrics.widthPixels * 0.8f);
        
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) root.getLayoutParams();
        params.width = widthLcl;
        root.setLayoutParams(params);
        Window window = getWindow();
        window.setBackgroundDrawableResource(R.drawable.grey_rounded_bckground);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close: {
                dismiss();
                break;
            }
            case R.id.confirm: {
                if (validate()) {
                    dismiss();
                    Toast.makeText(activity, "Name - " + bindings.name.getText().toString()
                            + "\nNumber - " + bindings.number.getText().toString(), Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    private boolean validate() {
        if (bindings.name.getText().toString().isEmpty() ||  bindings.number.getText().toString().isEmpty()) {
            if (bindings.name.getText().toString().isEmpty()) {
                bindings.name.setError("Please Fill Name");
            } else {
                bindings.name.setError(null);
            }

            if (bindings.number.getText().toString().isEmpty()) {
                bindings.number.setError("Please Fill Number");
            } else {
                bindings.number.setError(null);
            }

            return false;
        }
        return true;
    }
}