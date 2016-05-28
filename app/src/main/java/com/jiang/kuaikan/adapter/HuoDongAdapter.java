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

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class HuoDongAdapter extends BaseAdapter{
    List<ReMenJson.DataBean.InfosBean.BannerBean> banners;
    Context mContext;

    public HuoDongAdapter( List<ReMenJson.DataBean.InfosBean.BannerBean> banners, Context context) {
        this.banners = banners;
        mContext = context;
    }

    @Override
    public int getCount() {
        return banners!=null?banners.size():0;
    }

    @Override
    public Object getItem(int i) {
        return banners.get(i);
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
            view= LayoutInflater.from(mContext).inflate(R.layout.huodong_item,null);
            holder.mImageView= (ImageView) view.findViewById(R.id.imageview);
            holder.mTextView= (TextView) view.findViewById(R.id.textview);


            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.mTextView.setText(banners.get(i).getTarget_title());

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

        x.image().bind(holder.mImageView,banners.get(i).getPic(),options);
        return view;
    }

    class ViewHolder{
        ImageView mImageView;
        TextView mTextView;
    }
}
