package com.xiaoan.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaoan.reggie.common.R;
import com.xiaoan.reggie.entity.Employee;
import com.xiaoan.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author : little_ann
 * @Date : 2023/03/19/23:32
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工登陆
     *
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        //1.将页面提交的密码password进行md5加密处理
        String password = employee.getPassword();
        //DigestUtils加密工具类
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2.根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        //3.如果没有查询到则返回登陆失败结果
        if (emp == null) {
            return R.error("登陆失败");
        }

        //4.密码比对，如果不一致则返回登陆失败结果
        if (!emp.getPassword().equals(password)) {
            return R.error("登陆失败");
        }

        //5.查询员工状态，如果为已禁用状态，则返回员工已禁用结果
        if (emp.getStatus() == 0) {
            return R.error("账号已禁用");
        }

        //6.登陆成功，将员工id存入session并返回登陆成功结果
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }

    /**
     * 员工退出
     *
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        //清理session中保存的当前登陆员工的id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }
}
