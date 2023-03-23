package com.xiaoan.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoan.reggie.common.CustomException;
import com.xiaoan.reggie.entity.Category;
import com.xiaoan.reggie.entity.Dish;
import com.xiaoan.reggie.entity.Setmeal;
import com.xiaoan.reggie.mapper.CategoryMapper;
import com.xiaoan.reggie.service.CategoryService;
import com.xiaoan.reggie.service.DishService;
import com.xiaoan.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : little_ann
 * @Date : 2023/03/22/21:06
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类。删除之前需要进行判断
     *
     * @param ids
     */
    @Override
    public void remove(Long ids) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, ids);
        long count1 = dishService.count(dishLambdaQueryWrapper);

        //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        if (count1 > 0) {
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前分类下关联了菜品，不能删除");

        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, ids);
        long count2 = setmealService.count();
        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        if (count2 > 0) {
            //已经关联套餐，抛出一个业务异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }
        //正常删除分类
        super.removeById(ids);//调用父类--->ServiceImpl的方法
    }
}
