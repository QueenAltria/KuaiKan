package com.jiang.kuaikan.activitys;

import android.content.Intent;

import com.jiang.kuaikan.listener.BaseUIListener;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/5/26.
 */
public class aaa {
//    public static Tencent mTencent;
//    IUiListener listener = new BaseUIListener(this){
//        @Override
//        public void onComplete(Object response) {
//            super.onComplete(response);
//            if (null == response) {
//                //Util.showResultDialog(MainActivity.this, "返回为空", "登录失败");
//                return;
//            }
//            JSONObject jsonResponse = (JSONObject) response;
//            mTextView.setText(jsonResponse+"");
//            if (null != jsonResponse && jsonResponse.length() == 0) {
//                //Util.showResultDialog(MainActivity.this, "返回为空", "登录失败");
//                return;
//            }
//            //Util.showResultDialog(MainActivity.this, response.toString(), "登录成功");
//
//        }
//    };
//
//
//    public void login()
//    {
//
//        mTencent = Tencent.createInstance("1105414432", this.getApplicationContext());
//        if (!mTencent.isSessionValid())
//        {
//            mTencent.login(this, "all", listener);
//        }
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == Constants.REQUEST_LOGIN) {
//            Tencent.onActivityResultData(requestCode,resultCode,data,listener);
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}
