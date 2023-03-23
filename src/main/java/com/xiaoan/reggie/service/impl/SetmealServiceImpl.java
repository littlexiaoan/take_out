package com.xiaoan.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoan.reggie.entity.Setmeal;
import com.xiaoan.reggie.mapper.SetmealMapper;
import com.xiaoan.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : little_ann
 * @Date : 2023/03/23/15:13
 */
@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
