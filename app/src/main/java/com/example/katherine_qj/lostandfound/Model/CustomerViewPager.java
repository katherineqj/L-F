package com.example.katherine_qj.lostandfound.Model;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by Katherine-qj on 2016/10/25.
 */
public class CustomerViewPager extends RelativeLayout implements Runnable {
    private ViewPager viewPager;
    private LinearLayout viewDots;
    private List<ImageView> dots;
    private List<View> views;
    private int position;
    private boolean isContinue = true;
    private long changeTime = 1500;
    private int dotsSpacing = 2;
    private int circleRadio = 10;
    private boolean isAlive = true;
    private int gravity = Gravity.RIGHT;


    public CustomerViewPager(Context context) {
        this(context, null);
    }

    public CustomerViewPager(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomerViewPager(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }
    private void initView() {

    }

        @Override
    public void run() {

    }
}
