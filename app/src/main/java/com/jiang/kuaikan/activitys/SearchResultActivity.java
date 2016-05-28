package com.jiang.kuaikan.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.adapter.SearchAdapter;
import com.jiang.kuaikan.dao.QuanJiJson;
import com.jiang.kuaikan.dao.SearchJson;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTextView;
    ListView mListView;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        mTextView= (TextView) findViewById(R.id.sousuo_title);
        mListView= (ListView) findViewById(R.id.listview);

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

        query(title);

    }

    public void query(String query){
        String xmString=null;
        String xmlUTF8=null;
        try {
            xmString = new String(query.getBytes("UTF-8"));
            xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        RequestParams entity = new RequestParams("http://api.kuaikanmanhua.com/v1/topics/search?keyword="+xmlUTF8+"&offset=0&limit=20");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                //LogUtil.e(result);
                SearchJson searchJson = gson.fromJson(result, SearchJson.class);
                final List<SearchJson.DataBean.TopicsBean> topics = searchJson.getData().getTopics();
                SearchAdapter adapter=new SearchAdapter(topics,SearchResultActivity.this);
                mListView.setAdapter(adapter);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(SearchResultActivity.this, QuanJiActivity.class);
                        String id=String.valueOf(topics.get(i).getId());
                        intent.putExtra("id",id);
                        startActivity(intent);
                    }
                });
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
