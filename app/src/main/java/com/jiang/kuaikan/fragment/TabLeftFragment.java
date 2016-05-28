package com.jiang.kuaikan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.activitys.AutherActivity;
import com.jiang.kuaikan.dao.QuanJiJson;
import com.meg7.widget.CircleImageView;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/5/25.
 */
public class TabLeftFragment extends Fragment{
    TextView mTextView1,mTextView2;
    CircleImageView mImageView;
    RelativeLayout mRelativeLayout;
    String autherid;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tableft_fragment,null);
        mTextView1= (TextView) view.findViewById(R.id.tableft_txt);
        mImageView= (CircleImageView) view.findViewById(R.id.tableft_image);
        mTextView2= (TextView) view.findViewById(R.id.authername);
        mRelativeLayout= (RelativeLayout) view.findViewById(R.id.relativelayout);

        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TabLeftFragment.this.getActivity(), AutherActivity.class);
                intent.putExtra("id",autherid);
                startActivity(intent);
            }
        });

        Intent intent = this.getActivity().getIntent();
        String id=intent.getStringExtra("id");
        RequestParams entity = new RequestParams("http://api.kuaikanmanhua.com/v1/topics/"+id+"?sort=0");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //LogUtil.e(result);
                Gson gson = new Gson();
                QuanJiJson quanJiJson = gson.fromJson(result, QuanJiJson.class);
                String description = quanJiJson.getData().getDescription();
                LogUtil.e(description);
                mTextView1.setText(description);
                String nickname = quanJiJson.getData().getUser().getNickname();
                mTextView2.setText(nickname);
                String avatar_url = quanJiJson.getData().getUser().getAvatar_url();
                x.image().bind(mImageView, avatar_url);

                autherid =String.valueOf(quanJiJson.getData().getUser().getId());


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

        return view;
    }


}
