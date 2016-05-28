package com.jiang.kuaikan.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.activitys.LookAvtivity;
import com.jiang.kuaikan.activitys.LookTwoAvtivity;
import com.jiang.kuaikan.activitys.QuanJiActivity;
import com.jiang.kuaikan.adapter.GengXinAdapter;
import com.jiang.kuaikan.adapter.TabFragmentAdapter;
import com.jiang.kuaikan.dao.GengXinjson;
import com.jiang.kuaikan.views.CustomListView;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class DayFragment extends Fragment{
    ListView mListView;
    List<String> tabList=new ArrayList<>();
    String url;
    ImageView mImageView;
    TextView mTextView;
    SwipeRefreshLayout mSwipeRefreshLayout;

    List<GengXinjson.DataBean.ComicsBean> mComicsBeans=new ArrayList<>();

    public void setUrl(String url) {
        this.url = url;
    }

    public DayFragment() {
    }

    //不推荐这么写构造，不用
    @SuppressLint("ValidFragment")
    public DayFragment(String url) {
        this.url = url;
    }

    public static DayFragment newInstance(Bundle args) {
        DayFragment f = new DayFragment();
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.day_fragment, null);
        mListView= (ListView) view.findViewById(R.id.listview);

        mImageView= (ImageView) view.findViewById(R.id.imageview);
        mTextView= (TextView) view.findViewById(R.id.textview);
        mImageView.setVisibility(View.INVISIBLE);
        mTextView.setVisibility(View.INVISIBLE);

        mSwipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorYellow);

        getData();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        return view;
    }

    public void getData(){
        RequestParams entity = new RequestParams(url);
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                //LogUtil.e(result);
                final GengXinjson gengXinjson = gson.fromJson(result, GengXinjson.class);
                final List<GengXinjson.DataBean.ComicsBean> comics = gengXinjson.getData().getComics();
                GengXinAdapter gengXinAdapter = new GengXinAdapter(comics, DayFragment.this.getActivity());

                int totalHeight = 0;
                for (int i = 0; i < gengXinAdapter.getCount(); i++) {
                    View listItem = gengXinAdapter.getView(i, null, mListView);
                    listItem.measure(0, 0);
                    totalHeight += listItem.getMeasuredHeight();
                }

                //通过计算使ListView和ScollerView不冲突
                ViewGroup.LayoutParams params = mListView.getLayoutParams();
                params.height = totalHeight + (mListView.getDividerHeight() * (gengXinAdapter.getCount() - 1));
                params.height += 50;//if without this statement,the listview will be a little short
                mListView.setLayoutParams(params);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        GengXinjson.DataBean.ComicsBean comics1 = gengXinjson.getData().getComics().get(i);

                        Intent intent=new Intent(DayFragment.this.getActivity(), LookTwoAvtivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("gengxin",comics1);
                        intent.putExtra("gx_bd",bundle);
                        startActivity(intent);
                    }
                });

                mSwipeRefreshLayout.setRefreshing(false);

                mListView.setAdapter(gengXinAdapter);
                mImageView.setVisibility(View.VISIBLE);
                mTextView.setVisibility(View.VISIBLE);
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

