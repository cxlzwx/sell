package com.it.springboot.utils;/**
 * Created by sunrise on 2018/9/4.
 */

import com.it.springboot.vo.Result;

/**
 * @ClassName ResultUtil
 * @Description 返回结果集工具类
 * @Author sunrise
 * @Date 2018/9/4 11:52
 * @Version 1.0
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result<>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static Result success(){
        Result result = new Result<>();
        result.setData(null);
        return result;
    }
    public static Result error(Integer code,String msg){
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}












