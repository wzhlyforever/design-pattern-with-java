package com.wx.prototype;


/**
 * @program: design-pattern-with-java
 * @description: 原型模式的通用写法
 * @author: Mr.Wang
 * @create: 2021-04-24 23:41
 **/
public class Client {


    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototypeA prototypeA = new ConcretePrototypeA("originaA");
        System.out.println(prototypeA);
        
        //复制原型对象
        ConcretePrototypeA clonetotypeA = prototypeA.clone();
        clonetotypeA.desc="clone";
        System.out.println(clonetotypeA);

        //创建原型对象
        ConcretePrototypeB prototypeB = new ConcretePrototypeB("originaB");
        System.out.println(prototypeB);

        //复制原型对象
        ConcretePrototypeB clonetotypeB = prototypeB.clone();
        clonetotypeB.desc="clone";
        System.out.println(clonetotypeB);
        
        
    }
    
    interface Iprototype<T> {
        T clone();
    }
    
    static class ConcretePrototypeB implements Iprototype<ConcretePrototypeB>{
        
        private String desc;


        public ConcretePrototypeB(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "ConcretePrototypeB{" +
                    "desc='" + desc + '\'' +
                    '}';
        }

        public ConcretePrototypeB clone() {
            return new ConcretePrototypeB(this.desc);
        }
    }
    static class ConcretePrototypeA implements Iprototype<ConcretePrototypeA>{
        
        private String desc;


        public ConcretePrototypeA(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "ConcretePrototypeB{" +
                    "desc='" + desc + '\'' +
                    '}';
        }

        public ConcretePrototypeA clone() {
            return new ConcretePrototypeA(this.desc);
        }
    }
}
