package com.jiang.kuaikan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.activitys.LookAvtivity;
import com.jiang.kuaikan.adapter.TabRightAdapter;
import com.jiang.kuaikan.common.Constants;
import com.jiang.kuaikan.dao.QuanJiJson;
import com.meg7.widget.CircleImageView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public class TabRightFragment extends Fragment{
    RecyclerView mRecyclerView;
    TabRightAdapter mTabRightAdapter;
    LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(TabRightFragment.this.getActivity());

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabright_fragment,null);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.listview);
        Intent intent = this.getActivity().getIntent();
        String id=intent.getStringExtra("id");
        RequestParams entity = new RequestParams("http://api.kuaikanmanhua.com/v1/topics/"+id+"?sort=0");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //LogUtil.e(result);
                Gson gson = new Gson();
                final QuanJiJson quanJiJson = gson.fromJson(result, QuanJiJson.class);
                final List<QuanJiJson.DataBean.ComicsBean> comics = quanJiJson.getData().getComics();
                mRecyclerView.setLayoutManager(mLinearLayoutManager);
                mTabRightAdapter=new TabRightAdapter(comics,TabRightFragment.this.getActivity());
                mRecyclerView.setAdapter(mTabRightAdapter);

                mTabRightAdapter.setOnItemClickLitener(new TabRightAdapter.OnItemClickLitener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        QuanJiJson.DataBean data = quanJiJson.getData();
                        String url = comics.get(position).getUrl();
                        Intent intent=new Intent(TabRightFragment.this.getActivity(), LookAvtivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("position",position);
                        bundle.putSerializable("duixiang",data);
                        intent.putExtra("bd",bundle);
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

        return view;
    }


}
