package com.xiaoan.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoan.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : little_ann
 * @Date : 2023/03/23/15:10
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
