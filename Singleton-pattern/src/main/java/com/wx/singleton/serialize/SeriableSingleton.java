package com.wx.singleton.serialize;

import java.io.*;
import java.time.Instant;

/**
 * @program: design-pattern-with-java
 * @description: 反序列化破坏单例模式
 * @author: Mr.Wang
 * @create: 2021-04-26 23:14
 **/
public class SeriableSingleton implements Serializable {

    /*
    序列化 就是指把内存中的状态转为二进制的字节码，从而转换成io流，写入其他地方可以是网络，文件
    反序列化 就是将已经持久化的字节码内容转换为io流， 再通过io流的读取，进而将读取的内容转换为java对象
     */

    public final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton(){};

    public static SeriableSingleton getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        SeriableSingleton s1 = null;
        SeriableSingleton s2 = SeriableSingleton.getInstance();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("seriableSingleton.obj");

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("seriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingleton) ois.readObject();
            ois.close();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 ==s2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    反序列化的对象和手动创建的对象不一致，被实例化了两次
     */
}
