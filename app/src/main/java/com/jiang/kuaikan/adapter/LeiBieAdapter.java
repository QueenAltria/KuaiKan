package com.jiang.kuaikan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.dao.LeiBieJson;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24.
 */
public class LeiBieAdapter extends RecyclerView.Adapter<LeiBieAdapter.LeiBieViewHolder>{
    private Context mContext;
    private List<LeiBieJson.DataBean.TopicsBean> mTopicsBeans;

    public LeiBieAdapter(Context context, List<LeiBieJson.DataBean.TopicsBean> topicsBeans) {
        mContext = context;
        mTopicsBeans = topicsBeans;
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
    public LeiBieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.leibie_adapter_item,null);
        return new LeiBieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final LeiBieViewHolder holder, int position) {
        String cover_image=mTopicsBeans.get(position).getCover_image_url();
        x.image().bind(holder.mImageView,cover_image);
        holder.mTextView1.setText(mTopicsBeans.get(position).getTitle());
        holder.mTextView2.setText(mTopicsBeans.get(position).getUser().getNickname());
        holder.mTextView3.setText(mTopicsBeans.get(position).getLikes_count()+"");
        holder.mTextView4.setText(mTopicsBeans.get(position).getComments_count()+"");

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


    @Override
    public int getItemCount() {
        return mTopicsBeans.size();
    }

    class LeiBieViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTextView1,mTextView2,mTextView3,mTextView4;
        public LeiBieViewHolder(View itemView) {
            super(itemView);
            mImageView= (ImageView) itemView.findViewById(R.id.leibie_image);
            mTextView1= (TextView) itemView.findViewById(R.id.manhuaming);
            mTextView2= (TextView) itemView.findViewById(R.id.nicheng);
            mTextView3= (TextView) itemView.findViewById(R.id.dianzan);
            mTextView4= (TextView) itemView.findViewById(R.id.pinglun);
        }
    }
}
