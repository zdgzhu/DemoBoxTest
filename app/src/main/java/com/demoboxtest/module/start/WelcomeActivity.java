package com.demoboxtest.module.start;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.demoboxtest.R;
import com.demoboxtest.config.Const;
import com.demoboxtest.utils.SPUtils;
import com.demoboxtest.utils.StateBarTranslucentUtils;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    public static void start(Context context) {
        context.startActivity(new Intent(context, WelcomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //设置透明状态栏
        StateBarTranslucentUtils.setStateBarTranslucent(this);

        //
        findViewById(R.id.bRetry).setOnClickListener(this);

    }

    /**
     * 当第一次打开app时，保存3个大类别（历史上的今天，老黄历，笑话大全）到SharedPreferences
     */
    private void saveFunctionBigToSP() {
        SPUtils.put(this, Const.STAR_IS_OPEN, true);
        SPUtils.put(this, Const.STUFF_IS_OPEN, true);
        SPUtils.put(this, Const.JOKE_IS_OPEN, true);
    }

    /**
     * 当第一次打开app时，将功能类别存储到本地数据库
     */
    private void saveFunctionToDB() {
//        Function function = null;
//        function

    }


    @Override
    public void onClick(View v) {

    }



}
