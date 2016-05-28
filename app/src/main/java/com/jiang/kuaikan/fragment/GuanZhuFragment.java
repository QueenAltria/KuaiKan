package com.jiang.kuaikan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiang.kuaikan.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class GuanZhuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.guanzhu_adapter_nologin,null);

        return view;
    }
}
