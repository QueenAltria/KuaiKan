package com.jiang.kuaikan.fragment;

import android.app.Fragment;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jiang.kuaikan.R;

public class UserFragment extends Fragment implements View.OnClickListener{
    private RelativeLayout mRelativeLayout1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_user_fragment,null);
        mRelativeLayout1= (RelativeLayout) view.findViewById(R.id.me_clickone);
        mRelativeLayout1.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.me_clickone:
                Toast.makeText(UserFragment.this.getActivity(), "点击", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
