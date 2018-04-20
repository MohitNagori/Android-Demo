package com.example.mohit.databindingdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mohit.databindingdemo.databinding.ListItemBinding;

import java.util.List;

/**
 * Created by Mohit on 2/17/2018.
 */

public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Doctor> mList;
    private LayoutInflater mInflater;

    public ListAdapter(Context context, List<Doctor> arrayList) {
        this.mContext = context;
        this.mList = arrayList;
        this.mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemBinding binding = ListItemBinding.inflate(mInflater, parent, false);
        binding.setDoctor(mList.get(position));
        return binding.getRoot();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mList.indexOf(getItem(position));
    }
}

