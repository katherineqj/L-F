package com.example.katherine_qj.lostandfound.Control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.katherine_qj.lostandfound.Model.LfUser;
import com.example.katherine_qj.lostandfound.Model.Lost;

import com.example.katherine_qj.lostandfound.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Katherine-qj on 2016/9/7.
 */
public class add_find_activity extends Activity implements View.OnClickListener{
    private EditText Lost_title;
    private EditText Lost_time;
    private EditText Lost_place;
    private EditText Lost_mailbox;
    private EditText Lost_phone;
    private EditText Lost_describe;
    private Button Lost_button;
    private Button Lost_back;
    private Lost lost;
    private TextView find_type;

    private LfUser onlineUser;


    private String Lost_String_title;
    private String Lost_String_time;
    private String Lost_String_place;
    private String Lost_String_mailbox;
    private String Lost_String_phone;
    private String Lost_String_describe;

    private String stu;
    private String type;
    private String objectId;


    private PopupWindow popupWindow;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_find);
        InitView();
    }
    public void InitView(){
        Intent intent = getIntent();
        stu = intent.getStringExtra("stu");
        type = intent.getStringExtra("type");
        onlineUser = BmobUser.getCurrentUser(getApplicationContext(), LfUser.class);
        objectId = onlineUser.getObjectId();
        find_type = (TextView)findViewById(R.id.lost_type);
        find_type.setText(type);
        Lost_title = (EditText)findViewById(R.id.lost_title);
        Lost_time = (EditText)findViewById(R.id.lost_time);
        Lost_place = (EditText)findViewById(R.id.lost_place);
        Lost_mailbox = (EditText)findViewById(R.id.lost_mailbox);
        Lost_phone = (EditText)findViewById(R.id.lost_phone);
        Lost_describe = (EditText)findViewById(R.id.lost_describe);
        Lost_button = (Button)findViewById(R.id.lost_button);
        Lost_back = (Button)findViewById(R.id.lost_back);
        Lost_button.setOnClickListener(this);
        Lost_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lost_button:
                InitEdit();
                if (isOk()) {
                    lost.save(this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(getApplicationContext(), "失物信息添加成功", Toast.LENGTH_SHORT).show();
                            showPopWindows();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(getApplicationContext(),s , Toast.LENGTH_SHORT).show();
                           Log.e("qqqq",s);
                        }
                    });
                }
                break;
            case R.id.lost_back:
                finish();
                break;
        }


    }
    public void InitEdit(){

        lost = new Lost();
        Lost_String_title = Lost_title.getText().toString().trim();
        Lost_String_time = Lost_time.getText().toString().trim();
        Lost_String_place = Lost_place.getText().toString().trim();
        Lost_String_mailbox = Lost_mailbox.getText().toString().trim();
        Lost_String_phone = Lost_phone.getText().toString().trim();
        Lost_String_describe = Lost_describe.getText().toString().trim();


        lost.setLost_title(Lost_String_title);
        lost.setLost_time(Lost_String_time);
        lost.setLost_phone(Lost_String_phone);
        lost.setLost_place(Lost_String_place);
        lost.setLost_mailbox(Lost_String_mailbox);
        lost.setLost_describe(Lost_String_describe);
        lost.setUserid(objectId);
        lost.setStu(stu);
        lost.setType(type);
    }
    public boolean  isOk(){
        if (TextUtils.isEmpty(Lost_String_title)) {
            Toast.makeText(getApplicationContext(), "标题不能为空哦~", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(Lost_String_mailbox)&&TextUtils.isEmpty(Lost_String_phone)){
            Toast.makeText(getApplicationContext(), "不都说了邮箱和电话要留下一个嘛", Toast.LENGTH_SHORT).show();
            return false;
        }
        return  true;
    }
    private void showPopWindows() {

        View contentView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.popwindows_success, null);
        popupWindow = new PopupWindow(contentView, WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
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

