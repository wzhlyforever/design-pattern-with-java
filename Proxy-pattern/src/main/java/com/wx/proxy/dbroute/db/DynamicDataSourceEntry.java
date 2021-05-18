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

    public static void clear(){
        local.remove();
    }

    public static String get(){return  local.get();}

    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    public static void set(String source){local.set(source);}

    public static void set(int year){local.set("DB_" + year);}

}
