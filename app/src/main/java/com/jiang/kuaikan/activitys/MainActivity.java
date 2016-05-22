package com.jiang.kuaikan.activitys;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jiang.kuaikan.R;
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
    FragmentManager mFragmentManager=getFragmentManager();

    public static Tencent mTencent;
    IUiListener listener = new BaseUIListener(this){
        @Override
        public void onComplete(Object response) {
            super.onComplete(response);
            if (null == response) {
                //Util.showResultDialog(MainActivity.this, "返回为空", "登录失败");
                return;
            }
            JSONObject jsonResponse = (JSONObject) response;
            mTextView.setText(jsonResponse+"");
            if (null != jsonResponse && jsonResponse.length() == 0) {
                //Util.showResultDialog(MainActivity.this, "返回为空", "登录失败");
                return;
            }
            //Util.showResultDialog(MainActivity.this, response.toString(), "登录成功");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatConfig.setDebugEnable(true);  //打开debug开关，可查看mta上报日志或错误
        StatService.trackCustomEvent(this, "onCreate", ""); //调用统计接口，触发MTA并上报数据

        mButton= (Button) findViewById(R.id.qqlogin);
        mTextView= (TextView) findViewById(R.id.textView);
        mRadioGroup= (RadioGroup) findViewById(R.id.radiogroup_main);
        mRadioButton1= (RadioButton) findViewById(R.id.radiobutton_home);
        mRadioButton2= (RadioButton) findViewById(R.id.radiobutton_discover);
        mRadioButton3= (RadioButton) findViewById(R.id.radiobutton_me);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radiobutton_home){
                    mRadioButton3.setClickable(true);
                }else if(i==R.id.radiobutton_discover){
                    mRadioButton3.setClickable(true);
                }else if(i==R.id.radiobutton_me){
                    FragmentTransaction transaction = mFragmentManager.beginTransaction();
                    UserFragment mUserFragment=new UserFragment();
                    transaction.add(R.id.common_framlayout, mUserFragment);
                    transaction.commit();
                    mRadioButton3.setClickable(false);

                }
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login()
    {

        mTencent = Tencent.createInstance("1105414432", this.getApplicationContext());
        if (!mTencent.isSessionValid())
        {
            mTencent.login(this, "all", listener);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode,resultCode,data,listener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
