package com.wx.decorator.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-08-18 18:18
 **/
public class JsonLoggerFactory {

    public static Logger getLogger(Class<?> clazz){
        Logger logger = LoggerFactory.getLogger(clazz);
        return new JsonLogger(logger);
    }
}
