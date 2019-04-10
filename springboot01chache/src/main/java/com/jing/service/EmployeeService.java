package com.jing.service;

import com.jing.bean.Employee;
import com.jing.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

//@CacheConfig(cacheNames = "emp")  缓存公共配置  可以统一命名
//@CacheConfig(cacheManager = "empRedisCacheManager")
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    // 将方法的运行结果进行缓存
    //key = "#root.methodName+'['+#id+']'-----key=getEmp[2]
    //@Cacheable(cacheNames = {"emp"},key = "#root.methodName+'['+#id+']'")
    //unless为true则不缓存，与condition相反
    @Cacheable(cacheNames = {"emp"},keyGenerator = "myKeyGenerator",condition = "#a0>100",unless="#a0==102")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
    //每次都先调用方法再缓存
    @CachePut(value = "emp",key = "#employee.id")//or key = "#result.id"
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }
    //allEntries = true清除所有缓存
    //指定id：缓存清除emp中的id
    @CacheEvict(value = "emp",key = "'getEmp[['+#id+']]'")
    public void deleteEmpById(Integer id){
        System.out.println("deleteEmp:"+id);
//        employeeMapper.deleteEmpById(id);
    }
    @Caching(
        cacheable = {
                @Cacheable(value = "emp",key = "#lastName",cacheManager = "empRedisCacheManager")
        },
        put = {
                @CachePut(value = "emp",key = "#result.id"),
                @CachePut(value = "emp",key = "#result.email")
        }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }
}
