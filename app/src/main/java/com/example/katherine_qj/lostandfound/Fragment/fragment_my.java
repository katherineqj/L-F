package com.example.katherine_qj.lostandfound.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.katherine_qj.lostandfound.Control.myLoginActivity;
import com.example.katherine_qj.lostandfound.Control.myModifyDataActivity;
import com.example.katherine_qj.lostandfound.Model.LfUser;
import com.example.katherine_qj.lostandfound.R;

import cn.bmob.v3.BmobUser;

/**
 * Created by Katherine-qj on 2016/9/4.
 */
public class fragment_my extends Fragment implements View.OnClickListener {
    private LinearLayout linearLayoutLogin;
    private View rootView;
    private LfUser onlineUser;
    private TextView myNickName;
    private TextView myIntroduce;
    private String myIcon;
    private String  stringMyNickName;
    private String  stringMyIntroduce;
    private String  stringMyPlace;


    private Button myButtonLogout;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.activity_my,null);
        initView();
        return rootView;
    }
    public void initView(){
        onlineUser = BmobUser.getCurrentUser(getActivity(), LfUser.class);
        myNickName = (TextView)rootView.findViewById(R.id.my_user_name);
        myIntroduce = (TextView)rootView.findViewById(R.id.my_introduce);
        myButtonLogout = (Button)rootView.findViewById(R.id.my_ButtonLogout);
        myButtonLogout.setOnClickListener(this);
        linearLayoutLogin = (LinearLayout)rootView.findViewById(R.id.Linear_login);
        linearLayoutLogin.setOnClickListener(this);
        if (onlineUser!=null){
            stringMyNickName = (String )BmobUser.getObjectByKey(getActivity(),"nickname");
            stringMyIntroduce = (String)BmobUser.getObjectByKey(getActivity(),"introduce");
            stringMyPlace = (String)BmobUser.getObjectByKey(getActivity(),"place");
            myNickName.setText(stringMyNickName);
            myIntroduce.setText(stringMyIntroduce);
            myButtonLogout.setBackgroundResource(R.drawable.sign_button_three);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent();
        switch (v.getId()){
            case R.id.Linear_login:
                if (onlineUser!=null){
                    intent.setClass(getContext(),myModifyDataActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nikename",stringMyNickName);
                    bundle.putString("introduce",stringMyIntroduce);
                    bundle.putString("place",stringMyPlace);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
                    //修改资料界面
                    break;

                }else{
                    //登陆界面
                    intent.setClass(getContext(),myLoginActivity.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
                    break;
                }
            case R.id.my_ButtonLogout:
                BmobUser.logOut(getActivity());   //清除缓存用户对象
                onlineUser = BmobUser.getCurrentUser(getActivity(), LfUser.class);
                myNickName.setText("请登录");
                myIntroduce.setText("查看或编辑个人资料");
                myButtonLogout.setBackgroundResource(R.drawable.sign_seletor_pressed);
        }
    }
}