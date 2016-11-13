package com.example.katherine_qj.lostandfound.Control;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.katherine_qj.lostandfound.Model.LfUser;
import com.example.katherine_qj.lostandfound.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Katherine-qj on 2016/10/26.
 */
public class myModifyDataActivity  extends Activity implements View.OnClickListener{

    private LinearLayout myModifyIconLinear;
    private LinearLayout myModifyNicknameLinear;

    private LinearLayout   myModifyPlaceLinear;
    private LinearLayout myModifyIntroduceLinear;

    private ImageButton myModifyBack;

    private EditText myModifyNicknameEditText;

    private EditText myModifyPlaceEditText;
    private EditText myModifyIntroduceEditText;


    private String  myModifyNicknameString;
    private String myModifyPlaceString;
    private String myModifyIntroduceString;


    private TextView myModifyEmileTextview;

    private ImageView myModifyIconImageview;

    private LfUser onlineUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_data);
        InitView();

    }

    public void InitView(){
        onlineUser = BmobUser.getCurrentUser(getApplicationContext(), LfUser.class);
        myModifyIconLinear = (LinearLayout)findViewById(R.id.my_modify_icon_linear);
        myModifyNicknameLinear = (LinearLayout)findViewById(R.id.my_modify_nickname_linear);
        myModifyPlaceLinear = (LinearLayout)findViewById(R.id.my_modify_place_linear);
        myModifyIntroduceLinear = (LinearLayout)findViewById(R.id.my_modify_introduce_linear);

        myModifyBack = (ImageButton)findViewById(R.id.my_modify_back);
        myModifyBack.setOnClickListener(this);


        myModifyNicknameEditText = (EditText)findViewById(R.id.my_modify_nickname_edittext);
        myModifyPlaceEditText = (EditText)findViewById(R.id.my_modify_place_edittext);
        myModifyIntroduceEditText = (EditText)findViewById(R.id.my_modify_introduce_edittext);


        myModifyEmileTextview  = (TextView)findViewById(R.id.my_modify_emile_textview);
        myModifyIconImageview = (ImageView)findViewById(R.id.my_modify_icon_imageview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_modify_back:
                if(isOk()){
                    LfUser newuser = new LfUser();
                    newuser.setObjectId(onlineUser.getObjectId());
                    newuser.setNickname(myModifyNicknameString);
                    newuser.setPlace(myModifyPlaceString);
                    newuser.setIntroduce(myModifyIntroduceString);
                   /* newuser.setSessionToken(onlineUser.getSessionToken());
                    Log.e("bbbb",onlineUser.getSessionToken());*/


                   /* onlineUser.save(getApplicationContext(), new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });*/

                    newuser.update(getApplicationContext(),new UpdateListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(getApplicationContext(), "更新用户信息成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(getApplicationContext(),"更新用户信息失败："+ s.toString(), Toast.LENGTH_SHORT).show();
                            Log.e("eeee",s.toString());
                        }
                    });


                }
                break;

        }
    }
    public boolean isOk(){
        myModifyNicknameString = myModifyNicknameEditText.getText().toString().trim();

        myModifyPlaceString = myModifyPlaceEditText.getText().toString().trim();
        myModifyIntroduceString = myModifyIntroduceEditText.getText().toString().trim();
        if (myModifyNicknameString.length()>6){
            myModifyNicknameEditText.setText("");
            Toast.makeText(getApplicationContext(), "昵称要小于6个字符啊", Toast.LENGTH_SHORT).show();

            return false;
        }

        return  true;
    }

}
