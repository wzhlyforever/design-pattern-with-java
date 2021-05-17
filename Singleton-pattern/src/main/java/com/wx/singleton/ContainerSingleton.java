package com.wx.singleton;

import java.io.IOError;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: design-pattern-with-java
 * @description: 使用容器式单例解决大规模生产单例的问题
 * @author: Mr.Wang
 * @create: 2021-04-18 21:12
 **/
public class ContainerSingleton {
    private ContainerSingleton(){};


    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className){
        synchronized (ioc){
            if (!ioc.containsKey(className)){
                Object obj = null;
                try {
                    obj = Class.forName(className).getConstructor().newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            }else{
                return ioc.get(className);
            }
        }
    }


}
