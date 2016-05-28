package com.jiang.kuaikan.activitys;


import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jiang.kuaikan.R;
import com.jiang.kuaikan.fragment.DiscoverFragment;
import com.jiang.kuaikan.fragment.HomeFragment;
import com.jiang.kuaikan.fragment.UserFragment;
import com.jiang.kuaikan.listener.BaseUIListener;
import com.jiang.kuaikan.listener.Util;
import com.tencent.connect.common.Constants;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatService;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextView;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1,mRadioButton2,mRadioButton3;
    boolean isChecked=false;
    FragmentManager mFragmentManager=getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatConfig.setDebugEnable(true);  //打开debug开关，可查看mta上报日志或错误
        StatService.trackCustomEvent(this, "onCreate", ""); //调用统计接口，触发MTA并上报数据

        mRadioGroup= (RadioGroup) findViewById(R.id.radiogroup_main);
        mRadioButton1= (RadioButton) findViewById(R.id.radiobutton_home);
        mRadioButton2= (RadioButton) findViewById(R.id.radiobutton_discover);
        mRadioButton3= (RadioButton) findViewById(R.id.radiobutton_me);

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        HomeFragment homeFragment=new HomeFragment();
        transaction.replace(R.id.common_framlayout, homeFragment);
        transaction.commit();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radiobutton_home) {
                    mRadioButton3.setClickable(true);
                    FragmentTransaction transaction = mFragmentManager.beginTransaction();
                    HomeFragment homeFragment = new HomeFragment();
                    transaction.replace(R.id.common_framlayout, homeFragment);
                    transaction.commit();
                } else if (i == R.id.radiobutton_discover) {
                    mRadioButton3.setClickable(true);
                    FragmentTransaction transaction = mFragmentManager.beginTransaction();
                    DiscoverFragment discoverFragment = new DiscoverFragment();
                    transaction.replace(R.id.common_framlayout, discoverFragment);
                    transaction.commit();
                } else if (i == R.id.radiobutton_me) {
                    FragmentTransaction transaction = mFragmentManager.beginTransaction();
                    UserFragment mUserFragment = new UserFragment();
                    transaction.replace(R.id.common_framlayout, mUserFragment);
                    transaction.commit();
                    mRadioButton3.setClickable(false);

                }
            }
        });

    }


}
