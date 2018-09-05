package com.it.springboot;/**
 * Created by sunrise on 2018/8/3.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName LoggerTest
 * @Description 日志测试
 * @Author sunrise
 * @Date 2018/8/3 20:54
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class LoggerTest {
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        String name = "imooc";
        String password = "1234";
        logger.info("info.....");
        logger.info("name:"+name+",password:"+password);
        logger.info("name:{},password:{}",name,password);
        logger.error("error.....");
        logger.debug("debug.....");
    }
}
