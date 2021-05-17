package com.wx.builder.sql;

import java.util.Arrays;

/**
 * @program: design-pattern-with-java
 * @description: sql测试类
 * @author: Mr.Wang
 * @create: 2021-04-26 15:30
 **/
public class test {
    static void main(String[] args) {

        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addAscOrder("age")
                .andEqual("addr","Changsha")
                .andLike("name","Tom")
                .andGreaterEqual("age",18);

        QueryRuleSqlBuilder builder = new QueryRuleSqlBuilder(queryRule);

        System.out.println(builder.builder("t_member"));

        System.out.println("Params: " + Arrays.toString(builder.getValues()));

    }
}
