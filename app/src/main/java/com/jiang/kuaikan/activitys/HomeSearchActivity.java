package com.jiang.kuaikan.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.adapter.SearchAdapter;
import com.jiang.kuaikan.dao.SearchJson;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class HomeSearchActivity extends AppCompatActivity {
    ListView mListView;
    EditText mEditText;
    TextView mTextView,wujieguo;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_search);
        mListView= (ListView) findViewById(R.id.listview);
        mEditText= (EditText) findViewById(R.id.edit_query);
        mTextView= (TextView) findViewById(R.id.textview);
        wujieguo= (TextView) findViewById(R.id.txtwujieguo);
        mImageView= (ImageView) findViewById(R.id.image);

        wujieguo.setVisibility(View.GONE);
        mImageView.setVisibility(View.GONE);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    String query=mEditText.getText().toString();
                    Intent intent=new Intent(HomeSearchActivity.this,SearchResultActivity.class);
                    intent.putExtra("title",query);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String query=mEditText.getText().toString();
                try {
                    String xmString = new String(query.getBytes("UTF-8"));
                    String xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");
                    query(xmlUTF8);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void query(String query){
        RequestParams entity = new RequestParams("http://api.kuaikanmanhua.com/v1/topics/search?keyword="+query+"&offset=0&limit=20");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                //LogUtil.e(result);
                SearchJson searchJson = gson.fromJson(result, SearchJson.class);
                List<SearchJson.DataBean.TopicsBean> topics = searchJson.getData().getTopics();
                if(topics.size()==0){
                    wujieguo.setVisibility(View.VISIBLE);
                    mImageView.setVisibility(View.VISIBLE);
                    mListView.setVisibility(View.GONE);
                }else if(topics.size()!=0){
                    wujieguo.setVisibility(View.GONE);
                    mImageView.setVisibility(View.GONE);
                    mListView.setVisibility(View.VISIBLE);
                    SearchAdapter adapter=new SearchAdapter(topics,HomeSearchActivity.this);
                    adapter.notifyDataSetChanged();
                    mListView.setAdapter(adapter);
                }

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
