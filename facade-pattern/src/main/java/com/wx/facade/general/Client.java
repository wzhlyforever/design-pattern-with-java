package com.wx.facade.general;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @program: design-pattern-with-java
 * @description: 门面模式的通用写法
 * @author: Mr.Wang
 * @create: 2021-05-18 11:02
 **/
public class Client {


    public static void main(String[] args) {
        final Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();

    }


    static class SubSystemA {
        public void doA() {
            System.out.println("doing A stuff");
        }
    }

    static class SubSystemB {
        public void doB() {
            System.out.println("doing B stuff");
        }
    }

    static class SubSystemC {
        public void doC() {
            System.out.println("doing C stuff");
        }
    }
    // 外观角色
    static class Facade {
        private SubSystemA subSystemA = new SubSystemA();
        private SubSystemB subSystemB = new SubSystemB();
        private SubSystemC subSystemC = new SubSystemC();
        //对外接口
        public void doA() {
            this.doA();
        }

        public void doB() {
            this.doB();
        }

        public void doC() {
            this.doC();
        }
    }


}
