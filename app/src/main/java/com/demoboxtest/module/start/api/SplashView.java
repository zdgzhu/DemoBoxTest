package com.demoboxtest.module.start.api;

/**
 * Created by Administrator on 2017/8/31.
 */

public interface SplashView {

    void initContentView();

    //回调这个方法，进入欢迎界面
    void startWelcomeGuideActivity();

    //回调这个方法，进入程序主界面
    void startHomeActivity();

}
