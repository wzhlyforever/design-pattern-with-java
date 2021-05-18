package com.wx.proxy.dbroute.proxy;

import com.wx.proxy.dbroute.IOrderService;
import com.wx.proxy.dbroute.db.DynamicDataSourceEntry;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-17 17:07
 **/
public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private IOrderService target;


    public IOrderService getInstance(IOrderService target){
        this.target = target;
        final Class<? extends IOrderService> aClass = target.getClass();
        return (IOrderService) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    private void after() {
        System.out.println("Proxy after method");
        //还原成默认的数据源
        DynamicDataSourceEntry.restore();
    }

    //target 应该是订单对象Order
    private void before(Object target) {
        try {
            //进行数据源的切换
            System.out.println("Proxy before method");

            //约定优于配置
            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
            DynamicDataSourceEntry.set(dbRouter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
