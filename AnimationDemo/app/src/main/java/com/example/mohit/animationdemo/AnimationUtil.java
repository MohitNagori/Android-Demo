package com.example.mohit.animationdemo;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


/**
 * Created by Mohit on 2/18/2018.
 */

public class AnimationUtil {

    private Context context;
    public AnimationUtil(Context context) {
        this.context = context;
    }

    public void clockwise(View view){
        Animation animation = AnimationUtils.loadAnimation(context,
                R.anim.clockwise);
        view.startAnimation(animation);
    }

    public void zoom(View view){
        Animation animation = AnimationUtils.loadAnimation(context,
                R.anim.zoom);
        view.startAnimation(animation);
    }

    public void fade(View view){
        Animation animation = AnimationUtils.loadAnimation(context,
                R.anim.fade);
        view.startAnimation(animation);
    }

    public void blink(View view){
        Animation animation = AnimationUtils.loadAnimation(context,
                R.anim.blink);
        view.startAnimation(animation);
    }

    public void move(View view){
        Animation animation = AnimationUtils.loadAnimation(context,
                R.anim.move);
        view.startAnimation(animation);
    }

    public void slide(View view){
        Animation animation = AnimationUtils.loadAnimation(context,
                R.anim.slide);
        view.startAnimation(animation);
    }

}
