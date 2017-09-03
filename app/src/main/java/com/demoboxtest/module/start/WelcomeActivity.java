package com.demoboxtest.module.start;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.demoboxtest.R;
import com.demoboxtest.config.Const;
import com.demoboxtest.database.FunctionDao;
import com.demoboxtest.model.entities.Function;
import com.demoboxtest.model.entities.FunctionBean;
import com.demoboxtest.module.start.renderer.CustomTutorialSupprtFragment;
import com.demoboxtest.utils.SPUtils;
import com.demoboxtest.utils.StateBarTranslucentUtils;
import com.demoboxtest.utils.StreamUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.orhanobut.logger.Logger;

import java.util.List;

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
        Function function = null;
        try {
             function = (new Gson()).fromJson(StreamUtils.get(getApplicationContext(), R.raw.function), Function.class);
        } catch (JsonSyntaxException e) {
            Logger.e("读取raw文件的function.json文件异常" + e.getMessage());
        }
        if (function != null && function.getFunction() != null && function.getFunction().size() != 0) {
            List<FunctionBean> functionBeenList = function.getFunction();
            FunctionDao functionDao = new FunctionDao(getApplicationContext());
            functionDao.insertFunctionBeanList(functionBeenList);
        }
    }

    /**
     * 第一次打开App时，将news的所有类别保存到本地数据库
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRetry:

        }

    }
    public void replaceTutorialFragment() {
//        getSupportFragmentManager().beginTransaction()
//        .replace(R.id.container_welcome,new CustomTutorialSupprtFragment());
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
