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
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private EditText Lost_time_place;
    private EditText Lost_mailbox;
    private EditText Lost_phone;
    private EditText Lost_describe;
    private Button Lost_button;
    private ImageButton Lost_back;
    private Lost lost;
    private TextView find_type;

    private LfUser onlineUser;


    private String Lost_String_title;
    private String Lost_String_time_place;

    private String Lost_String_mailbox;
    private String Lost_String_phone;
    private String Lost_String_describe;

    private String stu;
    private String type;
    private String objectId;


    private PopupWindow popupWindow;
    private LinearLayout layoutAgain;
    private LinearLayout layoutSee;




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
        Lost_time_place = (EditText)findViewById(R.id.lost_time_place);
        Lost_mailbox = (EditText)findViewById(R.id.lost_mailbox);
        Lost_phone = (EditText)findViewById(R.id.lost_phone);
        Lost_describe = (EditText)findViewById(R.id.lost_describe);
        Lost_button = (Button)findViewById(R.id.lost_button);
        Lost_back = (ImageButton)findViewById(R.id.lost_back);
        Lost_button.setOnClickListener(this);
        Lost_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.lost_button:
                InitEdit();
                if (isOk()) {
                    lost.save(this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                         //   Toast.makeText(getApplicationContext(), "失物信息添加成功", Toast.LENGTH_SHORT).show();
                            showPopWindows();
                            backgroundAlpha(0.3f);
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
            case R.id.success_see:
                Toast.makeText(getApplicationContext(), "success_see", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;
            case R.id.success_again:
                Toast.makeText(getApplicationContext(), "success_again", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                intent.setClass(getApplicationContext(), add_category_choice.class);
                intent.putExtra("stu", "find");
                startActivity(intent);
                finish();
                break;

        }


    }
    public void InitEdit(){

        lost = new Lost();
        Lost_String_title = Lost_title.getText().toString().trim();
        Lost_String_time_place = Lost_time_place.getText().toString().trim();
        Lost_String_mailbox = Lost_mailbox.getText().toString().trim();
        Lost_String_phone = Lost_phone.getText().toString().trim();
        Lost_String_describe = Lost_describe.getText().toString().trim();

        lost.setLost_title(Lost_String_title);
        lost.setLost_time_place(Lost_String_time_place);
        lost.setLost_phone(Lost_String_phone);
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

       LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popwindows_success,null);
        layoutSee = (LinearLayout)layout.findViewById(R.id.success_see);
        layoutAgain = (LinearLayout)layout.findViewById(R.id.success_again);
        popupWindow = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        layoutSee.setOnClickListener(this);
        layoutAgain.setOnClickListener(this);
        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

    }
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
}

