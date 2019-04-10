package com.jing.controller;

import com.jing.bean.Department;
import com.jing.bean.Employee;
import com.jing.mapper.DepartmentMapper;
import com.jing.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;//注解版的mybatis

    @Autowired
    EmployeeMapper employeeMapper;//配置文件版的mybatis

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }
    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
    @GetMapping("/emp/{id}")
    public Employee geEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

}
