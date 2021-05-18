package com.wx.proxy.dynamicProxy.jdkProxy;


import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-17 12:47
 **/
public class Test {
    public static void main(String[] args) {
        try {
            Iperson obj = ((Iperson)new JdkMeipo().getInstance(new Zhangsan()));
            obj.findLove();

            //通过反编译工具可以查看源代码
            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Iperson.class});
            FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

