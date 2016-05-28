package com.jiang.kuaikan.common;

import android.app.Application;

import com.tencent.tauth.Tencent;

import org.xutils.x;

/**
 * Created by Administrator on 2016/5/21.
 */
public class ConfigApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
