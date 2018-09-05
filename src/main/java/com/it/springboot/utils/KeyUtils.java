package com.it.springboot.utils;/**
 * Created by sunrise on 2018/9/4.
 */

import java.util.Random;

/**
 * @ClassName KeyUtils
 * @Description id生成工具类
 * @Author sunrise
 * @Date 2018/9/4 16:25
 * @Version 1.0
 */
public class KeyUtils {

    public static synchronized String getKey(){
        Random random = new Random();
        Integer num = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(num);
    }

}








