package com.example.katherine_qj.lostandfound;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.RadioGroup;

import com.example.katherine_qj.lostandfound.Control.myLoginActivity;
import com.example.katherine_qj.lostandfound.Fragment.fragment_add;
import com.example.katherine_qj.lostandfound.Fragment.fragment_find;
import com.example.katherine_qj.lostandfound.Fragment.fragment_more;
import com.example.katherine_qj.lostandfound.Fragment.fragment_my;
import com.example.katherine_qj.lostandfound.Fragment.fragment_squre;
import com.example.katherine_qj.lostandfound.Model.LfUser;


import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;


public class MainActivity extends FragmentActivity {
    private fragment_add Fragment_Add;
    private fragment_my Fragment_My;
    private fragment_squre Fragment_Squre;
    private fragment_more Fragment_More;
    private fragment_find Fragment_Find;
    private RadioGroup my_tab_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Bmob.initialize(this, "88a1bb065f68c21ff18afe308a6861a7");
      //  BmobUser onlineUser =  BmobUser.getCurrentUser(getApplicationContext());
        LfUser onlineUser = BmobUser.getCurrentUser(getApplicationContext(),LfUser.class);
        if (onlineUser!=null){



        }else{
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(),myLoginActivity.class);
            startActivity(intent);
        }
    }
    public void initView(){
        Fragment_Squre = new fragment_squre();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, Fragment_Squre).commit();
        my_tab_menu = (RadioGroup)findViewById(R.id.tab_menu);
        my_tab_menu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_squre:
                        Log.e("qwe","squre");
                        Fragment_Squre = new fragment_squre();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, Fragment_Squre).commit();
                        break;
                    case  R.id.rb_add:
                        Log.e("qwe","add");
                        Fragment_Add = new fragment_add();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, Fragment_Add).commit();
                        break;
                    case  R.id.rb_my:
                        Log.e("qwe","my");
                        Fragment_My = new fragment_my();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, Fragment_My).commit();
                        break;
                    case  R.id.rb_find:
                        Log.e("qwe","find");
                        Fragment_Find = new fragment_find();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, Fragment_Find).commit();
                        break;
                    case  R.id.rb_more:
                        Log.e("qwe","more");
                        Fragment_More = new fragment_more();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, Fragment_More).commit();
                        break;
                }
            }
        });
    }
}

