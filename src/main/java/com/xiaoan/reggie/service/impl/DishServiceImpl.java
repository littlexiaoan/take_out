package com.xiaoan.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoan.reggie.entity.Dish;
import com.xiaoan.reggie.mapper.DishMapper;
import com.xiaoan.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : little_ann
 * @Date : 2023/03/23/15:13
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
