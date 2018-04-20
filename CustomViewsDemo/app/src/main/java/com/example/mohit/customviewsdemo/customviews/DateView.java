package com.example.mohit.customviewsdemo.customviews;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.example.mohit.customviewsdemo.R;

public class DateView extends AppCompatTextView {
    private String delimiter;
    private boolean isFancyText;

    public DateView(Context context) {
        super(context);
        setDate();
    }

    public DateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DateView );
        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.DateView_delimiter:
                    delimiter = a.getString(attr);
                    setDate();
                    break;

                case R.styleable.DateView_isFancyText:
                    isFancyText = a.getBoolean(attr, false);
                    fancyText();
                    break;
            }
        }
        a.recycle();
    }

    public DateView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setDate();
    }

    private void setDate() {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy" + delimiter + "MM" + delimiter + "dd");
        String today = dateFormat.format(Calendar.getInstance().getTime());
        setText(today);  // self = DateView = subclass of TextView
    }

    private void fancyText() {
        if( this.isFancyText){
            setShadowLayer(9, 1, 1, Color.rgb(44, 44, 40));
        } else {
            setShadowLayer(0,0,0, Color.rgb(0, 0, 0));
        }
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        setDate();
    }

    public void setFancyText(boolean isFancyText) {
        this.isFancyText = isFancyText;
        fancyText();
    }
}