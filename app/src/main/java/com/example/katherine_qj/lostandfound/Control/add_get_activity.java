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
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.katherine_qj.lostandfound.Model.Get;
import com.example.katherine_qj.lostandfound.Model.LfUser;
import com.example.katherine_qj.lostandfound.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Katherine-qj on 2016/9/7.
 */
public class add_get_activity extends Activity  implements View.OnClickListener{
    private EditText Get_title;
    private EditText Get_time_place;
    private EditText Get_question;
    private EditText Get_contact;
    private EditText Get_answer;

    private TextView Get_type;

    private String Get_string_title;
    private String Get_string_time_place;
    private String Get_string_contact;
    private String Get_string_answer;
    private String Get_string_question;

    private Button  Get_button;
    private ImageButton Get_back;

    private LfUser onlineUser;

    private String stu;
    private String type;
    private String objectId;
    private Get get;

    private PopupWindow popupWindow;
    private LinearLayout layoutAgain;
    private LinearLayout layoutSee;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_get);
        InitView();
    }
    public void InitView(){
        Intent intent = getIntent();
        stu = intent.getStringExtra("stu");
        type = intent.getStringExtra("type");
        Get_type = (TextView)findViewById(R.id.get_type);
        Get_type.setText(type);
        onlineUser = BmobUser.getCurrentUser(getApplicationContext(), LfUser.class);
        objectId = onlineUser.getObjectId();
        Get_button = (Button)findViewById(R.id.get_button);
        Get_button.setOnClickListener(this);
        Get_back = (ImageButton)findViewById(R.id.get_back);
        Get_back .setOnClickListener(this);
        Get_title = (EditText)findViewById(R.id.get_title);
        Get_time_place = (EditText)findViewById(R.id.get_time_place);
        Get_question = (EditText)findViewById(R.id.get_question);
        Get_contact = (EditText)findViewById(R.id.get_contact);
        Get_answer = (EditText)findViewById(R.id.get_answer);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.get_button:
                InitEdit();
                if (isOk()){
                    get.save(this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            //   Toast.makeText(getApplicationContext(), "失物信息添加成功", Toast.LENGTH_SHORT).show();
                            showPopWindows();
                            backgroundAlpha(0.3f);
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(getApplicationContext(),s , Toast.LENGTH_SHORT).show();
                            Log.e("qqqq", s);
                        }
                    });
                }
                break;
            case R.id.get_back:
                finish();
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
                intent.putExtra("stu", "get");
                startActivity(intent);
                finish();
                break;

        }

    }
    public void InitEdit(){
        get = new Get();
        Get_string_title = Get_title.getText().toString().trim();
        Get_string_time_place = Get_time_place.getText().toString().trim();
        Get_string_contact = Get_contact.getText().toString().trim();
        Get_string_question = Get_question.getText().toString().trim();
        Get_string_answer = Get_answer.getText().toString().trim();

        get.setGet_title(Get_string_title);
        get.setGet_time_place(Get_string_time_place);
        get.setGet_contact(Get_string_contact);
        get.setGet_question(Get_string_question);
        get.setGet_answer(Get_string_answer);
        get.setStu(stu);
        get.setType(type);
        get.setUserid(objectId);

    }
    public boolean isOk(){
        if (TextUtils.isEmpty(Get_string_title)) {
            Toast.makeText(getApplicationContext(), "标题不能为空哦~", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(Get_string_contact)){
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
