package com.jiang.kuaikan.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.adapter.ImageAdapter;
import com.jiang.kuaikan.dao.GengXinjson;
import com.jiang.kuaikan.dao.QuanJiJson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class LookTwoAvtivity extends AppCompatActivity {
    ListView mListView;
    Toolbar mToolbar;
    TextView mTextView;
    List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_avtivity);

        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        mTextView= (TextView) findViewById(R.id.look_title);
        mListView= (ListView) findViewById(R.id.listview);

        Intent intent=getIntent();
        Bundle bd = intent.getBundleExtra("gx_bd");
        GengXinjson.DataBean.ComicsBean comics = (GengXinjson.DataBean.ComicsBean) bd.getSerializable("gengxin");



        mToolbar.setTitle("");
        mTextView.setText(comics.getTitle());
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



        String url = comics.getUrl();

        RequestParams entity = new RequestParams(url);
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                chuliData(result);
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

    public void chuliData(String result){
        Document doc= Jsoup.parse(result);
        Elements links = doc.select("img");
        for (int i = 0; i < links.size(); i++) {
            String linkHref = links.get(i).attr("src");
            String substring = links.get(1).attr("src").substring(33, 39);
            if(linkHref.length()==63){
                if(linkHref.contains(substring))
                    list.add(linkHref);
                LogUtil.e(linkHref);
            }
        }
        ImageAdapter adapter=new ImageAdapter(list,LookTwoAvtivity.this);
        mListView.setAdapter(adapter);
    }


}
