package com.xiaoan.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoan.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : little_ann
 * @Date : 2023/03/19/23:29
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
