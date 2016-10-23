package com.example.katherine_qj.lostandfound.Model;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.katherine_qj.lostandfound.R;

import org.w3c.dom.Text;

/**
 * Created by Katherine-qj on 2016/9/25.
 */
public class ImageButtonWithText extends LinearLayout {
    public ImageView imageView;
    public TextView textView;

    public ImageButtonWithText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageButtonWithText);
        int picture_id = a.getResourceId(R.styleable.ImageButtonWithText_picture,-1);
        a.recycle();
    }
}

