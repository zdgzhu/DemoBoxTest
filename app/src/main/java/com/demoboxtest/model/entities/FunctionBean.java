package com.demoboxtest.model.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/9/3.
 */

/**
 * @Entity：告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作
 @Id：对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
 @Property：可以自定义字段名，注意外键不能使用该属性
 @NotNull：属性不能为空
 @Transient：使用该注释的属性不会被存入数据库的字段中
 @Unique：该属性值必须在数据库中是唯一值
 @Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改
 */
@Entity
public class FunctionBean {

    /**
     * id : 1  //标记元素顺序
     * mark : 1  //标记元素类别
     * name : 万年历
     * code : calendar  //元素图标的名称
     */
    @Id(autoincrement = true)
    private Long functionId;

    private int id;
    private int mark;
    private String name;
    private String code;
    private boolean notopen;


    //下面这些是自动生成了 Rebuild Project 之后，就会自动生成这些
    @Generated(hash = 955933276)
    public FunctionBean(Long functionId, int id, int mark, String name, String code,
            boolean notopen) {
        this.functionId = functionId;
        this.id = id;
        this.mark = mark;
        this.name = name;
        this.code = code;
        this.notopen = notopen;
    }
    @Generated(hash = 1500552263)
    public FunctionBean() {
    }
    public Long getFunctionId() {
        return this.functionId;
    }
    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMark() {
        return this.mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public boolean getNotopen() {
        return this.notopen;
    }
    public void setNotopen(boolean notopen) {
        this.notopen = notopen;
    }


































}
