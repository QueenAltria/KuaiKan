package com.jiang.kuaikan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.activitys.LeiBieActivity;
import com.jiang.kuaikan.adapter.FenLeiAdapter;
import com.jiang.kuaikan.common.Constants;
import com.jiang.kuaikan.dao.FenLeiJson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class FenLeiFragment extends Fragment{

    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    FenLeiAdapter mFenLeiAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fenlei_fragment, null);
        //setHasOptionsMenu(true);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        getData();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        return view;
    }


    public void getData() {
        RequestParams requestParams = new RequestParams(Constants.FENLEI);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                FenLeiJson fenLeiJson = gson.fromJson(result, FenLeiJson.class);
                int code = fenLeiJson.getCode();
                if (code == 200) {
                    FenLeiJson.DataBean data = fenLeiJson.getData();
                    final List<FenLeiJson.DataBean.SuggestionBean> suggestion = data.getSuggestion();
                    mFenLeiAdapter = new FenLeiAdapter(suggestion, FenLeiFragment.this.getActivity());
                    mRecyclerView.setLayoutManager(new GridLayoutManager(FenLeiFragment.this.getActivity(), 3));

                    mRecyclerView.setAdapter(mFenLeiAdapter);

                    mFenLeiAdapter.setOnItemClickLitener(new FenLeiAdapter.OnItemClickLitener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            String title=suggestion.get(position).getTitle();
                            Toast.makeText(FenLeiFragment.this.getActivity(), title, Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(FenLeiFragment.this.getActivity(), LeiBieActivity.class);
                            intent.putExtra("title",title);
                            startActivity(intent);

                        }

                        @Override
                        public void onItemLongClick(View view, int position) {

                        }
                    });

                    mSwipeRefreshLayout.setRefreshing(false);
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
