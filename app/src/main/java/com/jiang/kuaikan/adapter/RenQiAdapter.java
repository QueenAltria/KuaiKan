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

import org.xutils.ImageManager;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class RenQiAdapter extends BaseAdapter{
    List<ReMenJson.DataBean.InfosBean.TopicsBean> topics;
    Context mContext;

    public RenQiAdapter(List<ReMenJson.DataBean.InfosBean.TopicsBean> topics, Context context) {
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
            view= LayoutInflater.from(mContext).inflate(R.layout.renqi_adapter,null);
            holder.mImageView= (ImageView) view.findViewById(R.id.imageview);
            holder.mTextView= (TextView) view.findViewById(R.id.textview);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        ImageOptions options = new ImageOptions.Builder()
                // 是否忽略GIF格式的图片
                .setIgnoreGif(false)
                        // 图片缩放模式
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                        // 下载中显示的图片
                .setLoadingDrawableId(R.drawable.ic_common_placeholder_ss)
                        // 下载失败显示的图片
                .setFailureDrawableId(R.drawable.ic_common_placeholder_ss)
                        // 得到ImageOptions对象
                .build();

        holder.mTextView.setText(topics.get(i).getTitle());

        x.image().bind(holder.mImageView, topics.get(i).getVertical_image_url(),options);
        return view;
    }

    class ViewHolder{
        ImageView mImageView;
        TextView mTextView;
    }
}
