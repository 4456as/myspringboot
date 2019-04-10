package com.jing.controller;

import com.jing.bean.Department;
import com.jing.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }

    @GetMapping("/dept2/{id}")
    public Department getDeptById2(@PathVariable("id") Integer id){
        return departmentService.getDeptById2(id);
    }
}
