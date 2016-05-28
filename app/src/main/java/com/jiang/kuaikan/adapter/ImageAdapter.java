package com.jiang.kuaikan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jiang.kuaikan.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 */
public class ImageAdapter extends BaseAdapter{
    List<String> list=new ArrayList<>();
    Context mContext;

    public ImageAdapter(List<String> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.image_item,null);
            holder=new ViewHolder();
            holder.mImageView= (ImageView) view.findViewById(R.id.everyimage);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        ImageOptions options = new ImageOptions.Builder()
                // 是否忽略GIF格式的图片
                .setIgnoreGif(false)
                        // 图片缩放模式
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                        // 下载中显示的图片
                .setLoadingDrawableId(R.drawable.ic_common_placeholder_l)
                        // 下载失败显示的图片
                .setFailureDrawableId(R.drawable.ic_common_placeholder_l)
                        // 得到ImageOptions对象
                .build();
        x.image().bind(holder.mImageView,list.get(i),options);

        return view;
    }

    class ViewHolder{
        ImageView mImageView;
    }
}
