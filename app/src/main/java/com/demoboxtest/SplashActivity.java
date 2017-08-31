package com.demoboxtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import module.start.SplashView;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions //标记需要运行时 判断的类
public class SplashActivity extends AppCompatActivity implements SplashView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);

    }


    @Override
    public void initContentView() {

    }

    @Override
    public void startWelcomeGuideActivity() {

    }

    @Override
    public void startHomeActivity() {

    }
}
