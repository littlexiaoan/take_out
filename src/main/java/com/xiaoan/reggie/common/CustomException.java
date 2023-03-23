package com.xiaoan.reggie.common;

/**
 * @author : little_ann
 * @Date : 2023/03/23/15:26
 */

/**
 *
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
