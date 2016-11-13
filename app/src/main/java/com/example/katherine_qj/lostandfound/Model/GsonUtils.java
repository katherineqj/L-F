package com.example.katherine_qj.lostandfound.Model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Katherine-qj on 2016/11/6.
 */
public class GsonUtils<T> {

    public T jiexi(String info){
        try {
            Gson gson =new Gson();
            T a = gson.fromJson(info,new TypeToken<T>(){}.getType());
            return a;

        }catch (Exception ex){
            ex.printStackTrace();
            Log.e("qq", ex+ "");
            return null;
        }

    }
}
