package com.wx.builder.sql;

/**
 * @program: design-pattern-with-java
 * @description: SQL排序组件
 * @author: Mr.Wang
 * @create: 2021-04-25 22:14
 **/
public class Order {

    private boolean ascending; //升序还是降序
    private String propertyName; //哪个字段升序，哪个字段降序
    // age asc
    public String toString() {
        return propertyName + ' ' + (ascending ? "asc" : "desc");
    }

    /**
     * Constructor for Order.
     */
    protected Order(String propertyName, boolean ascending) {
        this.propertyName = propertyName;
        this.ascending = ascending;
    }

    /**
     * Ascending order
     *
     * @param propertyName
     * @return Order
     */
    public static Order asc(String propertyName) {
        return new Order(propertyName, true);
    }

    /**
     * Descending order
     *
     * @param propertyName
     * @return Order
     */
    public static Order desc(String propertyName) {
        return new Order(propertyName, false);
    }

}
