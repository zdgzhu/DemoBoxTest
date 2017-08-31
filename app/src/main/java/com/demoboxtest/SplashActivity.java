package com.demoboxtest;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

import module.start.WelcomeActivity;
import module.start.api.SplashPresenter;
import module.start.api.SplashView;
import module.start.splash.SplashPresenterImpl;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions //标记需要运行时 判断的类
public class SplashActivity extends AppCompatActivity implements SplashView {
    //启动页面加载动画
    private KenBurnsView mKenbruns;
    private ImageView mLogo;
    private TextView welcomeText;
    //判断是否是第一次登录的接口
    private SplashPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置主题
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);
        initView();
    }
    private void initView() {
        mKenbruns = (KenBurnsView) findViewById(R.id.ken_burn_images);
        mLogo = (ImageView) findViewById(R.id.logo_splash);
        welcomeText = (TextView) findViewById(R.id.welcome_text);
        mPresenter = new SplashPresenterImpl(this);

    }

    //=========================动态权限申请=====================================


    @Override
    public void initContentView() {

    }

    //进入下一个页面的回调方法
    @Override
    @NeedsPermission({Manifest.permission.READ_CONTACTS,
    Manifest.permission.ACCESS_FINE_LOCATION,
    Manifest.permission.CAMERA,
    Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void startWelcomeGuideActivity() {
        WelcomeActivity.start(this);
    }

    @Override
    public void startHomeActivity() {

    }













}
