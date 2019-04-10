package com.jing.service;

import com.jing.bean.Department;
import com.jing.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

//@CacheConfig(cacheManager = "deptRedisCacheManager")
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("deptRedisCacheManager")
    @Autowired
    RedisCacheManager deptRedisCacheManager;
//注解的方式缓存
    @Cacheable(value="dept",cacheManager = "deptRedisCacheManager")
    public Department getDeptById(Integer id){
        System.out.println("查询部门："+id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }
//编码的方式缓存
    public Department getDeptById2(Integer id){
        System.out.println("查询部门："+id);
        Department department = departmentMapper.getDeptById(id);

        Cache dept = deptRedisCacheManager.getCache("dept");
        dept.put("dept:1",department);
        return department;
    }
}
