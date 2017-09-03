package com.demoboxtest;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.demoboxtest.activity.MainActivity;
import com.demoboxtest.config.Const;
import com.demoboxtest.module.start.WelcomeActivity;
import com.demoboxtest.module.start.api.SplashPresenter;
import com.demoboxtest.module.start.api.SplashView;
import com.demoboxtest.module.start.splash.SplashPresenterImpl;
import com.demoboxtest.utils.SPUtils;
import com.demoboxtest.utils.StateBarTranslucentUtils;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;

import application.MyApplication;
import io.reactivex.functions.Consumer;

public class SplashActivity extends AppCompatActivity implements SplashView {
    //启动页面加载动画
    private KenBurnsView mKenbruns;
    private ImageView mLogo;
    private TextView welcomeText;
    //判断是否是第一次登录的接口
    private SplashPresenter mPresenter;
    //动画
    private Animation anim;
    private ObjectAnimator alphaAnimation;
    //动态权限申请
    private RxPermissions rxPermissions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置主题
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);


        initView();
    }

    private void initView() {


        rxPermissions = new RxPermissions(this);
        mPresenter = new SplashPresenterImpl(this);

        //判断应用是否是第一次打开
        boolean isFirstOpen = (boolean) SPUtils.get(this, Const.FIRST_OPEN, false);
        mPresenter.isFirstOpen(isFirstOpen);

        //加载图片
        /**
         * with(Context context). 使用Application上下文，Glide请求将不受Activity/Fragment生命周期控制。
         with(Activity activity).使用Activity作为上下文，Glide的请求会受到Activity生命周期控制。
         with(FragmentActivity activity).Glide的请求会受到FragmentActivity生命周期控制。
         with(android.app.Fragment fragment).Glide的请求会受到Fragment 生命周期控制。
         with(android.support.v4.app.Fragment fragment).Glide的请求会受到Fragment生命周期控制。
         */
        setContentView(R.layout.activity_splash_layout);
        mKenbruns = (KenBurnsView) findViewById(R.id.ken_burn_images);
        mLogo = (ImageView) findViewById(R.id.logo_splash);
        welcomeText = (TextView) findViewById(R.id.welcome_text);

//        Glide.with(this)
//                .load(R.drawable.welcometoqbox)
//                .into(mKenbruns);
//
//        animation2();
//        animation3();

    }

    private void animation2() {
        mLogo.setAlpha(1.0F);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
        mLogo.startAnimation(anim);
    }

    private void animation3() {
        alphaAnimation = ObjectAnimator.ofFloat(welcomeText, "alpha", 0.0F, 1.0F);
        alphaAnimation.setStartDelay(1700);
        alphaAnimation.setDuration(500);
        alphaAnimation.start();
    }




    @Override
    public void initContentView() {
        setContentView(R.layout.activity_splash_layout);
        //设置状态栏透明
       StateBarTranslucentUtils.setStateBarTranslucent(this);
        mKenbruns = (KenBurnsView) findViewById(R.id.ken_burn_images);
        mLogo = (ImageView) findViewById(R.id.logo_splash);
        welcomeText = (TextView) findViewById(R.id.welcome_text);

        Glide.with(this)
                .load(R.drawable.welcometoqbox)
                .into(mKenbruns);

        animation2();
        animation3();
    }


    @Override
    public void startWelcomeGuideActivity() {
/**同时请求多个权限（合并结果）request
 * 同时请求多个权限（分别获取结果）
 如果想要在同时请求多个权限，又想分别获取授权结果的话，可以调用requestEach方法或者ensureEach方法
 */
        Logger.d("权限申请1");
        rxPermissions.request(Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Logger.d("权限申请2 :  aBoolean="+aBoolean);
                if (aBoolean) {
                    Logger.d("权限申请3");
                    WelcomeActivity.start(SplashActivity.this);
                    finish();
                } else {
                    Logger.d("权限申请失败");
                }
            }
        });


//
//        rxPermissions.requestEach(Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.CAMERA,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE)
//        .subscribe(new Consumer<Permission>() {
//            @Override
//            public void accept(Permission permission) throws Exception {
//
//        if (permission.name.equals(Manifest.permission.CAMERA)) {
//            if (permission.granted) {
//                String jpgPath = getCacheDir() + "test.jpg";
//                takePhotoByPath(jpgPath, 2);
//            } else {
//                //  未获取权限
//                Toast.makeText(MainActivity.this, "您没有授权该权限，请在设置中打开授权", Toast.LENGTH_SHORT).show();
//            }
//
//        } else if (permission.name.equals(Manifest.permission.READ_CONTACTS)) {
//
//        }
//            }
//        });
    }


    @Override
    public void startHomeActivity() {
        //除了第一次进入这个程序之外，以后每次打开这个程序，都会直接调用这个方法
        startActivity(new Intent(this, MainActivity.class));

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        MyApplication.getRefWatcher(this).watch(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mKenbruns != null) {
            mKenbruns.pause();
        }
        if (alphaAnimation != null) {
            alphaAnimation.cancel();

        }
        if (anim != null) {
            anim.cancel();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mKenbruns != null) {
            mKenbruns.resume();
        }
    }
}
