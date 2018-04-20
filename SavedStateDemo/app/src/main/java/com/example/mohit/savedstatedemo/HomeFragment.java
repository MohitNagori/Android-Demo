package com.example.mohit.savedstatedemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    private TextView firstName, lastName, email, contact;
    private Record mFormDetail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mFormDetail = new Record();

        firstName = (TextView) view.findViewById(R.id.firstName);
        lastName = (TextView) view.findViewById(R.id.lastName);
        email = (TextView) view.findViewById(R.id.email);
        contact = (TextView) view.findViewById(R.id.contact);

        ((RadioGroup)view.findViewById(R.id.gender)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mFormDetail.gender = checkedId;
            }
        });

        ((CheckBox)view.findViewById(R.id.termsAndConditions)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mFormDetail.acceptTermsAndConditions = isChecked;
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mFormDetail.firstName = firstName.getText().toString();
        mFormDetail.lastName = lastName.getText().toString();
        mFormDetail.email = email.getText().toString();
        mFormDetail.contact = contact.getText().toString();
        outState.putParcelable("Form Detail", mFormDetail);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            mFormDetail = savedInstanceState.getParcelable("Form Detail");
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        // Comment onSaveState and restore to see the change
        Toast.makeText(getActivity(), "" + mFormDetail.firstName + "\n" + mFormDetail.lastName + "\n"
                + mFormDetail.email + "\n" + mFormDetail.contact + "\n" + mFormDetail.gender + "\n", Toast.LENGTH_LONG).show();
    }

}
