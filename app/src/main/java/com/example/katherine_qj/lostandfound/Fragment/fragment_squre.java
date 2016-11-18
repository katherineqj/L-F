package com.example.katherine_qj.lostandfound.Fragment;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.katherine_qj.lostandfound.MainActivity;
import com.example.katherine_qj.lostandfound.Model.BmobModel;
import com.example.katherine_qj.lostandfound.Model.CustomerViewPager;
import com.example.katherine_qj.lostandfound.Model.DividerGridItemDecoration;
import com.example.katherine_qj.lostandfound.Model.GsonUtils;
import com.example.katherine_qj.lostandfound.Model.MyItemClickListener;
import com.example.katherine_qj.lostandfound.Model.SimpleAdaptera;
import com.example.katherine_qj.lostandfound.Model.aItemModel;
import com.example.katherine_qj.lostandfound.Model.aModel;
import com.example.katherine_qj.lostandfound.Model.share;
import com.example.katherine_qj.lostandfound.Model.shareGsonUtils;
import com.example.katherine_qj.lostandfound.Model.sharegsonItemModel;
import com.example.katherine_qj.lostandfound.Model.sharegsonModel;
import com.example.katherine_qj.lostandfound.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindCallback;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Katherine-qj on 2016/9/4.
 */
public class fragment_squre extends Fragment implements MyItemClickListener {
    private RecyclerView mRecycleView;//只管回收和服用View 其他的需要自己去设置
    private List<share> mdates;
    private List<BmobModel> modelList ;
  //  private List<sharegsonItemModel>  modelList;
  //  private sharegsonModel sharegsonModel = new sharegsonModel();
    private SimpleAdaptera mAdapter;
    public CustomerViewPager viewPager;
    private List<View> views;
    public View rootview;
    public String jsonString;
    public GsonUtils<aModel> gsonUtils;
    private  aModel aModel ;
   //// private shareGsonUtils <sharegsonModel> shareGsonUtils = new shareGsonUtils<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.activity_squre, null);
        initViews();
        //initDatas();
        viewPager.setViewPageViews(views);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
   //     mRecycleView.setLayoutManager(linearLayoutManager);
        mRecycleView.setLayoutManager(new GridLayoutManager(getContext(),2));
        new Thread(new Runnable() {
            @Override
            public void run() {
                initDatas();

            }
        }).start();
        return rootview;
    }

     private Handler handler = new Handler(){
         @Override
         public void handleMessage(Message msg) {
             mAdapter = new SimpleAdaptera(getContext(), modelList);
             mAdapter.setmClickListener(fragment_squre.this);
           //  mAdapter.setmClickListener(getActivity());//问题出在this是当前 但需要上一级
             mRecycleView.setAdapter(mAdapter);
         }
     };

    private void initDatas() {
        BmobQuery query = new BmobQuery("share");
        query.findObjects(getContext(), new FindCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray) {
                //注意：查询结果是JSONArray
                try{
                    Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                    jsonString = jsonArray.toString();
                    aModel.setA(jiexi(jsonString));
                    modelList = aModel.getA();
                } catch (Exception e){
                    Log.e("error", e.toString());
                }
                for (int i = 0; i < modelList.size(); i++) {
                    Log.e("qq", i+"");
                }
                handler.sendEmptyMessage(0x000);
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
                Log.e("abc", "shibai");

            }
        });
    }

    public List<BmobModel> jiexi(String info){
        try {
            final Gson gson = new Gson();

            List<BmobModel> a = gson.fromJson(info, new TypeToken<List<BmobModel>>(){}.getType());
            Log.e("1","qwe");
            return a;
        }catch (Exception ex){
            ex.printStackTrace();
            Log.e("abc", ex.toString());
            return null;
        }

    }

        private void initViews () {
            viewPager = (CustomerViewPager) rootview.findViewById(R.id.vp);
            mRecycleView = (RecyclerView) rootview.findViewById(R.id.squerrecycleview);
            views = new ArrayList<>();
            modelList = new ArrayList<BmobModel>();
            aModel = new aModel();
            ImageView imageView1 = new ImageView(getActivity());
            ImageView imageView2 = new ImageView(getActivity());
            ImageView imageView3 = new ImageView(getActivity());
            ImageView imageView4 = new ImageView(getActivity());

            imageView1.setBackgroundResource(R.drawable.lunboa);
            views.add(imageView1);
            imageView2.setBackgroundResource(R.drawable.lunboc);
            views.add(imageView2);
            imageView3.setBackgroundResource(R.drawable.lunbob);
            views.add(imageView3);
            imageView4.setBackgroundResource(R.drawable.lunbod);
            views.add(imageView4);

        }

    @Override
    public void onItemClick(View view, int postion) {
            Toast.makeText(getContext(), postion+" ",Toast.LENGTH_SHORT).show();

    }
}
