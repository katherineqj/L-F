package com.example.katherine_qj.lostandfound.Model;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.katherine_qj.lostandfound.R;

/**
 * Created by Katherine-qj on 2016/10/25.
 */
public class CustomerViewPager extends RelativeLayout implements Runnable {
   /* private ViewPager viewPager;
    private LinearLayout viewDots;
    private List<ImageView> dots;
    private List<View> views;//viewPager每一项
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
        viewPager = new ViewPager(getContext());
        ViewGroup.LayoutParams  viewPagerlp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(viewPager,viewPagerlp);



        viewDots = new LinearLayout(getContext());
        LayoutParams viewDotslp = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        viewDotslp.addRule(ALIGN_PARENT_BOTTOM);//动态设置布局的属性 在不同的条件下设置不同的布局排列方式
        viewDotslp.bottomMargin = dpTopx(5);
        viewDots.setGravity(gravity);
        addView(viewDots, viewDotslp);
    }

    public void setViewPagerViews(List<View> views){
        this.views = views;
        addDots(views.size());
        viewPager.setAdapter(new CustomerViewPageAdapter());
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int index) {
                position = index;
                for (int i = 0; i < dots.size(); i++) {
                    if (position == i) {
                        dots.get(i).setBackgroundResource(R.drawable.dot_focused);//修改成圆点图标
                    } else {
                        dots.get(i).setBackgroundResource(R.drawable.dot_normal);//
                    }
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        isContinue = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        isContinue = true;
                        break;
                    default:
                        isContinue = true;
                        break;
                }
                return false;
            }
        });
        new Thread(this).start();

    }

    private void addDots(int size){
        dots = new ArrayList<ImageView>();
        for (int i = 0; i < size; i++) {
            ImageView dot = new ImageView(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    dpTopx(circleRadio), dpTopx(circleRadio));
            params.setMargins(dpTopx(dotsSpacing), 0, dpTopx(dotsSpacing), 0);
            dot.setLayoutParams(params);
            if (i == 0) {
                dot.setBackgroundResource(R.drawable.dot_focused);//
            } else {
                dot.setBackgroundResource(R.drawable.dot_normal);//
            }
            dots.add(dot);
            viewDots.addView(dot);
        }

    }
    class CustomerViewPageAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return views==null? 0:views.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (views.get(position).getParent() != null) {
                ((ViewGroup) views.get(position).getParent()).removeView(views
                        .get(position));
            }
            container.addView(views.get(position));
            return views.get(position);
        }
        // 这个函数的实现的功能是创建指定位置的页面视图。适配器有责任增加即将创建的View视图到这里给定的container中，这是为了确保在finishUpdate(viewGroup)返回时this is be done!

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
        //该方法实现的功能是移除一个给定位置的页面。适配器有责任从容器中删除这个视图。这是为了确保在finishUpdate(viewGroup)返回时视图能够被移除。
        //这说明在 finishUpdate(viewGroup)执行完后，有两个操作，一个是原视图的移除（不再显示的视图），另一个是新增显示视图（即将显示的视图）
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        //功能：该函数用来判断instantiateItem(ViewGroup, int)函数所返回来的Key与一个页面视图是否是代表的同一个视图(即它俩是否是对应的，对应的表示同一个View)
    }

    Handler pagerHandler = new Handler(){
        public void handleMessage(android.os.Message mes){
          viewPager.setCurrentItem(mes.what);
            //setCurrentItem(int index)方法主要用来制定初始化的页面。例如加入3个页面通过setCurrentItem(0)制定第一个页面为当前页面
            super.handleMessage(mes);
        };
    };


        @Override
    public void run() {
            while (isAlive){
                if (isContinue){
                    pagerHandler.sendEmptyMessage(position);
                    position = (position+1) % views.size();
                    try {
                        Thread.sleep(changeTime);
                    }catch (InterruptedException e){

                    }
                }
            }

    }


    private int dpTopx(int dp) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
    public void stop() {
        isAlive = false;
    }*/
    /**
     * 要显示的ViewPage对象
     */
    private ViewPager viewPager;
    /**
     * 放置底部指示物的子视图
     */
    private LinearLayout viewDots;
    /**
     * viewDots上的指示物
     */
    private List<ImageView> dots;
    /**
     * ViewPage项
     */
    private List<View> views;
    /**
     * 当前显示第几张图
     */
    private int position = 0;
    /**
     * 可不可以自动轮转（为true当手触摸时不轮转）
     */
    private boolean isContinue = true;
    /**
     * 切换时间/ms
     */
    private long changeTime = 1500;

    /**
     * 底部指示物之间的间距，默认2dp
     */
    private int dotsSpacing = 2;

    /**
     * 底部指示物大小,默认7dp
     */
    private int circleRadio = 10;

    /**
     * 轮播图片线程是否存活
     */
    private boolean isAlive = true;
    /**
     * 底部指示物在父View(即viewDots视图)的gravity属性,默认在中间
     * Gravity.RIGHT | Gravity.LEFT | Gravity.CENTER
     */
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
        /**
         * 初始化ViewPage视图
         */
        viewPager = new ViewPager(getContext());
        LayoutParams viewPagerlp = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        addView(viewPager, viewPagerlp);
        /**
         * 初始化底部指示器视图
         */
        viewDots = new LinearLayout(getContext());
        LayoutParams viewDotslp = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        viewDotslp.addRule(ALIGN_PARENT_BOTTOM);
        viewDotslp.bottomMargin = dpTopx(5);
        viewDots.setGravity(gravity);
        addView(viewDots, viewDotslp);
    }

    public void setViewPageViews(List<View> views) {
        this.views = views;
        // 初始化底部的圆
        addDots(views.size());

        viewPager.setAdapter(new CustomerViewPageAdapter());
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int index) {
                position = index;
                for (int i = 0; i < dots.size(); i++) {
                    if (position == i) {
                        dots.get(i).setBackgroundResource(
                                R.drawable.dot_focused);
                    } else {
                        dots.get(i)
                                .setBackgroundResource(R.drawable.dot_normal);
                    }
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        viewPager.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        isContinue = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        isContinue = true;
                        break;
                    default:
                        isContinue = true;
                        break;
                }
                return false;
            }
        });
        new Thread(this).start();
    }

    private void addDots(int size) {
        dots = new ArrayList<ImageView>();
        for (int i = 0; i < size; i++) {
            ImageView dot = new ImageView(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    dpTopx(circleRadio), dpTopx(circleRadio));
            params.setMargins(dpTopx(dotsSpacing), 0, dpTopx(dotsSpacing), 0);
            dot.setLayoutParams(params);
            if (i == 0) {
                dot.setBackgroundResource(R.drawable.dot_focused);
            } else {
                dot.setBackgroundResource(R.drawable.dot_normal);
            }
            dots.add(dot);
            viewDots.addView(dot);
        }
    }

    class CustomerViewPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views == null ? 0 : views.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (views.get(position).getParent() != null) {
                ((ViewGroup) views.get(position).getParent()).removeView(views
                        .get(position));
            }
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

    }

    Handler pagerHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            viewPager.setCurrentItem(msg.what);
            super.handleMessage(msg);
        };
    };

    @Override
    public void run() {
        while (isAlive) {
            if (isContinue) {
                pagerHandler.sendEmptyMessage(position);
                position = (position + 1) % views.size();
                try {
                    Thread.sleep(changeTime);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private int dpTopx(int dp) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public void stop() {
        isAlive = false;
    }

}
