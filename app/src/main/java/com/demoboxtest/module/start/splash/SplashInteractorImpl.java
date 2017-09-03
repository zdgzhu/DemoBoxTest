package com.demoboxtest.module.start.splash;

import android.os.Handler;

import com.demoboxtest.module.start.api.SplashInteractor;


/**
 * Created by Administrator on 2017/9/2.
 */

public class SplashInteractorImpl implements SplashInteractor {


    @Override
    public void enterInto(boolean isFirstOpen, final OnEnterIntoFinishListener listener) {
        //isFirst=false 表示第一次打开程序
        if (!isFirstOpen) {
            listener.isFirstOpen();
        } else {
            listener.showContentView();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.isNotFirstOpen();
                }
            }, 2000);
        }
    }
}
