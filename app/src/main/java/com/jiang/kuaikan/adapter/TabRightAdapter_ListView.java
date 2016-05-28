package com.jiang.kuaikan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.dao.QuanJiJson;

import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class TabRightAdapter_ListView extends BaseAdapter{
    private List<QuanJiJson.DataBean.ComicsBean> mComicsBeans;
    private Context mContext;

    public TabRightAdapter_ListView(List<QuanJiJson.DataBean.ComicsBean> comicsBeans, Context context) {
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
            view= LayoutInflater.from(mContext).inflate(R.layout.tab_right_adapter,null);
            holder=new ViewHolder();
            holder.mImageView= (ImageView) view.findViewById(R.id.hua_image);
            holder.mTextView1= (TextView) view.findViewById(R.id.hua_txt);
            holder.mTextView2= (TextView) view.findViewById(R.id.time_txt);
            holder.mTextView3= (TextView) view.findViewById(R.id.zan_txt);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.mTextView1.setText(mComicsBeans.get(i).getTitle());
        long time=mComicsBeans.get(i).getCreated_at();

        Long timestamp = time*1000;
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(timestamp));

        holder.mTextView2.setText(date);

        holder.mTextView3.setText(mComicsBeans.get(i).getLikes_count()+"");
        x.image().bind(holder.mImageView,mComicsBeans.get(i).getCover_image_url());


        return view;
    }

    class ViewHolder{
        ImageView mImageView;
        TextView mTextView1,mTextView2,mTextView3;
    }
}
