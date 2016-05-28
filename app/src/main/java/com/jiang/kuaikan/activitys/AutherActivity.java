package com.jiang.kuaikan.activitys;

import android.content.Intent;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.dao.AutherJson;
import com.meg7.widget.CircleImageView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class AutherActivity extends AppCompatActivity {
    ImageView mImageView;
    CircleImageView mCircleImageView;
    TextView mTextView1,mTextView2,mTextView3;
    List<AutherJson.DataBean.TopicsBean> topics=new ArrayList<>();
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auther);
        mCircleImageView= (CircleImageView) findViewById(R.id.circleimage);
        mTextView1= (TextView) findViewById(R.id.nickname);
        mTextView2= (TextView) findViewById(R.id.intro);
        mTextView3= (TextView) findViewById(R.id.weibo_name);
        mImageView= (ImageView) findViewById(R.id.back_image);
        mListView= (ListView) findViewById(R.id.listview);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent intent=getIntent();
        String id = intent.getStringExtra("id");
        RequestParams entity = new RequestParams("http://api.kuaikanmanhua.com/v1/users/"+id);
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                AutherJson autherJson = gson.fromJson(result, AutherJson.class);
                x.image().bind(mCircleImageView, autherJson.getData().getAvatar_url());
                mTextView1.setText(autherJson.getData().getNickname());
                mTextView2.setText(autherJson.getData().getIntro());
                mTextView3.setText(autherJson.getData().getWeibo_name() + "\n" + autherJson.getData().getWeibo());
                topics = autherJson.getData().getTopics();

                AutherAdapter autherAdapter=new AutherAdapter();
                mListView.setAdapter(autherAdapter);
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
    }

    class AutherAdapter extends BaseAdapter{

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
            view= LayoutInflater.from(AutherActivity.this).inflate(R.layout.auther_item,null);
            ImageView imageView= (ImageView) view.findViewById(R.id.zuopin_image);
            TextView textView1= (TextView) view.findViewById(R.id.zuopin_ming);
            TextView textView2= (TextView) view.findViewById(R.id.zuopin_jianjie);

            textView1.setText(topics.get(i).getTitle());
            textView2.setText(topics.get(i).getDescription());

            x.image().bind(imageView,topics.get(i).getCover_image_url());
            return view;
        }


    }
}
