package com.xiaoan.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoan.reggie.entity.Employee;
import com.xiaoan.reggie.mapper.EmployeeMapper;
import com.xiaoan.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author : little_ann
 * @Date : 2023/03/19/23:31
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
