package com.xm6leefun.ocpayprogram.utils;

import android.app.Application;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * 加载弹窗管理
 */
public class ShowUtil {
    private static Application mApplicationContext;

    public static void initialize(Application application){
        mApplicationContext = application;
    }

    public static Application getApplication(){
        return mApplicationContext;
    }

}
