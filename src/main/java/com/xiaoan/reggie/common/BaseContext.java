package com.xiaoan.reggie.common;

/**
 * @author : little_ann
 * @Date : 2023/03/21/20:50
 */

/**
 * 基于ThreadLocal封装工具类，用于保存和获取当前登陆用户的id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
