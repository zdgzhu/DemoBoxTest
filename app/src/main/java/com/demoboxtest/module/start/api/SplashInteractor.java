package com.demoboxtest.module.start.api;

/**
 * Created by Administrator on 2017/9/2.
 * Interactor:关联
 */

public interface SplashInteractor {

    void enterInto(boolean isFirstOpen, OnEnterIntoFinishListener listener);

    public interface OnEnterIntoFinishListener {
        void isFirstOpen();//这个方法表示是第一次打开程序
        //进入homeactivity
        void isNotFirstOpen();//这个方法表示不是第一次打开这个程序

        void showContentView();
    }

}
