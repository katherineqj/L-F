package com.example.katherine_qj.lostandfound.Model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.katherine_qj.lostandfound.R;
import java.util.List;
/**
 * Created by Katherine-qj on 2016/11/6.
 */
public class SimpleAdaptera extends RecyclerView.Adapter<SimpleAdaptera.MyViewHolder>{
    private Context context;
    private LayoutInflater mInflater;
    private List<BmobModel> mDatas;
    private MyItemClickListener mClickListener;
    Resources r ;
    public SimpleAdaptera (Context context,List<BmobModel> mDatas){
        this.context = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);
        r = context.getResources();

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new MyViewHolder(mInflater.inflate(R.layout.itemsiglerecycleview,parent,false),mClickListener);
    }

    public void setmClickListener(MyItemClickListener listener){
        this.mClickListener = listener;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.recycleViewUserName.setText(mDatas.get(position).getRVuserid());
       // holder.recycleViewString.setText(mDatas.get(position).getRVgetTitle());
        holder.recycleViewString.setText(chageTitle(position));
        holder.recycleViewType.setText(mDatas.get(position).getRVtype());
        holder.recycleViewStuImage.setImageBitmap(BitmapFactory.decodeResource(r,chageStu(mDatas.get(position).getRVstu())));
       // holder.recycleViewStuImage.setImageBitmap(BitmapFactory.decodeResource(r,R.mipmap.get));
        //holder.recycleViewStuImage.setImageResource(R.mipmap.find);


    }
    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public  TextView recycleViewUserName;
        public  TextView recycleViewType;
        public  TextView recycleViewString;
        public  ImageView recycleViewStuImage;
        private MyItemClickListener myItemClickListener;

        public MyViewHolder(View view,MyItemClickListener myItemClickListener)
        {
            super(view);
            recycleViewUserName = (TextView) view.findViewById(R.id.recycleview_username);
            recycleViewType = (TextView)view.findViewById(R.id.recycleview_type);
            recycleViewString = (TextView)view.findViewById(R.id.recycleview_string);
            recycleViewStuImage = (ImageView)view.findViewById(R.id.recycleview_stu);
            this.myItemClickListener = myItemClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (myItemClickListener!=null){
                myItemClickListener.onItemClick(view,getPosition());
            }

        }
    }
    public int chageStu(String stu){
        if (stu.equals("find")){
            return R.mipmap.find;
        }else {
            return R.mipmap.get;
        }
    }
    public String  chageTitle(int position){
       String stu = mDatas.get(position).getRVstu();
        if (stu.equals("find")){
            return mDatas.get(position).getRVlostTitle();
        }else {
            return mDatas.get(position).getRVgetTitle();
        }
    }


}
