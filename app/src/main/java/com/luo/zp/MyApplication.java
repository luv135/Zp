package com.luo.zp;

import android.app.Application;
import android.content.res.Configuration;

import com.luo.zp.network.NetService;

/**
 * Created by Luo on 2016/1/8.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetService.init();
    }
}
