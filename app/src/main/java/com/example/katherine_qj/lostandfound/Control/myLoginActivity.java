package com.example.katherine_qj.lostandfound.Control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.katherine_qj.lostandfound.Fragment.fragment_my;
import com.example.katherine_qj.lostandfound.Model.LfUser;
import com.example.katherine_qj.lostandfound.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Katherine-qj on 2016/10/13.
 */
public class myLoginActivity extends Activity implements View.OnClickListener {
    private Button loginBack;
    private Button buttonLogin;
    private Button buttonForgetpassword;
    private Button buttonSignup;
    private EditText editTextUsername;
    private EditText editTextPassword;

    private boolean mbDisplayFlag = false;
    private Button buttonSee;


    private String stringUsername;
    private String stringPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("qwe","登陆界面");
        setContentView(R.layout.activity_mylogin);
        initView();
    }
    public  void initView(){
        loginBack = (Button)findViewById(R.id.login_back);
        loginBack.setOnClickListener(this);
        editTextUsername = (EditText)findViewById(R.id.editTextUsername);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
        buttonForgetpassword = (Button)findViewById(R.id.buttonForgetpassword);
        buttonForgetpassword.setOnClickListener(this);
        buttonSignup = (Button)findViewById(R.id.buttonSignup);
        buttonSignup.setOnClickListener(this);
        buttonSee =(Button)findViewById(R.id.buttonSee);
        buttonSee.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_back:
                finish();
                overridePendingTransition(R.anim.out_alpha_b, R.anim.enter_alpha_b);
                break;
            case R.id.buttonLogin:
                stringUsername = editTextUsername.getText().toString();
                stringPassword = editTextPassword.getText().toString();
                if (stringUsername.equals("")) {
                    Toast.makeText(getApplicationContext(), "输入邮箱再登陆啦~", Toast.LENGTH_SHORT).show();
                }
                if (stringPassword.equals("")){
                    Toast.makeText(getApplicationContext(),"你还没有输入密码呢~~",Toast.LENGTH_SHORT).show();
                }else {
                    final LfUser  bmobUser = new LfUser();
                    bmobUser.setUsername(stringUsername);
                    bmobUser.setPassword(stringPassword);
                    bmobUser.login(getApplication(), new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Log.e("qwe", s);
                            if (s.equals("username or password incorrect.")){

                                Toast.makeText(getApplicationContext(), "用户名或密码不正确", Toast.LENGTH_SHORT).show();
                                editTextUsername.setText("");
                                editTextPassword.setText("");
                            }

                        }
                    });
                }


                break;
            case R.id.buttonSee:
                if (!mbDisplayFlag) {
                    Log.e("asd",mbDisplayFlag+"");
                    editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    buttonSee.setBackgroundResource(R.drawable.eeeb);
                } else {
                    Log.e("asd",mbDisplayFlag+"");
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    buttonSee.setBackgroundResource(R.drawable.eeed);
                }
                mbDisplayFlag = !mbDisplayFlag;
                editTextPassword.postInvalidate();
                Editable etext = editTextPassword.getText();
                Selection.setSelection(etext, etext.length());
            case  R.id.buttonForgetpassword:
                break;
            case  R.id.buttonSignup:
                Intent intent = new Intent(getApplicationContext(),myRegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
                finish();
                break;

        }
    }
}
