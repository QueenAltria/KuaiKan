package com.jiang.kuaikan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.dao.ReMenJson;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class MeiZhouAdapter extends BaseAdapter{
    List<ReMenJson.DataBean.InfosBean.TopicsBean> topics;
    Context mContext;

    public MeiZhouAdapter(List<ReMenJson.DataBean.InfosBean.TopicsBean> topics, Context context) {
        this.topics = topics;
        mContext = context;
    }

    @Override
    public int getCount() {
        return topics!=null?topics.size():0;
    }

    @Override
    public Object getItem(int i) {
        return topics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            holder=new ViewHolder();
            view= LayoutInflater.from(mContext).inflate(R.layout.meizhou_adapter,null);
            holder.mImageView= (ImageView) view.findViewById(R.id.imageview);
            holder.mTextView1= (TextView) view.findViewById(R.id.text_title);
            holder.mTextView2= (TextView) view.findViewById(R.id.text_auther);
            holder.mTextView3= (TextView) view.findViewById(R.id.num);

            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.mTextView1.setText(topics.get(i).getTitle());
        holder.mTextView2.setText(topics.get(i).getUser().getNickname());
        holder.mTextView3.setText((i+1)+"");
        x.image().bind(holder.mImageView,topics.get(i).getCover_image_url());
        return view;
    }

    class ViewHolder{
        ImageView mImageView;
        TextView mTextView1,mTextView2,mTextView3;
    }
}
