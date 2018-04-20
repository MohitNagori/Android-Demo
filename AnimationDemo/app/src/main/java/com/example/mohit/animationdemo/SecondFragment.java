package com.example.mohit.animationdemo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment implements View.OnClickListener {

    private View image;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        view.findViewById(R.id.zoom).setOnClickListener(this);
        view.findViewById(R.id.move).setOnClickListener(this);
        view.findViewById(R.id.fade).setOnClickListener(this);
        view.findViewById(R.id.blink).setOnClickListener(this);
        view.findViewById(R.id.clockwise).setOnClickListener(this);
        view.findViewById(R.id.slide).setOnClickListener(this);
        view.findViewById(R.id.fragmentSlideIn).setOnClickListener(this);
        view.findViewById(R.id.fragmentSlideOut).setOnClickListener(this);
        view.findViewById(R.id.fragmentLeftFlip).setOnClickListener(this);
        view.findViewById(R.id.fragmentRightFlip).setOnClickListener(this);
        image = view.findViewById(R.id.imageView);

        return view;
    }

    @Override
    public void onClick(View view) {
        AnimationUtil animationUtil = new AnimationUtil(getActivity());
        switch (view.getId()) {
            case R.id.zoom: {
                animationUtil.zoom(image);
                break;
            }
            case R.id.fade: {
                animationUtil.fade(image);
                break;
            }
            case R.id.slide: {
                animationUtil.slide(image);
                break;
            }
            case R.id.clockwise: {
                animationUtil.clockwise(image);
                break;
            }
            case R.id.move: {
                animationUtil.move(image);
                break;
            }
            case R.id.blink: {
                animationUtil.blink(image);
                break;
            }
            case R.id.fragmentSlideIn: {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
                ft.replace(R.id.flFragments, new FirstFragment(), "FirstFragment");
                ft.commit();
                getFragmentManager().executePendingTransactions();
                break;
            }
            case R.id.fragmentSlideOut: {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_right);
                ft.replace(R.id.flFragments, new FirstFragment(), "FirstFragment");
                ft.commit();
                getFragmentManager().executePendingTransactions();break;
            }
            case R.id.fragmentLeftFlip: {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.animator.flip_left_in, R.animator.flip_left_out);
                ft.replace(R.id.flFragments, new FirstFragment(), "FirstFragment");
                ft.commit();
                getFragmentManager().executePendingTransactions();
                break;
            }
            case R.id.fragmentRightFlip: {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.animator.flip_right_in, R.animator.flip_right_out);
                ft.replace(R.id.flFragments, new FirstFragment(), "FirstFragment");
                ft.commit();
                getFragmentManager().executePendingTransactions();
                break;
            }
        }
    }
}
