package com.wx.proxy.dbroute.proxy;

import com.wx.proxy.dbroute.IOrderService;
import com.wx.proxy.dbroute.Order;
import com.wx.proxy.dbroute.db.DynamicDataSourceEntry;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-17 16:36
 **/
public class OrderServiceStaticProxy implements IOrderService{
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );
        DynamicDataSourceEntry.set(dbRouter);

        this.orderService.createOrder(order);
        DynamicDataSourceEntry.restore();
        after();
        return 0;
    }

    private void  before(){
        System.out.println("Proxy before method");
    }

    private void after(){
        System.out.println("Proxy after method");
    }

}
