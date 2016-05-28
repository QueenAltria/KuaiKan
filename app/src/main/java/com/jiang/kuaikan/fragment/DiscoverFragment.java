package com.jiang.kuaikan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
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
import com.jiang.kuaikan.listener.RecyclerViewScrollListener;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/5/23.
 */
public class DiscoverFragment extends Fragment {
    Toolbar mToolbar;
    RadioGroup mRadioGroup;
    RadioButton mRadioButton1, mRadioButton2;
    ImageView mImageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_fragment, null);
        //setHasOptionsMenu(true);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        final AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(mToolbar);

        mRadioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
        mRadioButton1 = (RadioButton) view.findViewById(R.id.radiobutton_remen);
        mRadioButton2 = (RadioButton) view.findViewById(R.id.radiobutton_fenlei);
        mImageView = (ImageView) view.findViewById(R.id.imageview_discover);

        final ReMenFragment reMenFragment=new ReMenFragment();
        final FenLeiFragment fenLeiFragment=new FenLeiFragment();
        final FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout, reMenFragment)
                .add(R.id.framelayout, fenLeiFragment)
                .attach(reMenFragment)
                .detach(fenLeiFragment);
        fragmentTransaction.commit();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobutton_remen:
                        ReMenFragment reMen=new ReMenFragment();
                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                        fragmentTransaction1.replace(R.id.framelayout,reMen);
                        fragmentTransaction1.commit();
                        break;
                    case R.id.radiobutton_fenlei:
                        FenLeiFragment fenLei=new FenLeiFragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.framelayout, fenLei);
                        fragmentTransaction.commit();
                        break;

                }
            }
        });

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DiscoverFragment.this.getActivity(), "点击搜索", Toast.LENGTH_SHORT).show();
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

//                    mRecyclerView.addOnScrollListener(new RecyclerViewScrollListener() {
//                        @Override
//                        public void hide() {
//                            mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateDecelerateInterpolator());
//                        }
//
//                        @Override
//                        public void show() {
//                            mToolbar.animate().translationY(0).setInterpolator(new AccelerateDecelerateInterpolator());
//                        }
//                    });

//                    SpacesItemDecoration decoration = new SpacesItemDecoration(26);
//                    mRecyclerView.addItemDecoration(decoration);

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
