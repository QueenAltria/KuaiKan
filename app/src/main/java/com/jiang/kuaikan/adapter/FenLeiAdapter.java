package com.jiang.kuaikan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.dao.FenLeiJson;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/5/23.
 */
public class FenLeiAdapter extends RecyclerView.Adapter<FenLeiAdapter.FenLeiViewHolder>{
    private List<FenLeiJson.DataBean.SuggestionBean> mSuggestionBeans;
    private Context mContext;

    public FenLeiAdapter(List<FenLeiJson.DataBean.SuggestionBean> list, Context context) {
        mSuggestionBeans=list;
        mContext=context;
    }
    @Override
    public FenLeiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载数据item布局
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fenlei_adapter_item,null);
        return new FenLeiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FenLeiViewHolder holder, int position) {
        //数据绑定
        holder.mTextView.setText(mSuggestionBeans.get(position).getTitle());
        x.image().bind(holder.mImageView,mSuggestionBeans.get(position).getIcon());

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

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mSuggestionBeans.size();
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public static class FenLeiViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        public FenLeiViewHolder(View itemView) {
            super(itemView);
            mImageView= (ImageView) itemView.findViewById(R.id.fenlei_image);
            mTextView= (TextView) itemView.findViewById(R.id.fenlei_text);
        }
    }
}
