package com.jiang.kuaikan.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.adapter.TabFragmentAdapter;
import com.jiang.kuaikan.dao.GengXinjson;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class GengXinFragment extends Fragment {
    TabLayout mTabLayout;
    ViewPager mViewPager;

    List<GengXinjson.DataBean.ComicsBean> mComicsBeans=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.gengxin_adapter,null);
        mTabLayout= (TabLayout) view.findViewById(R.id.xingqi_tab);
        mViewPager= (ViewPager) view.findViewById(R.id.viewpager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        List<String> tabList=new ArrayList<>();


        tabList.add(getWeekOfDate(6));
        tabList.add(getWeekOfDate(5));
        tabList.add(getWeekOfDate(4));
        tabList.add(getWeekOfDate(3));
        tabList.add(getWeekOfDate(2));
        tabList.add("昨天");
        tabList.add("今天");

        mTabLayout.addTab(mTabLayout.newTab().setText(getWeekOfDate(6)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getWeekOfDate(5)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getWeekOfDate(4)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getWeekOfDate(3)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getWeekOfDate(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText("昨天"));
        mTabLayout.addTab(mTabLayout.newTab().setText("今天"));



        List<Fragment> fragmentList = new ArrayList<>();
        DayFragment fragment=new DayFragment();
        fragment.setUrl("http://api.kuaikanmanhua.com/v1/daily/comic_lists/0?since=0");
        DayFragment fragment1=new DayFragment();
        fragment1.setUrl("http://api.kuaikanmanhua.com/v1/daily/comic_lists/1?since=0");
        DayFragment fragment2=new DayFragment();
        fragment2.setUrl("http://api.kuaikanmanhua.com/v1/daily/comic_lists/" + getUnix(3) + "?since=0");
        DayFragment fragment3=new DayFragment();
        fragment3.setUrl("http://api.kuaikanmanhua.com/v1/daily/comic_lists/" + getUnix(4)  + "?since=0");
        DayFragment fragment4=new DayFragment();
        fragment4.setUrl("http://api.kuaikanmanhua.com/v1/daily/comic_lists/" + getUnix(5)  + "?since=0");
        DayFragment fragment5=new DayFragment();
        fragment5.setUrl("http://api.kuaikanmanhua.com/v1/daily/comic_lists/" + getUnix(6)  + "?since=0");
        DayFragment fragment6=new DayFragment();
        fragment6.setUrl("http://api.kuaikanmanhua.com/v1/daily/comic_lists/" + getUnix(7)  + "?since=0");


        fragmentList.add(fragment6);
        fragmentList.add(fragment5);
        fragmentList.add(fragment4);
        fragmentList.add(fragment3);
        fragmentList.add(fragment2);
        fragmentList.add(fragment1);
        fragmentList.add(fragment);



        //fragmentList.add(new DayFragment());
        TabFragmentAdapter fragmentAdapter=new TabFragmentAdapter(GengXinFragment.this.getActivity().getSupportFragmentManager(),fragmentList,tabList);

        mViewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        mViewPager.setCurrentItem(6);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器
        fragmentAdapter.notifyDataSetChanged();


        return view;
    }

    public static String getWeekOfDate(int n) {
        List<String> list=new ArrayList<>();
        long l = System.currentTimeMillis()-86400000*n;
        Date date=new Date(l);
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public String getUnix(int n){
        String unix=String.valueOf((System.currentTimeMillis()-(86400000*n))/1000);
        return unix;
    }

}
