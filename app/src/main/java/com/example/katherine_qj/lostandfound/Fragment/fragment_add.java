package com.example.katherine_qj.lostandfound.Fragment;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

import com.example.katherine_qj.lostandfound.Control.myLoginActivity;
import com.example.katherine_qj.lostandfound.Model.LfUser;
import com.example.katherine_qj.lostandfound.R;
import com.example.katherine_qj.lostandfound.Control.add_category_choice;
import com.example.katherine_qj.lostandfound.Control.add_find_activity;

import cn.bmob.v3.BmobUser;

/**
 * Created by Katherine-qj on 2016/9/4.
 */
public class fragment_add extends Fragment implements View.OnClickListener {
    private Button add_find_button;
    private Button add_get_button;
    private View rootview;
    private LfUser onlineUser;
    private PopupWindow popupWindow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.activity_add, null);
        InitView();
        return rootview;
    }

    public void InitView() {

        onlineUser = BmobUser.getCurrentUser(getActivity(), LfUser.class);
        add_find_button = (Button) rootview.findViewById(R.id.add_button_find);
        add_get_button = (Button) rootview.findViewById(R.id.add_button_get);
        add_get_button.setOnClickListener(this);
        add_find_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.add_button_find:
                if (onlineUser != null) {
                    intent.setClass(getContext(), add_category_choice.class);
                    intent.putExtra("stu", "find");
                    startActivity(intent);
                    break;
                } else {
                    showPopWindows();
                    break;
                }
            case R.id.add_button_get:
                if (onlineUser != null) {
                    intent.setClass(getContext(), add_category_choice.class);
                    intent.putExtra("stu", "get");
                    startActivity(intent);
                    break;

                } else {
                    showPopWindows();
                    break;
                }

        }

    }

    private void showPopWindows() {

        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.popwindows_login, null);
        popupWindow = new PopupWindow(contentView,WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popupWindow.showAtLocation(rootview, Gravity.CENTER, 0, 0);
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });


    }
}
