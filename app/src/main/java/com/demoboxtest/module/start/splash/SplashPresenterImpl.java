package com.demoboxtest.module.start.splash;

import com.demoboxtest.module.start.api.SplashInteractor;
import com.demoboxtest.module.start.api.SplashPresenter;
import com.demoboxtest.module.start.api.SplashView;

/**
 * Created by Administrator on 2017/9/1.
 */

/**
 * SplashPresenter: 主要是判断是否是第一次启动
 * SplashView:提供两个方法，一个是进入欢迎界面，一个是进入程序主界面
 */
public class SplashPresenterImpl implements SplashPresenter, SplashInteractor.OnEnterIntoFinishListener {
    private SplashView mSplashView;
    private SplashInteractor mSplashInteractor;

    public SplashPresenterImpl(SplashView mSplashView) {
        this.mSplashView = mSplashView;
        mSplashInteractor = new SplashInteractorImpl();
    }

    //这个方法是属于 SplashPresenter这个接口的
    @Override
    public void isFirstOpen(boolean isFirstOpen) {
        mSplashInteractor.enterInto(isFirstOpen, this);

    }

    @Override
    public void onDestroy() {
        mSplashView = null;
    }


    //判断，，如果是第一次打开这个程序，则弹出相关权限，让用户选择
    @Override
    public void isFirstOpen() {
        mSplashView.startWelcomeGuideActivity();
    }

    @Override
    public void isNotFirstOpen() {
        mSplashView.startHomeActivity();
    }

    @Override //初始化相关内容
    public void showContentView() {
        mSplashView.initContentView();
    }
}
