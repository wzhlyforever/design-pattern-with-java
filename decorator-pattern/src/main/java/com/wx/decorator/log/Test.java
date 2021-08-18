package com.wx.decorator.log;


import org.slf4j.Logger;

import java.io.*;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-08-18 18:20
 **/
public class Test {

    private static final Logger logger = JsonLoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.error("系统错误");
        try {

            InputStream in = new FileInputStream("test.txt");

            // 字节缓存流
            BufferedInputStream bis = new BufferedInputStream(in);

            bis.read();
            bis.close();



            BufferedReader br = new BufferedReader(new FileReader(""));
            br.readLine();

            BufferedReader bs = new BufferedReader(new StringReader(""));
            bs.readLine();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
