package com.example.katherine_qj.lostandfound.Control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.katherine_qj.lostandfound.R;

/**
 * Created by Katherine-qj on 2016/9/20.
 */
public class add_category_choice extends Activity  implements View.OnClickListener{
    private Button addCategoryBack;
    private Button addCategoryWallet;
    private Button addCategoryPackagestu;
    private Button  addCategoryBciycle;
    private Button  addCategoryClothes;
    private Button addCategoryCrad;
    private Button addCategoryKey;
    private Button  addCategoryShuma;
    private Button addCategoryBook;
    private Button addCategoryOthers;
    private String stu;
    private String type;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_choice);
        InitView();
    }
    public  void InitView(){
        Intent intent = getIntent();
        stu = intent.getStringExtra("stu");
        addCategoryBack = (Button)findViewById(R.id.category_back);
        addCategoryBack.setOnClickListener(this);
        addCategoryWallet = (Button)findViewById(R.id.wallet);
        addCategoryWallet.setOnClickListener(this);
        addCategoryPackagestu = (Button)findViewById(R.id.packagestu);
        addCategoryPackagestu.setOnClickListener(this);
        addCategoryBciycle = (Button)findViewById(R.id.bciycle);
        addCategoryBciycle.setOnClickListener(this);
        addCategoryClothes = (Button)findViewById(R.id.clothes);
        addCategoryClothes.setOnClickListener(this);
        addCategoryCrad = (Button)findViewById(R.id.crad);
        addCategoryCrad.setOnClickListener(this);
        addCategoryKey = (Button)findViewById(R.id.key);
        addCategoryKey.setOnClickListener(this);
        addCategoryShuma = (Button)findViewById(R.id.shuma);
        addCategoryShuma.setOnClickListener(this);
        addCategoryBook = (Button)findViewById(R.id.books);
        addCategoryBook.setOnClickListener(this);
        addCategoryOthers = (Button)findViewById(R.id.others);
        addCategoryOthers.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.category_back:
                finish();
                break;
            case R.id.wallet:
                if (stu.equals("find")) {
                    intent.setClass(getApplicationContext(), add_find_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","钱包");
                    startActivity(intent);
                    finish();
                }else{
                    intent.setClass(getApplicationContext(), add_get_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","钱包");
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.packagestu:
                if (stu.equals("find")) {
                    intent.setClass(getApplicationContext(), add_find_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","书包");
                    startActivity(intent);
                    finish();
                }else{
                    intent.setClass(getApplicationContext(), add_get_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","书包");
                    startActivity(intent);
                    finish();
                }
                break;
            case  R.id.bciycle:
                if (stu.equals("find")) {
                    intent.setClass(getApplicationContext(), add_find_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","自行车");
                    startActivity(intent);
                    finish();
                }else{
                    intent.setClass(getApplicationContext(), add_get_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","自行车");
                    startActivity(intent);
                    finish();
                }
                break;
            case  R.id.clothes:
                if (stu.equals("find")) {
                    intent.setClass(getApplicationContext(), add_find_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","衣服");
                    startActivity(intent);
                    finish();
                }else{
                    intent.setClass(getApplicationContext(), add_get_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","衣服");
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.crad:
                if (stu.equals("find")) {
                    intent.setClass(getApplicationContext(), add_find_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","一卡通");
                    startActivity(intent);
                    finish();
                }else{
                    intent.setClass(getApplicationContext(), add_get_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","一卡通");
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.key:
                if (stu.equals("find")) {
                    intent.setClass(getApplicationContext(), add_find_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","钥匙");
                    startActivity(intent);
                    finish();
                }else{
                    intent.setClass(getApplicationContext(), add_get_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","钥匙");
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.shuma:
                if (stu.equals("find")) {
                    intent.setClass(getApplicationContext(), add_find_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","数码");
                    startActivity(intent);
                    finish();
                }else{
                    intent.setClass(getApplicationContext(), add_get_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","数码");
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.books:
                if (stu.equals("find")) {
                    intent.setClass(getApplicationContext(), add_find_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","书籍");
                    startActivity(intent);
                    finish();
                }else{
                    intent.setClass(getApplicationContext(), add_get_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","书籍");
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.others:
                if (stu.equals("find")) {
                    intent.setClass(getApplicationContext(), add_find_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","其他");
                    startActivity(intent);
                    finish();
                }else{
                    intent.setClass(getApplicationContext(), add_get_activity.class);
                    intent.putExtra("stu", stu);
                    intent.putExtra("type","其他");
                    startActivity(intent);
                    finish();
                }
                break;

        }

    }
}
