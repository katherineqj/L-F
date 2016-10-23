package com.example.katherine_qj.lostandfound.Control;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.katherine_qj.lostandfound.Model.LfUser;
import com.example.katherine_qj.lostandfound.R;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Katherine-qj on 2016/10/20.
 */
public class myRegisterActivity extends Activity implements View.OnClickListener{
    private EditText registerEditTextUsername;
    private EditText registerEdittextPassword;
    private EditText registerEdittextPasswordTtwo;
    private Button buttonRegister;
    private Button registerButtonBack;
    private String registerStringUsername;
    private String registerStringPassword;
    private String registerStringPasswordTwo;
    private String regisnEmile;
    private String regisnPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myregister);
        InitView();
    }

    public void InitView() {
        registerEditTextUsername = (EditText) findViewById(R.id.registerEditTextUsername);
        registerEditTextUsername.setOnClickListener(this);
        registerEdittextPassword = (EditText) findViewById(R.id.registerEdittextPassword);
        registerEdittextPassword.setOnClickListener(this);
        registerEdittextPasswordTtwo = (EditText) findViewById(R.id.registerEdittextPassword_two
        );
        registerEdittextPasswordTtwo.setOnClickListener(this);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
        registerButtonBack = (Button)findViewById(R.id.registerButtonBack);
        registerButtonBack.setOnClickListener(this);
        regisnEmile = "\\w+@\\w{2,6}(\\.\\w{2,3})+";
        regisnPassword = "[_\\w]{6,12}";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonRegister:
                registerStringUsername = registerEditTextUsername.getText().toString()+"";
                registerStringPassword = registerEdittextPassword.getText().toString()+"";
                registerStringPasswordTwo = registerEdittextPasswordTtwo.getText().toString();
                if (registerStringUsername.equals("")){
                    Toast.makeText(getApplicationContext(), "输入邮箱再注册啦~", Toast.LENGTH_SHORT).show();
                    break;
                }else
                {
                    if(!registerStringUsername.matches(regisnEmile)){
                        Toast.makeText(getApplicationContext(), "请输入正确的邮箱格式~", Toast.LENGTH_SHORT).show();
                        registerEditTextUsername.setText("");
                        break;

                    }
                }
                if(registerStringPassword.equals("")){
                    Toast.makeText(getApplicationContext(), "输入密码再注册啦~", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    if (!registerStringPassword.equals(registerStringPasswordTwo)) {
                        Toast.makeText(getApplicationContext(), "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                        registerEdittextPassword.setText("");
                        registerEdittextPasswordTtwo.setText("");
                        break;
                    } else {
                        if (!registerStringPassword.matches(regisnPassword)) {
                            Toast.makeText(getApplicationContext(), "密码只能是6~12位的数字字母或下划线", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }

                LfUser newLfUser = new LfUser();
                newLfUser.setUsername(registerStringUsername);
                newLfUser.setPassword(registerStringPassword);
                newLfUser.signUp(getApplicationContext(), new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.registerButtonBack:
                finish();
                overridePendingTransition(R.anim.out_alpha_b, R.anim.enter_alpha_b);
                break;
        }

    }
}
