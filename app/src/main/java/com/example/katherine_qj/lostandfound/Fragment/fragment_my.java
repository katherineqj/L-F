package com.example.katherine_qj.lostandfound.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;




import com.example.katherine_qj.lostandfound.Control.myLoginActivity;
import com.example.katherine_qj.lostandfound.R;


/**
 * Created by Katherine-qj on 2016/9/4.
 */
public class fragment_my extends Fragment implements View.OnClickListener {
    private LinearLayout linearLayoutLogin;
    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.activity_my,null);
        initView();
        return rootView;
    }
    public void initView(){
        linearLayoutLogin = (LinearLayout)rootView.findViewById(R.id.Linear_login);
        linearLayoutLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent();
        switch (v.getId()){
            case R.id.Linear_login:
                intent.setClass(getContext(),myLoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.out_alpha,R.anim.enter_alpha);
                break;
        }
    }
}