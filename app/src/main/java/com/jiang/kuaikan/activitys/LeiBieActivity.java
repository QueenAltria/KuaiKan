package com.jiang.kuaikan.activitys;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.adapter.LeiBieAdapter;
import com.jiang.kuaikan.common.Constants;
import com.jiang.kuaikan.dao.LeiBieJson;
import com.jiang.kuaikan.listener.EndlessRecyclerOnScrollListener;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class LeiBieActivity extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTextView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView mRecyclerView;
    List<LeiBieJson.DataBean.TopicsBean> list = new ArrayList<>();
    LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
    LeiBieAdapter mLeiBieAdapter;
    String title;
    int n = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei_activoity);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTextView = (TextView) findViewById(R.id.fenlei_title);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorYellow);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        mToolbar.setTitle("");
        mTextView.setText(title);
        mToolbar.setNavigationIcon(R.drawable.ic_up_indicator);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mToolbar.setHorizontalFadingEdgeEnabled(true);
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getData(title);


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(title);
            }
        });
    }

    public void getData(String leibie) {
        RequestParams entity = new RequestParams(Constants.LEIBIE);
        entity.addBodyParameter("offset", 0 + "");
        entity.addBodyParameter("limit", "20");
        entity.addBodyParameter("tag", leibie);
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                parseJson(result);
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

    public List<LeiBieJson.DataBean.TopicsBean> parseJson(String result) {

        Gson gson = new Gson();
        LeiBieJson leiBieJson = gson.fromJson(result, LeiBieJson.class);
        list = leiBieJson.getData().getTopics();

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        final LeiBieAdapter mLeiBieAdapter = new LeiBieAdapter(LeiBieActivity.this, list);
        mLeiBieAdapter.notifyDataSetChanged();

        mLeiBieAdapter.setOnItemClickLitener(new LeiBieAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                String id = list.get(position).getId()+"";
                Toast.makeText(LeiBieActivity.this, title, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(LeiBieActivity.this,QuanJiActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


        mSwipeRefreshLayout.setRefreshing(false);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == mLinearLayoutManager.getItemCount()) {
                    RequestParams entity = new RequestParams(Constants.LEIBIE);
                    n += 20;
                    entity.addBodyParameter("offset", n + "");
                    entity.addBodyParameter("limit", "20");
                    entity.addBodyParameter("tag", title);
                    x.http().get(entity, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String result) {
                            parseJson2(result);
                            mLeiBieAdapter.notifyDataSetChanged();

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
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
            }
        });

        mRecyclerView.setAdapter(mLeiBieAdapter);

        return list;

    }

    public List<LeiBieJson.DataBean.TopicsBean> parseJson2(String result) {

        Gson gson = new Gson();
        LeiBieJson leiBieJson = gson.fromJson(result, LeiBieJson.class);
        List<LeiBieJson.DataBean.TopicsBean> topics = new ArrayList<>();
        topics = leiBieJson.getData().getTopics();
        list.addAll(topics);
        LeiBieAdapter adapter = new LeiBieAdapter(LeiBieActivity.this, list);
        adapter.notifyDataSetChanged();
        return list;

    }
}
