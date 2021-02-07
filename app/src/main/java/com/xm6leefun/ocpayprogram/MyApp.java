package com.xm6leefun.ocpayprogram;

import android.app.Application;

import com.onlychain.signsdk.wallet.base.ApiConfig;
import com.xm6leefun.ocpayprogram.utils.ShowUtil;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

/**
 * @Description:
 * @Author: hhh
 * @CreateDate: 2021/2/7 9:37
 */
public class MyApp extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        //初始化
        ShowUtil.initialize(this);
        ApiConfig.init("http://39.98.135.66:9082");
    }
}
