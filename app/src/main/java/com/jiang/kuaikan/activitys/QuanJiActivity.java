package com.jiang.kuaikan.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.adapter.TabFragmentAdapter;
import com.jiang.kuaikan.dao.QuanJiJson;
import com.jiang.kuaikan.fragment.TabLeftFragment;
import com.jiang.kuaikan.fragment.TabRightFragment;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class QuanJiActivity extends AppCompatActivity {
    Toolbar mToolbar;
    ImageView mImageView,backImageView,guanzhuImageView;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanji);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //mToolbar.setTitleTextColor(Color.WHITE);
        //mToolbar.setBackgroundColor(getResources().getColor(R.color.colorTouMing));
        setSupportActionBar(mToolbar);

        mCollapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle("Title");

        mImageView = (ImageView) findViewById(R.id.imageview_top);
        backImageView= (ImageView) findViewById(R.id.back_image);
        guanzhuImageView= (ImageView) findViewById(R.id.guanzhu_iamge);

        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        RequestParams entity = new RequestParams("http://api.kuaikanmanhua.com/v1/topics/"+id+"?sort=0");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //LogUtil.e(result);
                Gson gson = new Gson();
                QuanJiJson quanJiJson = gson.fromJson(result, QuanJiJson.class);
                //mToolbar.setTitle(quanJiJson.getData().getTitle());

                String title = quanJiJson.getData().getTitle();
                LogUtil.e(title);
                mCollapsingToolbarLayout.setTitle(title);
                mCollapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);
                mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.RED);

                String cover_image_url = quanJiJson.getData().getCover_image_url();
                x.image().bind(mImageView, cover_image_url);

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


        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mTabLayout= (TabLayout) findViewById(R.id.tabs);
        //mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式，当前为系统默认模式
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        List<String> tabList = new ArrayList<>();
        tabList.add("简介");
        tabList.add("内容");
        mTabLayout.addTab(mTabLayout.newTab().setText("简介"));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText("内容"));


        mViewPager= (ViewPager) findViewById(R.id.viewPager);
        List<Fragment> fragmentList = new ArrayList<>();
        TabLeftFragment leftFragment=new TabLeftFragment();
        TabRightFragment rightFragment=new TabRightFragment();
        fragmentList.add(leftFragment);
        fragmentList.add(rightFragment);
        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
        mViewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        mViewPager.setCurrentItem(1);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器

    }


}
