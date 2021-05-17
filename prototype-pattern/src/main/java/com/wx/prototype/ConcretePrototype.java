package com.wx.prototype;

import lombok.Data;

import java.io.*;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-04-25 11:17
 **/

@Data
public class ConcretePrototype implements Cloneable, Serializable {
    /*
    如果类中存在引用对象属性，则原型对象和克隆对象的该属性会指向同一对象的引用
     */
    private int age;
    private String name;
    List<String> hobbies;

    @Override
    protected ConcretePrototype clone(){
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ConcretePrototype deepClone(){

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ConcretePrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototype prototype=new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("tom");
        var hobbies = new ArrayList<String>();

        hobbies.add("书法");
        hobbies.add("美术");

        prototype.setHobbies(hobbies);

        System.out.println(prototype);

        //copy prototye
        ConcretePrototype cloneType = prototype.deepClone();
        cloneType.getHobbies().add("技术控");
        System.out.println("原型对象： " + prototype);
        System.out.println("克隆对象：" + cloneType);

        System.out.println(prototype == cloneType);


        // hobbies 共用了一个内存地址，意味着复制的不是值而是引用的地址，这就是我们常常所说的浅克隆，只是完整的复制了值类型数据，没有复制引用对象


    }
}
