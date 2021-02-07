package com.xm6leefun.ocpayprogram;

import android.app.Application;

import com.onlychain.signsdk.wallet.base.ApiConfig;

/**
 * @Description:
 * @Author: hhh
 * @CreateDate: 2021/2/7 9:37
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApiConfig.init("http://39.98.135.66:9082");
    }
}
