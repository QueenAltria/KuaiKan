package com.jiang.kuaikan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.dao.SearchJson;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class SearchAdapter extends BaseAdapter{
    List<SearchJson.DataBean.TopicsBean> mTopicsBeans;
    Context mContext;

    public SearchAdapter(List<SearchJson.DataBean.TopicsBean> topicsBeans, Context context) {
        mTopicsBeans = topicsBeans;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mTopicsBeans!=null?mTopicsBeans.size():0;
    }

    @Override
    public Object getItem(int i) {
        return mTopicsBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.leibie_adapter_item,null);
            holder=new ViewHolder();
            holder.mImageView= (ImageView) view.findViewById(R.id.leibie_image);
            holder.mTextView1= (TextView) view.findViewById(R.id.manhuaming);
            holder.mTextView2= (TextView) view.findViewById(R.id.nicheng);
            holder.mTextView3= (TextView) view.findViewById(R.id.dianzan);
            holder.mTextView4= (TextView) view.findViewById(R.id.pinglun);

            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        String cover_image=mTopicsBeans.get(position).getCover_image_url();
        x.image().bind(holder.mImageView, cover_image);
        holder.mTextView1.setText(mTopicsBeans.get(position).getTitle());
        holder.mTextView2.setText(mTopicsBeans.get(position).getUser().getNickname());
        holder.mTextView3.setText(mTopicsBeans.get(position).getLikes_count() + "");
        holder.mTextView4.setText(mTopicsBeans.get(position).getComments_count() + "");


        return view;
    }

    class ViewHolder{
        ImageView mImageView;
        TextView mTextView1,mTextView2,mTextView3,mTextView4;
    }
}