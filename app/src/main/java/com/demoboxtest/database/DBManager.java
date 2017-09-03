package com.demoboxtest.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.demoboxtest.greendao.DaoMaster;

/**
 * Created by Administrator on 2017/9/3.
 */
/**
 * DevOpenHelper：创建SQLite数据库的SQLiteOpenHelper的具体实现
 DaoMaster：GreenDao的顶级对象，作为数据库对象、用于创建表和删除表
 DaoSession：管理所有的Dao对象，Dao对象中存在着增删改查等API
 */
public class DBManager {
    private final static String dbName = "test_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    private DBManager(Context context) {
        this.context = context;
        //创建数据库
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例引用
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可读 数据库
     */
    protected SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }


    /**
     * 获取可写 数据库
     */
    protected SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }






















}
