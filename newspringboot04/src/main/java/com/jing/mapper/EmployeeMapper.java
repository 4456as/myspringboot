package com.jing.mapper;

import com.jing.bean.Employee;
//配置文件版的mybatis
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
    public void insertEmp(Employee employee);
}
