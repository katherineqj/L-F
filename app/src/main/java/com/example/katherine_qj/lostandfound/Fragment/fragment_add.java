package com.example.katherine_qj.lostandfound.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.katherine_qj.lostandfound.R;
import com.example.katherine_qj.lostandfound.Control.add_category_choice;
import com.example.katherine_qj.lostandfound.Control.add_find_activity;

/**
 * Created by Katherine-qj on 2016/9/4.
 */
public class fragment_add extends Fragment implements View.OnClickListener{
    private Button add_find_button;
    private Button add_get_button;
    private View rootview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview =inflater.inflate(R.layout.activity_add,null);
        InitView();
        return rootview;
    }
    public  void InitView(){
        add_find_button = (Button)rootview.findViewById(R.id.add_button_find);
        add_get_button = (Button)rootview.findViewById(R.id.add_button_get);
        add_get_button.setOnClickListener(this);
        add_find_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent();
        switch(v.getId()){
            case R.id.add_button_find:
                intent.setClass(getContext(),add_find_activity.class);
                startActivity(intent);
                break;
            case R.id.add_button_get:
                intent.setClass(getContext(),add_category_choice.class);
                startActivity(intent);
                break;
        }

    }
}
