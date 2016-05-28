package com.jiang.kuaikan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.dao.QuanJiJson;

import org.xutils.common.util.LogUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class TabRightAdapter extends RecyclerView.Adapter<TabRightAdapter.TabViewHolder> {
    List<QuanJiJson.DataBean.ComicsBean> mComicsBeans;
    Context mContext;

    public TabRightAdapter(List<QuanJiJson.DataBean.ComicsBean> comicsBeans, Context context) {
        mComicsBeans = comicsBeans;
        mContext = context;
    }

    @Override
    public TabRightAdapter.TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_right_adapter,null);
        return new TabViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TabViewHolder holder, int i) {
        holder.mTextView1.setText(mComicsBeans.get(i).getTitle());
        long time=mComicsBeans.get(i).getCreated_at();

        Long timestamp = time*1000;
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(timestamp));

        holder.mTextView2.setText(date);

        holder.mTextView3.setText(mComicsBeans.get(i).getLikes_count()+"");

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

        x.image().bind(holder.mImageView,mComicsBeans.get(i).getCover_image_url(),options);

        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

        }
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }



    @Override
    public int getItemCount() {
        return mComicsBeans.size();
    }

    class TabViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView1, mTextView2, mTextView3;
        public TabViewHolder(View itemView) {
            super(itemView);
            mImageView= (ImageView) itemView.findViewById(R.id.hua_image);
            mTextView1= (TextView) itemView.findViewById(R.id.hua_txt);
            mTextView2= (TextView) itemView.findViewById(R.id.time_txt);
            mTextView3= (TextView) itemView.findViewById(R.id.zan_txt);
        }
    }
}
