package com.wx.proxy.dbroute;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-17 16:15
 **/
public class OrderService implements IOrderService{

    private OrderDao orderDao;

    public OrderService(){
        orderDao = new OrderDao();
    }


    public int createOrder(Order order) {
        System.out.println("OrderService 调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
