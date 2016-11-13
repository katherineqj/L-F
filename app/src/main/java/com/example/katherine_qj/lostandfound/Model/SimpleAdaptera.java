package com.example.katherine_qj.lostandfound.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.katherine_qj.lostandfound.R;
import java.util.List;
/**
 * Created by Katherine-qj on 2016/11/6.
 */
public class SimpleAdaptera extends RecyclerView.Adapter<SimpleAdaptera.MyViewHolder>{
    private Context context;
    private LayoutInflater mInflater;
    private List<aItemModel> mDatas;
    public SimpleAdaptera (Context context,List<aItemModel> mDatas){
        this.context = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new MyViewHolder(mInflater.inflate(R.layout.itemsiglerecycleview,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.recycleViewString.setText(mDatas.get(position).getRVtype());
        Log.e("title",mDatas.get(position).getRVtype());
    }
    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView recycleViewString;
        TextView recycleViewType;

        public MyViewHolder(View view)
        {
            super(view);
            recycleViewString = (TextView) view.findViewById(R.id.recycleview_string);
            recycleViewType = (TextView)view.findViewById(R.id.recycleview_type);
        }
    }

}
