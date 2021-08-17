package com.wx.proxy.dbroute.db;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-17 16:21
 **/
public class DynamicDataSourceEntry {
    //default datasource
    public final static String DEFAULT_SOURCE=null;

    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    private  DynamicDataSourceEntry(){}
    //清空数据源
    public static void clear(){
        local.remove();
    }
    //获取当前正在使用额数据源
    public static String get(){return  local.get();}
    //还原当前切换的数据源
    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }
    //设置已知名字的数据源
    public static void set(String source){local.set(source);}
    //根据年份动态设置数据源
    public static void set(int year){local.set("DB_" + year);}

}
