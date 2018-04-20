package com.example.mohit.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mohit.databindingdemo.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ActivityListBinding mBinding;
    private List<Doctor> mDoctorList;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        mDoctorList = getDoctorList();
        mListAdapter = new ListAdapter(this, mDoctorList);
        mBinding.list.setAdapter(mListAdapter);
    }

    public ArrayList<Doctor> getDoctorList() {
        ArrayList<Doctor> list = new ArrayList<Doctor>();
        list.add(new Doctor("Mohit", "9999999999", "Neurology", 5.0f, "10AM-8PM"));
        list.add(new Doctor("Harshita", "9999999998", "Cardiology", 4.5f, "10AM-8PM"));
        list.add(new Doctor("Arpit", "9999999997", "Orthopedic", 4.0f, "10AM-8PM"));
        list.add(new Doctor("Ankita", "9999999996", "Physician", 4.2f, "9AM-6PM"));
        list.add(new Doctor("Samiksha", "9999999995", "Surgeon", 3.5f, "10AM-8PM"));
        list.add(new Doctor("Gaurav", "9999999994", "Child Specialist", 3.0f, "9AM-6PM"));
        return list;
    }
}
