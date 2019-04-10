package com.jing.controller;

import com.jing.bean.Department;
import com.jing.bean.Employee;
import com.jing.mapper.DepartmentMapper;
import com.jing.mapper.EmployeeMapper;
import com.jing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
//    @Autowired
//    DepartmentMapper departmentMapper;//注解版的mybatis

    @Autowired
    EmployeeService employeeService;//配置文件版的mybatis

//    @GetMapping("/dept/{id}")
//    public Department getDepartment(@PathVariable("id") Integer id){
//        return departmentMapper.getDeptById(id);
//    }
//    @GetMapping("/dept")
//    public Department insertDept(Department department){
//        departmentMapper.insertDept(department);
//        return department;
//    }
    @GetMapping("/emp/{id}")
    public Employee geEmp(@PathVariable("id") Integer id){
        return employeeService.getEmp(id);
    }
    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }
    @GetMapping("/delemp")
    public String deleteEmpById(Integer id){
        employeeService.deleteEmpById(id);
        return "success";
    }
    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
