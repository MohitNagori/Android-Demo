package com.example.mohit.customviewsdemo.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;

import com.example.mohit.customviewsdemo.R;

/**
 * Created by Mohit.
 */

public class StyleButton extends AppCompatButton {

    private String heading = "";
    private String subheading = "";
    private boolean styleState = false;

    public StyleButton(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public StyleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        initStyleButton(attrs);
    }

    public StyleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        initStyleButton(attrs);
    }

    private void initStyleButton(AttributeSet attrs){
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.StyleButton);
        heading = a.getString(R.styleable.StyleButton_heading);
        subheading = a.getString(R.styleable.StyleButton_subHeading);
        setCompleteText();
        setStyle();
        a.recycle();
    }

    public void setHeading(String heading) {
        this.heading = heading;
        setCompleteText();
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
        setCompleteText();
    }

    private void setCompleteText() {
        SpannableString span1 = new SpannableString(heading);
        SpannableString span2 = new SpannableString(subheading);

        span1.setSpan(new ForegroundColorSpan(Color.RED),  0, heading.length(), 0);
        span2.setSpan(new RelativeSizeSpan(0.75f),  0, subheading.length(), 0);

        setText(TextUtils.concat(span1, "\n", span2));
    }

    private void setStyle() {
        if (styleState)
            setBackgroundResource(R.drawable.rounded_corners);
        else
            setBackgroundColor(Color.WHITE);
    }

}