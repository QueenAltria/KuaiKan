package com.jiang.kuaikan.fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.activitys.HomeSearchActivity;

/**
 * Created by Administrator on 2016/5/22.
 */
public class HomeFragment extends Fragment {
    Toolbar mToolbar;
    RadioGroup mRadioGroup;
    RadioButton mRadioButton1,mRadioButton2;
    ImageView mImageView;


    @Override
    public void setTargetFragment(Fragment fragment, int requestCode) {
        super.setTargetFragment(fragment, requestCode);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                //Toast.makeText(HomeFragment.this.getActivity(), "首页搜索测试", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
        //return true;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment,null);
        //setHasOptionsMenu(true);
        mToolbar= (Toolbar) view.findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        AppCompatActivity appCompatActivity= (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(mToolbar);

        mRadioGroup= (RadioGroup) view.findViewById(R.id.radiogroup);
        mRadioButton1= (RadioButton) view.findViewById(R.id.radiobutton_gaunzhu);
        mRadioButton2= (RadioButton) view.findViewById(R.id.radiobutton_gengxin);
        mImageView= (ImageView) view.findViewById(R.id.imageview_home);

        final GuanZhuFragment guanZhuFragment=new GuanZhuFragment();
        final GengXinFragment gengXinFragment=new GengXinFragment();
        final FragmentManager fragmentManager = HomeFragment.this.getActivity().getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.framelayout, guanZhuFragment)
                .add(R.id.framelayout, gengXinFragment)
                .attach(gengXinFragment)
                .detach(guanZhuFragment);
        transaction.commit();


        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobutton_gaunzhu:
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.attach(guanZhuFragment).detach(gengXinFragment);
                        transaction.commit();
                        break;
                    case R.id.radiobutton_gengxin:
                        FragmentTransaction transaction_1 = fragmentManager.beginTransaction();
                        transaction_1.attach(gengXinFragment).detach(guanZhuFragment);
                        transaction_1.commit();
                        break;
                }

            }
        });


        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(HomeFragment.this.getActivity(), "点击测试", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(HomeFragment.this.getActivity(), HomeSearchActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
