package com.xiaoan.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoan.reggie.entity.Category;

/**
 * @author : little_ann
 * @Date : 2023/03/22/21:05
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long ids);
}
