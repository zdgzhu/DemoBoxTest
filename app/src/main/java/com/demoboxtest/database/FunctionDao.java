package com.demoboxtest.database;

import android.content.Context;

import com.demoboxtest.greendao.DaoMaster;
import com.demoboxtest.greendao.DaoSession;
import com.demoboxtest.greendao.FunctionBeanDao;
import com.demoboxtest.model.entities.FunctionBean;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/3.
 */

/**
 * DevOpenHelper：创建SQLite数据库的SQLiteOpenHelper的具体实现
 DaoMaster：GreenDao的顶级对象，作为数据库对象、用于创建表和删除表
 DaoSession：管理所有的Dao对象，Dao对象中存在着增删改查等API
 */
public class FunctionDao {

    private DBManager mDBManager;

    public FunctionDao(Context context) {
        mDBManager = DBManager.getInstance(context);
    }

    //========增删改查=================================
    /**
     * 插入一条
     */
    public void insertFunctionBean(FunctionBean functionBean) {
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(mDBManager.getWritableDatabase());
        //获取dao对象管理者
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao functionBeanDao = daoSession.getFunctionBeanDao();
        functionBeanDao.insert(functionBean);
    }


    /**
     * 插入用户集合
     */
    public void insertFunctionBeanList(List<FunctionBean> users) {
        if (users == null || users.isEmpty()) {
            return;
        }
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(mDBManager.getWritableDatabase());
        //获取dao对象管理者
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao functionBeanDao = daoSession.getFunctionBeanDao();
        functionBeanDao.insertOrReplaceInTx(users);
    }


    /**
     * 删除一条记录
     */
    public void deleteFunctionBean(FunctionBean user) {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao functionBeanDao = daoSession.getFunctionBeanDao();
        functionBeanDao.delete(user);
    }

    /**
     * 删除多个数据
     */
    public void deleteFunctionBeanList(List<FunctionBean> list) {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao functionBeanDao = daoSession.getFunctionBeanDao();
        functionBeanDao.deleteInTx(list);

    }

//删除所有记录
    public void deleteAllFunctionBean() {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao functionBeanDao = daoSession.getFunctionBeanDao();
        functionBeanDao.deleteAll();
    }




    /**
     * 更新一条记录
     */
    public void updateFunctionBean(FunctionBean user) {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao functionBeanDao = daoSession.getFunctionBeanDao();
        functionBeanDao.update(user);
    }


    /**
     * 更新多条记录
     */
    public void updateAllFunctionBean(List<FunctionBean> user) {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao userDao = daoSession.getFunctionBeanDao();
        userDao.updateInTx(user);
    }

    /**
     * 查询所欲的用户，没有附件条件
     */
    public List<FunctionBean>queryAllFunctionBeanList() {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao functionBeanDao = daoSession.getFunctionBeanDao();
        List<FunctionBean> list = functionBeanDao.queryBuilder().list();
        return list;
    }

    /**
     * 查询用户列表
     */
    public List<FunctionBean>queryFunctionBeanList() {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao functionBeanDao = daoSession.getFunctionBeanDao();
        QueryBuilder<FunctionBean> functionBeanQueryBuilder =
                functionBeanDao.queryBuilder();
        //根据id 进行升序排列
        List<FunctionBean> list = functionBeanQueryBuilder.orderAsc(FunctionBeanDao.Properties.Id).list();
        return list;
    }

    /**
     * 查询用户列表
     */
    public List<FunctionBean>queryFunctionBeanSmall() {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao userDao = daoSession.getFunctionBeanDao();
        QueryBuilder<FunctionBean> qb = userDao.queryBuilder();
        List<FunctionBean> list = qb.where(FunctionBeanDao.Properties.Mark.eq(1)).orderAsc(FunctionBeanDao.Properties.Id).list();
        return list;
    }


    /**
     * 查询用户列表
     */
    public List<FunctionBean>queryFunctionBeanListSmallNoMore() {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao userDao = daoSession.getFunctionBeanDao();
        QueryBuilder<FunctionBean> qb = userDao.queryBuilder();
        List<FunctionBean> list = qb.where(FunctionBeanDao.Properties.Mark.eq(1))
                .where(FunctionBeanDao.Properties.Name.notEq("更多"))
                .orderAsc(FunctionBeanDao.Properties.Id).list();
        return list;
    }


    /**
     * 查询用户列表
     */
    public List<FunctionBean>queryFunctionBeanListSmallNeed() {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao userDao = daoSession.getFunctionBeanDao();
        QueryBuilder<FunctionBean> qb = userDao.queryBuilder();
        List<FunctionBean> list = qb.where(FunctionBeanDao.Properties.Mark.eq(1))
                .orderAsc(FunctionBeanDao.Properties.Id)
                .limit(6)
                .list();
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

/**
 * 查询某个功能是否开启
 */

       public boolean queryFunctionBeanListIsOpen(String string) {
           DaoMaster daoMaster = new DaoMaster(mDBManager.getReadableDatabase());
           DaoSession daoSession = daoMaster.newSession();
           FunctionBeanDao userDao = daoSession.getFunctionBeanDao();
           QueryBuilder<FunctionBean> qb = userDao.queryBuilder();
           FunctionBean functionBean = qb.where(FunctionBeanDao.Properties.Code.eq(string)).uniqueOrThrow();
           return !(functionBean.getNotopen());
       }


    /**
     * 查询 更多   的位置
     */
    public int queryMoreFunctionBean() {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao userDao = daoSession.getFunctionBeanDao();
        QueryBuilder<FunctionBean> qb = userDao.queryBuilder();
        FunctionBean f = qb.where(FunctionBeanDao.Properties.Name.eq("更多")).uniqueOrThrow();
        return f.getId();

    }

    /**
     * 更新  更多   一条记录
     */
    public void updateMoreFunctionBean() {
        DaoMaster daoMaster = new DaoMaster(mDBManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        FunctionBeanDao userDao = daoSession.getFunctionBeanDao();
        QueryBuilder<FunctionBean> qb = userDao.queryBuilder();
        FunctionBean functionBean = qb.where(FunctionBeanDao.Properties.Name.eq("更多")).uniqueOrThrow();
        functionBean.setId(6);
        userDao.update(functionBean);
    }































}

/**        FunctionBeanDao functionBeanDao1 = new DaoMaster(mDBManager.getWritableDatabase()).newSession().getFunctionBeanDao();

 * 增加单个数据
 getShopDao().insert(shop);
 getShopDao().insertOrReplace(shop);
 增加多个数据
 getShopDao().insertInTx(shopList);
 getShopDao().insertOrReplaceInTx(shopList);
 查询全部
 List< Shop> list = getShopDao().loadAll();
 List< Shop> list = getShopDao().queryBuilder().list();
 查询附加单个条件
 .where()
 .whereOr()
 查询附加多个条件
 .where(, , ,)
 .whereOr(, , ,)
 查询附加排序
 .orderDesc()
 .orderAsc()
 查询限制当页个数
 .limit()
 查询总个数
 .count()
 修改单个数据
 getShopDao().update(shop);
 修改多个数据
 getShopDao().updateInTx(shopList);
 删除单个数据
 getTABUserDao().delete(user);
 删除多个数据
 getUserDao().deleteInTx(userList);
 删除数据ByKey
 getTABUserDao().deleteByKey();

 public FunctionBeanDao getShopDao()
 {
 FunctionBeanDao functionBeanDao1 = new DaoMaster(mDBManager.getWritableDatabase()).newSession().getFunctionBeanDao();
 return functionBeanDao1 ;

 }

 */
