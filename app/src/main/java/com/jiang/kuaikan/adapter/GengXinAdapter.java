package com.jiang.kuaikan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.dao.GengXinjson;

import org.xutils.common.util.LogUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class GengXinAdapter extends BaseAdapter{
    List<GengXinjson.DataBean.ComicsBean> mComicsBeans;
    Context mContext;

    public GengXinAdapter(List<GengXinjson.DataBean.ComicsBean> comicsBeans, Context context) {
        mComicsBeans = comicsBeans;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mComicsBeans!=null?mComicsBeans.size():0;
    }

    @Override
    public Object getItem(int i) {
        return mComicsBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.gengxin_item,null);
            holder=new ViewHolder();
            holder.mImageView= (ImageView) view.findViewById(R.id.cover_image);
            holder.mTextView1= (TextView) view.findViewById(R.id.label_text);
            holder.mTextView2= (TextView) view.findViewById(R.id.title);
            holder.mTextView3= (TextView) view.findViewById(R.id.nickname_txt);
            holder.mTextView4= (TextView) view.findViewById(R.id.dijihua);
            holder.mTextView5= (TextView) view.findViewById(R.id.dianzan);
            holder.mTextView6= (TextView) view.findViewById(R.id.pinglun);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.mTextView1.setText(mComicsBeans.get(i).getLabel_text());

        holder.mTextView2.setText(mComicsBeans.get(i).getTopic().getTitle());

        holder.mTextView3.setText(mComicsBeans.get(i).getTopic().getUser().getNickname());

        holder.mTextView4.setText(mComicsBeans.get(i).getTitle());

        holder.mTextView5.setText(mComicsBeans.get(i).getLikes_count()+"");

        holder.mTextView6.setText(mComicsBeans.get(i).getComments_count() + "");

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

        x.image().bind(holder.mImageView, mComicsBeans.get(i).getCover_image_url(),options);


        return view;
    }

    class ViewHolder{
        ImageView mImageView;
        TextView mTextView1,mTextView2,mTextView3;
        TextView mTextView4,mTextView5,mTextView6;
    }
}
